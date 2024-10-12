package lordruby.corruptednether.provider;

import lordruby.corruptednether.init.BlockInit;
import lordruby.corruptednether.tags.CorruptedNetherTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class CorruptedNetherTagProvider extends FabricTagProvider<Block> {
    public CorruptedNetherTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BLOCK, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(BlockInit.VISCIOUS_VINES);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(BlockInit.CURSELIGHT)
                .add(BlockInit.CORRUPTED_WART_BLOCK);

        getOrCreateTagBuilder(BlockTags.MUSHROOM_GROW_BLOCK)
                .add(BlockInit.CORRUPTED_NYLIUM);

        getOrCreateTagBuilder(BlockTags.NYLIUM)
                .add(BlockInit.CORRUPTED_NYLIUM);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(BlockInit.CORRUPTED_NYLIUM)
                .add(BlockInit.CORRUPTED_LANTERN)
                .add(BlockInit.FUCHSITE)
                .add(BlockInit.FUCHSITE_SLAB)
                .add(BlockInit.FUCHSITE_WALL)
                .add(BlockInit.FUCHSITE_STAIRS)
                .add(BlockInit.POLISHED_FUCHSITE)
                .add(BlockInit.POLISHED_FUCHSITE_SLAB)
                .add(BlockInit.POLISHED_FUCHSITE_STAIRS)
                .add(BlockInit.POLISHED_FUCHSITE_WALL)
                .add(BlockInit.CHISELED_POLISHED_FUCHSITE)
                .add(BlockInit.POLISHED_FUCHSITE_BRICKS)
                .add(BlockInit.POLISHED_FUCHSITE_BRICK_SLAB)
                .add(BlockInit.POLISHED_FUCHSITE_BRICK_STAIRS)
                .add(BlockInit.POLISHED_FUCHSITE_BRICK_WALL)
                .add(BlockInit.POLISHED_FUCHSITE_PRESSURE_PLATE)
                .add(BlockInit.POLISHED_FUCHSITE_BUTTON);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(BlockInit.CORRUPTED_BUTTON)
                .add(BlockInit.CORRUPTED_FENCE)
                .add(BlockInit.CORRUPTED_FENCE_GATE)
                .add(BlockInit.CORRUPTED_HANGING_SIGN)
                .add(BlockInit.CORRUPTED_PLANKS)
                .add(BlockInit.CORRUPTED_PRESSURE_PLATE)
                .add(BlockInit.CORRUPTED_SIGN)
                .add(BlockInit.CORRUPTED_SLAB)
                .add(BlockInit.CORRUPTED_STEM)
                .add(BlockInit.CORRUPTED_TRAPDOOR)
                .add(BlockInit.CORRUPTED_WALL_HANGING_SIGN)
                .add(BlockInit.CORRUPTED_WALL_SIGN)
                .add(BlockInit.STRIPPED_CORRUPTED_HYPHAE)
                .add(BlockInit.STRIPPED_CORRUPTED_STEM)
                .add(BlockInit.CORRUPTED_HYPHAE)
                .add(BlockInit.CORRUPTED_CAMPFIRE);

        getOrCreateTagBuilder(BlockTags.BASE_STONE_NETHER)
                .add(BlockInit.FUCHSITE);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(BlockInit.CORRUPTED_STEM)
                .add(BlockInit.CORRUPTED_HYPHAE)
                .add(BlockInit.STRIPPED_CORRUPTED_STEM)
                .add(BlockInit.STRIPPED_CORRUPTED_HYPHAE);

        getOrCreateTagBuilder(BlockTags.CAMPFIRES)
                .add(BlockInit.CORRUPTED_CAMPFIRE);

        getOrCreateTagBuilder(CorruptedNetherTags.CORRUPTED_FIRE_BLOCKS)
                .add(BlockInit.CORRUPTED_STEM)
                .add(BlockInit.CORRUPTED_HYPHAE)
                .add(BlockInit.STRIPPED_CORRUPTED_STEM)
                .add(BlockInit.STRIPPED_CORRUPTED_HYPHAE)
                .add(BlockInit.CORRUPTED_PLANKS)
                .add(BlockInit.CORRUPTED_STAIRS)
                .add(BlockInit.CORRUPTED_SLAB)
                .add(BlockInit.CORRUPTED_FENCE)
                .add(BlockInit.CORRUPTED_FENCE_GATE)
                .add(BlockInit.CORRUPTED_DOOR)
                .add(BlockInit.CORRUPTED_TRAPDOOR)
                .add(BlockInit.CORRUPTED_NYLIUM)
                .add(BlockInit.CORRUPTED_WART_BLOCK)
                .add(BlockInit.CURSELIGHT)
                .add(BlockInit.FUCHSITE)
                .add(BlockInit.FUCHSITE_SLAB)
                .add(BlockInit.FUCHSITE_WALL)
                .add(BlockInit.FUCHSITE_STAIRS)
                .add(BlockInit.POLISHED_FUCHSITE)
                .add(BlockInit.POLISHED_FUCHSITE_SLAB)
                .add(BlockInit.POLISHED_FUCHSITE_STAIRS)
                .add(BlockInit.POLISHED_FUCHSITE_WALL)
                .add(BlockInit.CHISELED_POLISHED_FUCHSITE)
                .add(BlockInit.POLISHED_FUCHSITE_BRICKS)
                .add(BlockInit.POLISHED_FUCHSITE_BRICK_SLAB)
                .add(BlockInit.POLISHED_FUCHSITE_BRICK_STAIRS)
                .add(BlockInit.POLISHED_FUCHSITE_BRICK_WALL)
                .add(BlockInit.POLISHED_FUCHSITE_PRESSURE_PLATE)
                .add(BlockInit.POLISHED_FUCHSITE_BUTTON);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(BlockInit.FUCHSITE_SLAB)
                .add(BlockInit.POLISHED_FUCHSITE_SLAB)
                .add(BlockInit.POLISHED_FUCHSITE_BRICK_SLAB)
                .add(BlockInit.CORRUPTED_SLAB);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(BlockInit.FUCHSITE_STAIRS)
                .add(BlockInit.POLISHED_FUCHSITE_STAIRS)
                .add(BlockInit.POLISHED_FUCHSITE_BRICK_STAIRS)
                .add(BlockInit.CORRUPTED_STAIRS);

        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(BlockInit.POLISHED_FUCHSITE_BUTTON)
                .add(BlockInit.CORRUPTED_BUTTON);

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(BlockInit.CORRUPTED_DOOR);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(BlockInit.FUCHSITE_WALL)
                .add(BlockInit.POLISHED_FUCHSITE_WALL)
                .add(BlockInit.POLISHED_FUCHSITE_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(BlockInit.CORRUPTED_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(BlockInit.CORRUPTED_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(BlockInit.CORRUPTED_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(BlockInit.CORRUPTED_DOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(BlockInit.CORRUPTED_FENCE)
                .add(BlockInit.CORRUPTED_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(BlockInit.CORRUPTED_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(BlockInit.CORRUPTED_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(BlockInit.CORRUPTED_STAIRS);
        
    }
}