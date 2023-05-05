package heyblack.elytraactivationfix.mixin;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
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
        /*if (!((PlayerEntity) (Object) this).doesNotCollide(0, -0.25, 0))
            cir.cancel();*/
        BlockPos pos = ((EntityInvoker) this).getLandingPosInvoker();
        if (((PlayerEntity) (Object) this).world.getBlockState(pos).getFluidState().isEmpty())
            if (!((PlayerEntity) (Object) this).world.getBlockState(pos).isAir())
                cir.cancel();
    }

}
