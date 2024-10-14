package lordruby.corruptednether.init;

import lordruby.corruptednether.CorruptedNether;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.List;

import static lordruby.corruptednether.init.PlacedFeatureInit.Modifiers.modifiersWithCount;

@SuppressWarnings("deprecation")
public class PlacedFeatureInit {
    public static final RegistryKey<PlacedFeature> PLACED_CORRUPTED_VEGETATION = registerKey("corrupted_vegetation");
    public static final RegistryKey<PlacedFeature> PLACED_CORRUPTED_ROOT = registerKey("corrupted_root");

    public static final RegistryKey<PlacedFeature> PLACED_CORRUPTED_FUNGII = registerKey("corrupted_fungii");
    public static final RegistryKey<PlacedFeature> PLACED_CORRUPTED_FUNGUS = registerKey("corrupted_fungus");

    public static final RegistryKey<PlacedFeature> PLACED_CORRUPTED_VINES = registerKey("corrupted_vines");
    public static final RegistryKey<PlacedFeature> PLACED_CORRUPTED_VINE = registerKey("corrupted_vine");

    public static final RegistryKey<PlacedFeature> PLACED_CORRUPTED_PATCH = registerKey("corrupted_patch");
    public static final RegistryKey<PlacedFeature> PLACED_CORRUPTED_PATCH_FUNGUS = registerKey("corrupted_patch_fungus");
    public static final RegistryKey<PlacedFeature> PLACED_CORRUPTED_PATCH_VINES = registerKey("corrupted_patch_vines");

    public static final RegistryKey<PlacedFeature> PLACED_CORRUPTED_TREE = registerKey("corrupted_tree");
    public static final RegistryKey<PlacedFeature> PLACED_CORRUPTED_TREE_PLANTED = registerKey("corrupted_tree_planted");
    public static final RegistryKey<PlacedFeature> PLACED_FUCHSITE_BLOB = registerKey("fuchsite_blob");
    public static final RegistryKey<PlacedFeature> PLACED_FUCHSITE_ORE = registerKey("fuchsite_ore");
    public static final RegistryKey<PlacedFeature> PLACED_CORRUPTED_FIRE_PATCH = registerKey("corrupted_fire_patch");
    private static RegistryKey<PlacedFeature> registerKey(String name){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(CorruptedNether.MOD_ID, name));
    }
    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> config,
                                 List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }
    public static void bootstrap(Registerable<PlacedFeature> context){
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, PLACED_CORRUPTED_ROOT, registryLookup.getOrThrow(ConfiguredFeatureInit.CORRUPTED_ROOT),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR)));

        register(context, PLACED_CORRUPTED_VEGETATION, registryLookup.getOrThrow(ConfiguredFeatureInit.CORRUPTED_VEGETATION),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR)));

        register(context, PLACED_CORRUPTED_FUNGUS, registryLookup.getOrThrow(ConfiguredFeatureInit.CORRUPTED_FUNGUS),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR)));

        register(context, PLACED_CORRUPTED_FUNGII, registryLookup.getOrThrow(ConfiguredFeatureInit.CORRUPTED_FUNGII),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR)));


        register(context, PLACED_CORRUPTED_VINE, registryLookup.getOrThrow(ConfiguredFeatureInit.CORRUPTED_VINE),
                List.of(CountMultilayerPlacementModifier.of(4)));

        register(context, PLACED_CORRUPTED_VINES, registryLookup.getOrThrow(ConfiguredFeatureInit.CORRUPTED_VINES),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR)));
        register(context, PLACED_CORRUPTED_PATCH, registryLookup.getOrThrow(ConfiguredFeatureInit.CORRUPTED_PATCH),
                List.of(CountMultilayerPlacementModifier.of(3)));

        register(context, PLACED_CORRUPTED_FIRE_PATCH, registryLookup.getOrThrow(ConfiguredFeatureInit.CORRUPTED_FIRE_PATCH),
                List.of(CountPlacementModifier.of(UniformIntProvider.create(0, 5)),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.FOUR_ABOVE_AND_BELOW_RANGE,
                        BiomePlacementModifier.of()));


        register(context, PLACED_CORRUPTED_PATCH_FUNGUS, registryLookup.getOrThrow(ConfiguredFeatureInit.CORRUPTED_PATCH_FUNGUS),
                List.of(CountMultilayerPlacementModifier.of(1)));

        register(context, PLACED_CORRUPTED_PATCH_VINES, registryLookup.getOrThrow(ConfiguredFeatureInit.CORRUPTED_PATCH_VINES),
                List.of(CountMultilayerPlacementModifier.of(2)));

        register(context, PLACED_CORRUPTED_TREE, registryLookup.getOrThrow(ConfiguredFeatureInit.CORRUPTED_TREE),
                List.of(CountMultilayerPlacementModifier.of(4)));

        register(context, PLACED_CORRUPTED_TREE_PLANTED, registryLookup.getOrThrow(ConfiguredFeatureInit.CORRUPTED_TREE_PLANTED),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR)));

        register(context, PLACED_FUCHSITE_BLOB, registryLookup.getOrThrow(ConfiguredFeatureInit.FUCHSITE_BLOB),
                List.of(CountPlacementModifier.of(25),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.BOTTOM_TO_TOP_RANGE));

        register(context, PLACED_FUCHSITE_ORE, registryLookup.getOrThrow(ConfiguredFeatureInit.FUCHSITE_ORE),
                modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(5), YOffset.fixed(31))));
    }
    public static class Modifiers {
        public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
            return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
        }

        public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
            return modifiers(CountPlacementModifier.of(count), heightModifier);
        }

    }
}
