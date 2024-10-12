package lordruby.corruptednether.blocks;

import lordruby.corruptednether.init.BlockInit;
import net.minecraft.block.*;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class VisciousVines extends TwistingVinesBlock  {
    public VisciousVines(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState floor =  world.getBlockState(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()));
        return !floor.isAir();
    }

    @Override
    protected Block asBlock() {
        return BlockInit.VISCIOUS_VINES;
    }

    @Override
    protected Block getPlant() {
        return BlockInit.VISCIOUS_VINES;
    }
}
