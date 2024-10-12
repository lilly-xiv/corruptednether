package lordruby.corruptednether.init;

import com.jcraft.jorbis.Block;
import lordruby.corruptednether.CorruptedNether;
import lordruby.corruptednether.customfeatures.VisciousVinesFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ClampedIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ConfiguredFeatureInit {

    public static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(Registries.FEATURE, name, feature);
    }

    //public static Feature<TwistingVinesFeatureConfig> CORRUPTED_VINES_FEATURE;

    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_VEGETATION = registerKey("corrupted_vegetation");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_ROOT = registerKey("corrupted_root");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_FUNGII = registerKey("corrupted_fungii");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_FUNGUS = registerKey("corrupted_fungus");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_VINES = registerKey("corrupted_vines");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_VINE = registerKey("corrupted_vine");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_PATCH = registerKey("corrupted_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_PATCH_FUNGUS = registerKey("corrupted_patch_fungus");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_PATCH_VINES = registerKey("corrupted_patch_vines");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_TREE = registerKey("corrupted_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_TREE_PLANTED = registerKey("corrupted_tree_planted");

    public static final RegistryKey<ConfiguredFeature<?, ?>> FUCHSITE_BLOB = registerKey("fuchsite_blob");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FUCHSITE_ORE = registerKey("fuchsite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTED_FIRE_PATCH = registerKey("corrupted_fire_patch");
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){

        RegistryEntryLookup<PlacedFeature> registryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        register(context, CORRUPTED_ROOT, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(BlockInit.VISCIOUS_ROOTS)));
        register(context, CORRUPTED_VEGETATION, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        200,
                        12,
                        12,
                        registryLookup.getOrThrow(PlacedFeatureInit.PLACED_CORRUPTED_ROOT)));

        register(context, CORRUPTED_FUNGUS, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(BlockInit.VISCIOUS_FUNGUS)));
        register(context, CORRUPTED_FUNGII, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        40,
                        8,
                        4,
                        registryLookup.getOrThrow(PlacedFeatureInit.PLACED_CORRUPTED_FUNGUS)));

        register(context, CORRUPTED_VINE, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(BlockInit.VISCIOUS_VINES)));
        register(context, CORRUPTED_VINES, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        40,
                        8,
                        4,
                        registryLookup.getOrThrow(PlacedFeatureInit.PLACED_CORRUPTED_VINE)));
        register(context, CORRUPTED_PATCH, Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationFeatureConfig(BlockStateProvider.of(BlockInit.VISCIOUS_ROOTS.getDefaultState()), 16, 5));
        register(context, CORRUPTED_PATCH_FUNGUS, Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationFeatureConfig(BlockStateProvider.of(BlockInit.VISCIOUS_FUNGUS.getDefaultState()), 12, 5));
        BlockPredicate blockPredicate = BlockPredicate.matchingBlocks(
                BlockInit.VISCIOUS_FUNGUS,
                BlockInit.VISCIOUS_VINES
        );
        BlockPredicate blockPredicate2 = BlockPredicate.matchingBlocks(
                BlockInit.VISCIOUS_FUNGUS
        );
        register(context, CORRUPTED_TREE, Feature.HUGE_FUNGUS, new HugeFungusFeatureConfig(
                BlockInit.CORRUPTED_NYLIUM.getDefaultState(),
                BlockInit.CORRUPTED_STEM.getDefaultState(),
                BlockInit.CORRUPTED_WART_BLOCK.getDefaultState(),
                BlockInit.CURSELIGHT.getDefaultState(),
                blockPredicate,
                false
        ));

        register(context, CORRUPTED_TREE_PLANTED, Feature.HUGE_FUNGUS, new HugeFungusFeatureConfig(
                BlockInit.CORRUPTED_NYLIUM.getDefaultState(),
                BlockInit.CORRUPTED_STEM.getDefaultState(),
                BlockInit.CORRUPTED_WART_BLOCK.getDefaultState(),
                BlockInit.CURSELIGHT.getDefaultState(),
                blockPredicate,
                true
        ));
        register(context, CORRUPTED_PATCH_VINES, Feature.HUGE_RED_MUSHROOM, new HugeMushroomFeatureConfig(
                BlockStateProvider.of(Blocks.AIR.getDefaultState()),
                BlockStateProvider.of(BlockInit.VISCIOUS_VINES.getDefaultState()),
    0
        ));

        register(context, FUCHSITE_BLOB, Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), BlockInit.FUCHSITE.getDefaultState(),  UniformIntProvider.create(5, 10)));
        register(context, FUCHSITE_ORE, Feature.ORE, new OreFeatureConfig(new BlockMatchRuleTest(Blocks.NETHERRACK), BlockInit.FUCHSITE.getDefaultState(), 50));


        register(context, CORRUPTED_FIRE_PATCH, Feature.RANDOM_PATCH,ConfiguredFeatures.createRandomPatchFeatureConfig(
                Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.CORRUPTED_FIRE)), List.of(BlockInit.CORRUPTED_NYLIUM, BlockInit.CORRUPTED_WART_BLOCK)
        ));
    }

    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(CorruptedNether.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?,?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?,?>> key,
                                                                                   F feature,
                                                                                   FC featureConfig){
        context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }
}
