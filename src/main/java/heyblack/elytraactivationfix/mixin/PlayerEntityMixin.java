package heyblack.elytraactivationfix.mixin;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(PlayerEntity.class)
public class PlayerEntityMixin
{
    @Inject(method = "checkFallFlying", at = @At("HEAD"), cancellable = true)
    public void checkFloor(CallbackInfoReturnable<Boolean> cir)
    {
        if (!((PlayerEntity) (Object) this).doesNotCollide(0, -0.25, 0))
            cir.cancel();
    }
}
