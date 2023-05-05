package heyblack.elytraactivationfix.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface EntityInvoker
{
    @Invoker("getLandingPos")
    public BlockPos getLandingPosInvoker();
}
