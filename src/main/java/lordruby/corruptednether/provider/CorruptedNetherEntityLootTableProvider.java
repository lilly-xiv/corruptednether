package lordruby.corruptednether.provider;

import lordruby.corruptednether.CorruptedNether;
import lordruby.corruptednether.init.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class CorruptedNetherEntityLootTableProvider extends SimpleFabricLootTableProvider {
    public static final Identifier CORRUPTED_SKELETON_SHEARS = Identifier.of(CorruptedNether.MOD_ID, "entities/corrupted_skeleton_shears");
    public CorruptedNetherEntityLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup, LootContextTypes.ENTITY);
    }

    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(RegistryKey.of(RegistryKeys.LOOT_TABLE, CORRUPTED_SKELETON_SHEARS), LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(BlockInit.VISCIOUS_FUNGUS)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))))

                        .with(ItemEntry.builder(BlockInit.VISCIOUS_FUNGUS)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))))
        ));
    }
}
