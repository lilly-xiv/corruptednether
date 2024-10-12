package lordruby.corruptednether.blocks;

import com.mojang.serialization.MapCodec;
import lordruby.corruptednether.init.BlockInit;
import lordruby.corruptednether.tags.CorruptedNetherTags;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class CorruptedFire extends AbstractFireBlock {

    public static final MapCodec<CorruptedFire> CODEC = createCodec(CorruptedFire::new);
    public CorruptedFire(AbstractBlock.Settings settings) {
        super(settings, 2.0F);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return this.canPlaceAt(state, world, pos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return isSoulBase(world.getBlockState(pos.down()));
    }

    public static boolean isSoulBase(BlockState state) {
        return state.isIn(CorruptedNetherTags.CORRUPTED_FIRE_BLOCKS);
    }

    @Override
    protected MapCodec<? extends AbstractFireBlock> getCodec() {

        return CODEC;
    }

    @Override
    protected boolean isFlammable(BlockState state) {
        return true;
    }
}
