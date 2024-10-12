package lordruby.corruptednether.blocks;

import lordruby.corruptednether.CorruptedNether;
import lordruby.corruptednether.init.BlockInit;
import lordruby.corruptednether.init.ConfiguredFeatureInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NyliumBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.NetherConfiguredFeatures;

public class CorruptedNylium extends NyliumBlock {
    public CorruptedNylium(Settings settings) {
        super(settings);
    }


    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockState blockState = world.getBlockState(pos);
        BlockPos blockPos = pos.up();
        ChunkGenerator chunkGenerator = world.getChunkManager().getChunkGenerator();
        Registry<ConfiguredFeature<?, ?>> registry = world.getRegistryManager().get(RegistryKeys.CONFIGURED_FEATURE);
        if (blockState.isOf(BlockInit.CORRUPTED_NYLIUM)) {
            super.generate(registry, ConfiguredFeatureInit.CORRUPTED_VEGETATION , world, chunkGenerator, random, blockPos);
            super.generate(registry, ConfiguredFeatureInit.CORRUPTED_FUNGII , world, chunkGenerator, random, blockPos);
            if (random.nextInt(8) == 0) {
                //super.generate(registry, ConfiguredFeatureInit.CORRUPTED_VINES, world, chunkGenerator, random, blockPos);
            }
        }
    }
}
