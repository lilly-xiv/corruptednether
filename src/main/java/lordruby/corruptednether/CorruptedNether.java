package lordruby.corruptednether;

import lordruby.corruptednether.customfeatures.VisciousVinesFeature;
import lordruby.corruptednether.init.*;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.AxeItem;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TwistingVinesFeatureConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class CorruptedNether implements ModInitializer {
	public static final String MOD_ID = "corruptednether";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ItemInit.load();
		BlockInit.load();
		BoatInit.load();
		ParticleInit.load();
		AxeItem.STRIPPED_BLOCKS = new HashMap<>(AxeItem.STRIPPED_BLOCKS);
		//ConfiguredFeatureInit.CORRUPTED_VINES_FEATURE = Registry.register(Registries.FEATURE, Identifier.of(MOD_ID, "corrupted_vines_feature"), new VisciousVinesFeature(TwistingVinesFeatureConfig.CODEC));
		AxeItem.STRIPPED_BLOCKS.put(BlockInit.CORRUPTED_STEM, BlockInit.STRIPPED_CORRUPTED_STEM);
		AxeItem.STRIPPED_BLOCKS.put(BlockInit.CORRUPTED_HYPHAE, BlockInit.STRIPPED_CORRUPTED_HYPHAE);
		LOGGER.info("Hello Fabric world!");

	}
}