package lordruby.corruptednether.mixin;

import lordruby.corruptednether.blocks.CorruptedFire;
import lordruby.corruptednether.init.BlockInit;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractFireBlock.class)
public class CorruptedFireMixin {
	@Inject(at = @At("HEAD"), method = "getState", cancellable = true)
	private static void init(BlockView world, BlockPos pos, CallbackInfoReturnable<BlockState> cir) {
		BlockPos blockPos = pos.down();
		BlockState blockState = world.getBlockState(blockPos);
		if(CorruptedFire.isSoulBase(blockState)) {
			cir.setReturnValue(BlockInit.CORRUPTED_FIRE.getDefaultState());
			cir.cancel();
		}
	}
}