package net.blumbo.creepersdropall.mixin;

import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CreeperEntity.class)
public class CreeperEntityMixin {

    @ModifyArg(method = "explode", index = 5, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;createExplosion(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/world/explosion/Explosion$DestructionType;)Lnet/minecraft/world/explosion/Explosion;"))
    private Explosion.DestructionType setDestructionType(Explosion.DestructionType destructionType) {
        if (destructionType == Explosion.DestructionType.DESTROY) return Explosion.DestructionType.BREAK;
        return destructionType;
    }

}
