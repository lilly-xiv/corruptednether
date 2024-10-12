package lordruby.corruptednether.provider;
import lordruby.corruptednether.init.BlockInit;
import lordruby.corruptednether.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class CorruptedNetherBlockLootTableProvider extends FabricBlockLootTableProvider {

    public CorruptedNetherBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate(){
        addDrop(BlockInit.CORRUPTED_STEM);
        addDrop(BlockInit.CORRUPTED_HYPHAE);
        addDrop(BlockInit.STRIPPED_CORRUPTED_HYPHAE);
        addDrop(BlockInit.CORRUPTED_PLANKS);
        addDrop(BlockInit.CORRUPTED_SLAB);
        addDrop(BlockInit.CORRUPTED_STAIRS);
        addDrop(BlockInit.CORRUPTED_FENCE);
        addDrop(BlockInit.CORRUPTED_FENCE_GATE);
        doorDrops(BlockInit.CORRUPTED_DOOR);
        addDrop(BlockInit.CORRUPTED_TRAPDOOR);
        addDrop(BlockInit.CORRUPTED_BUTTON);
        addDrop(BlockInit.CORRUPTED_PRESSURE_PLATE);
        addDrop(BlockInit.CORRUPTED_SIGN, ItemInit.CORRUPTED_SIGN);
        addDrop(BlockInit.CORRUPTED_WALL_SIGN, ItemInit.CORRUPTED_SIGN);
        addDrop(BlockInit.CORRUPTED_HANGING_SIGN, ItemInit.CORRUPTED_HANGING_SIGN);
        addDrop(BlockInit.CORRUPTED_WALL_HANGING_SIGN, ItemInit.CORRUPTED_HANGING_SIGN);
        addDrop(BlockInit.VISCIOUS_ROOTS);
        addDrop(BlockInit.VISCIOUS_FUNGUS);
        addVinePlantDrop(BlockInit.VISCIOUS_VINES, BlockInit.VISCIOUS_VINES);
        //addDrop(BlockInit.CORRUPTED_NYLIUM, dropsWithSilkTouch(BlockInit.CORRUPTED_NYLIUM));
        addDrop(BlockInit.CORRUPTED_WART_BLOCK);
        addDrop(BlockInit.CURSELIGHT);
        addDrop(BlockInit.STRIPPED_CORRUPTED_STEM);
    }
}
