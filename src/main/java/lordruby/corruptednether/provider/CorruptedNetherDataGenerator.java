package lordruby.corruptednether.provider;

import lordruby.corruptednether.init.ConfiguredFeatureInit;
import lordruby.corruptednether.init.PlacedFeatureInit;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class CorruptedNetherDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(CorruptedNetherModelProvider::new);
		pack.addProvider(CorruptedNetherRecipeProvider::new);
		pack.addProvider(CorruptedNetherBlockLootTableProvider::new);
		pack.addProvider(CorruptedNetherTagProvider::new);
		pack.addProvider(CorruptedNetherWorldGenerator::new);
		pack.addProvider(CorruptedNetherItemTagProvider::new);
		pack.addProvider(CorruptedNetherEntityLootTableProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatureInit::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatureInit::bootstrap);
	}
}
