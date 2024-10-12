package lordruby.corruptednether.provider;

import lordruby.corruptednether.init.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class CorruptedNetherItemTagProvider extends FabricTagProvider<Item> {
    public CorruptedNetherItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(BlockInit.CORRUPTED_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.STONE_CRAFTING_MATERIALS)
                .add(BlockInit.FUCHSITE.asItem());

        getOrCreateTagBuilder(ItemTags.STONE_TOOL_MATERIALS)
                .add(BlockInit.FUCHSITE.asItem());

        getOrCreateTagBuilder(ItemTags.SLABS)
                .add(BlockInit.FUCHSITE_SLAB.asItem())
                .add(BlockInit.POLISHED_FUCHSITE_SLAB.asItem())
                .add(BlockInit.POLISHED_FUCHSITE_BRICK_SLAB.asItem())
                .add(BlockInit.CORRUPTED_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.STAIRS)
                .add(BlockInit.FUCHSITE_STAIRS.asItem())
                .add(BlockInit.POLISHED_FUCHSITE_STAIRS.asItem())
                .add(BlockInit.POLISHED_FUCHSITE_BRICK_STAIRS.asItem())
                .add(BlockInit.CORRUPTED_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.BUTTONS)
                .add(BlockInit.POLISHED_FUCHSITE_BUTTON.asItem())
                .add(BlockInit.CORRUPTED_BUTTON.asItem());

        getOrCreateTagBuilder(ItemTags.DOORS)
                .add(BlockInit.CORRUPTED_DOOR.asItem());

        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(BlockInit.FUCHSITE_WALL.asItem())
                .add(BlockInit.POLISHED_FUCHSITE_WALL.asItem())
                .add(BlockInit.POLISHED_FUCHSITE_BRICK_WALL.asItem());

        getOrCreateTagBuilder(ItemTags.TRAPDOORS)
                .add(BlockInit.CORRUPTED_TRAPDOOR.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(BlockInit.CORRUPTED_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(BlockInit.CORRUPTED_BUTTON.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(BlockInit.CORRUPTED_DOOR.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(BlockInit.CORRUPTED_FENCE.asItem())
                .add(BlockInit.CORRUPTED_FENCE_GATE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(BlockInit.CORRUPTED_PRESSURE_PLATE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(BlockInit.CORRUPTED_TRAPDOOR.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(BlockInit.CORRUPTED_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD)
                .add(BlockInit.CORRUPTED_SLAB.asItem())
                .add(BlockInit.CORRUPTED_BUTTON.asItem())
                .add(BlockInit.CORRUPTED_DOOR.asItem())
                .add(BlockInit.CORRUPTED_FENCE.asItem())
                .add(BlockInit.CORRUPTED_FENCE_GATE.asItem())
                .add(BlockInit.CORRUPTED_PRESSURE_PLATE.asItem())
                .add(BlockInit.CORRUPTED_TRAPDOOR.asItem())
                .add(BlockInit.CORRUPTED_STEM.asItem())
                .add(BlockInit.CORRUPTED_HYPHAE.asItem())
                .add(BlockInit.STRIPPED_CORRUPTED_STEM.asItem())
                .add(BlockInit.STRIPPED_CORRUPTED_HYPHAE.asItem())
                .add(BlockInit.CORRUPTED_STAIRS.asItem());
    }
}