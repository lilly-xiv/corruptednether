package lordruby.corruptednether.blocks;

import lordruby.corruptednether.init.BlockInit;
import lordruby.corruptednether.init.ConfiguredFeatureInit;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Objects;

public class VisciousFungus extends RootsBlock implements Fertilizable {
    public VisciousFungus(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {

        return floor.isOf(Blocks.NETHERRACK) || floor.isOf(BlockInit.CORRUPTED_NYLIUM);
    }
    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return random.nextDouble() < 0.4;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        ChunkGenerator chunkGenerator = world.getChunkManager().getChunkGenerator();
        Registry<ConfiguredFeature<?, ?>> registry = world.getRegistryManager().get(RegistryKeys.CONFIGURED_FEATURE);
        Objects.requireNonNull(registry.get(ConfiguredFeatureInit.CORRUPTED_TREE_PLANTED)).generate(world, chunkGenerator, random, pos);
    }
}
