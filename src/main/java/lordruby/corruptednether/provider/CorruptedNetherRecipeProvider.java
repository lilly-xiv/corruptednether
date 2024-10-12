package lordruby.corruptednether.provider;

import lordruby.corruptednether.init.BlockInit;
import lordruby.corruptednether.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class CorruptedNetherRecipeProvider extends FabricRecipeProvider {
    public CorruptedNetherRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORRUPTED_PLANKS, 4)
                .input(BlockInit.CORRUPTED_STEM)
                .criterion(hasItem(BlockInit.CORRUPTED_STEM), conditionsFromItem(BlockInit.CORRUPTED_STEM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORRUPTED_SLAB, 6)
                .input('T', BlockInit.CORRUPTED_PLANKS)
                .pattern("TTT")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_PLANKS), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORRUPTED_STAIRS, 4)
                .input('T', BlockInit.CORRUPTED_PLANKS)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_PLANKS), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORRUPTED_FENCE, 3)
                .input('T', BlockInit.CORRUPTED_PLANKS)
                .input('S', ConventionalItemTags.WOODEN_RODS)
                .pattern("TST")
                .pattern("TST")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_PLANKS), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_PLANKS))
                .criterion(hasTag(ConventionalItemTags.WOODEN_RODS), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.WOODEN_RODS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORRUPTED_FENCE_GATE)
                .input('T', BlockInit.CORRUPTED_PLANKS)
                .input('S', ConventionalItemTags.WOODEN_RODS)
                .pattern("STT")
                .pattern("STT")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_PLANKS), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_PLANKS))
                .criterion(hasTag(ConventionalItemTags.WOODEN_RODS), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.WOODEN_RODS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORRUPTED_DOOR, 3)
                .input('T', BlockInit.CORRUPTED_PLANKS)
                .pattern("TT")
                .pattern("TT")
                .pattern("TT")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_PLANKS), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORRUPTED_TRAPDOOR, 2)
                .input('T', BlockInit.CORRUPTED_PLANKS)
                .pattern("TTT")
                .pattern("TTT")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_PLANKS), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_PLANKS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BlockInit.CORRUPTED_BUTTON)
                .input(BlockInit.CORRUPTED_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_PLANKS), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BlockInit.CORRUPTED_PRESSURE_PLATE)
                .input('T', BlockInit.CORRUPTED_PLANKS)
                .pattern("TT")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_PLANKS), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ItemInit.CORRUPTED_SIGN, 3)
                .input('T', BlockInit.CORRUPTED_PLANKS)
                .input('S', ConventionalItemTags.WOODEN_RODS)
                .pattern("TTT")
                .pattern("TTT")
                .pattern(" S ")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_PLANKS), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_PLANKS))
                .criterion(hasTag(ConventionalItemTags.WOODEN_RODS), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.WOODEN_RODS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ItemInit.CORRUPTED_HANGING_SIGN, 6)
                .input('T', BlockInit.CORRUPTED_PLANKS)
                .input('C', ConventionalItemTags.CHAINS)
                .pattern("C C")
                .pattern("TTT")
                .pattern("TTT")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_PLANKS), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_PLANKS))
                .criterion(hasTag(ConventionalItemTags.CHAINS), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.CHAINS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ItemInit.CORRUPTED_BOAT)
                .input('T', BlockInit.CORRUPTED_PLANKS)
                .pattern("T T")
                .pattern("TTT")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_PLANKS), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_PLANKS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ItemInit.CORRUPTED_CHEST_BOAT)
                .input(ItemInit.CORRUPTED_BOAT)
                .input(ConventionalItemTags.WOODEN_CHESTS)
                .criterion(FabricRecipeProvider.hasItem(ItemInit.CORRUPTED_BOAT), FabricRecipeProvider.conditionsFromItem(ItemInit.CORRUPTED_BOAT))
                .criterion(hasTag(ConventionalItemTags.WOODEN_CHESTS), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.WOODEN_CHESTS))
                .offerTo(exporter);

        var exampleFamily = new BlockFamily.Builder(BlockInit.CORRUPTED_PLANKS)
                .button(BlockInit.CORRUPTED_BUTTON)
                .fence(BlockInit.CORRUPTED_FENCE)
                .fenceGate(BlockInit.CORRUPTED_FENCE_GATE)
                .pressurePlate(BlockInit.CORRUPTED_PRESSURE_PLATE)
                .sign(BlockInit.CORRUPTED_SIGN, BlockInit.CORRUPTED_WALL_SIGN)
                .slab(BlockInit.CORRUPTED_SLAB)
                .stairs(BlockInit.CORRUPTED_STAIRS)
                .door(BlockInit.CORRUPTED_DOOR)
                .trapdoor(BlockInit.CORRUPTED_TRAPDOOR)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORRUPTED_HYPHAE, 3)
                .input('T', BlockInit.CORRUPTED_STEM)
                .pattern("TT")
                .pattern("TT")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_STEM), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_STEM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.STRIPPED_CORRUPTED_HYPHAE, 3)
                .input('T', BlockInit.STRIPPED_CORRUPTED_STEM)
                .pattern("TT")
                .pattern("TT")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.STRIPPED_CORRUPTED_STEM), FabricRecipeProvider.conditionsFromItem(BlockInit.STRIPPED_CORRUPTED_STEM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.STICK, 2)
                .input('T', BlockInit.CORRUPTED_PLANKS)
                .pattern("T")
                .pattern("T")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_PLANKS), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.CHEST, 1)
                .input('T', BlockInit.CORRUPTED_PLANKS)
                .pattern("TTT")
                .pattern("T T")
                .pattern("TTT")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_PLANKS), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ItemInit.CORRUPTED_CAMPFIRE, 1)
                .input('L', Ingredient.fromTag(ItemTags.LOGS))
                .input('S', Items.STICK)
                .input('W', BlockInit.CORRUPTED_WART_BLOCK)
                .pattern(" S ")
                .pattern("SWS")
                .pattern("LLL")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_WART_BLOCK), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_WART_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ItemInit.CORRUPTED_TORCH, 4)
                .input('C', Ingredient.fromTag(ItemTags.COALS))
                .input('S', Items.STICK)
                .input('W', BlockInit.CORRUPTED_WART_BLOCK)
                .pattern("C")
                .pattern("S")
                .pattern("W")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_WART_BLOCK), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_WART_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ItemInit.CORRUPTED_LANTERN, 1)
                .input('N', Items.IRON_NUGGET)
                .input('W', BlockInit.CORRUPTED_TORCH)
                .pattern("NNN")
                .pattern("NWN")
                .pattern("NNN")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.CORRUPTED_WART_BLOCK), FabricRecipeProvider.conditionsFromItem(BlockInit.CORRUPTED_WART_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.FUCHSITE_SLAB, 6)
                .input('F', BlockInit.FUCHSITE)
                .pattern("FFF")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.FUCHSITE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.FUCHSITE_SLAB)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.FUCHSITE))
                .offerTo(exporter, "fuchite_slab_stonecutting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.FUCHSITE_STAIRS, 4)
                .input('F', BlockInit.FUCHSITE)
                .pattern("F  ")
                .pattern("FF ")
                .pattern("FFF")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.FUCHSITE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.FUCHSITE_STAIRS)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.FUCHSITE))
                .offerTo(exporter, "fuchite_stairs_stonecutting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.FUCHSITE_WALL, 6)
                .input('F', BlockInit.FUCHSITE)
                .pattern("FFF")
                .pattern("FFF")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.FUCHSITE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.FUCHSITE_WALL)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.FUCHSITE))
                .offerTo(exporter, "fuchite_wall_stonecutting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE, 4   )
                .input('F', BlockInit.FUCHSITE)
                .pattern("FF")
                .pattern("FF")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.FUCHSITE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.FUCHSITE))
                .offerTo(exporter, "polished_fuchite_stonecutting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_BRICKS, 4)
                .input('F', BlockInit.POLISHED_FUCHSITE)
                .pattern("FF")
                .pattern("FF")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.POLISHED_FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_BRICKS)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter, "polished_fuchite_bricks_stonecutting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_BUTTON, 1)
                .input('F', BlockInit.POLISHED_FUCHSITE)
                .pattern("F")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.POLISHED_FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_BUTTON)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter, "polished_fuchite_button_stonecutting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_PRESSURE_PLATE, 1)
                .input('F', BlockInit.POLISHED_FUCHSITE)
                .pattern("FF")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.POLISHED_FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_PRESSURE_PLATE)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter, "polished_fuchite_pressure_plate_stonecutting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_SLAB, 6)
                .input('F', BlockInit.POLISHED_FUCHSITE)
                .pattern("FFF")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.POLISHED_FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_SLAB)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter, "polished_fuchite_slab_stonecutting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_STAIRS, 4)
                .input('F', BlockInit.POLISHED_FUCHSITE)
                .pattern("F  ")
                .pattern("FF ")
                .pattern("FFF")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.POLISHED_FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_STAIRS)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter, "polished_fuchite_stairs_stonecutting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_WALL, 6)
                .input('F', BlockInit.POLISHED_FUCHSITE)
                .pattern("FFF")
                .pattern("FFF")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.POLISHED_FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_WALL)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter, "polished_fuchite_wall_stonecutting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHISELED_POLISHED_FUCHSITE, 1)
                .input('F', BlockInit.POLISHED_FUCHSITE_SLAB)
                .pattern("F")
                .pattern("F")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.POLISHED_FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.CHISELED_POLISHED_FUCHSITE)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter, "chiseled_polished_fuchite_stonecutting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_BRICK_SLAB, 6)
                .input('F', BlockInit.POLISHED_FUCHSITE_BRICKS)
                .pattern("FFF")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE_BRICKS), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE_BRICKS))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.POLISHED_FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_BRICK_SLAB)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter, "polished_fuchite_brick_slab_slabstonecutting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_BRICK_STAIRS, 4)
                .input('F', BlockInit.POLISHED_FUCHSITE_BRICKS)
                .pattern("F  ")
                .pattern("FF ")
                .pattern("FFF")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE_BRICKS), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE_BRICKS))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.POLISHED_FUCHSITE_BRICKS), RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_BRICK_STAIRS)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter, "polished_fuchite_brick_stairs_slabstonecutting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_BRICK_WALL, 6)
                .input('F', BlockInit.POLISHED_FUCHSITE_BRICKS)
                .pattern("FFF")
                .pattern("FFF")
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE_BRICKS), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE_BRICKS))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.POLISHED_FUCHSITE_BRICKS), RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_BRICK_WALL)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter, "polished_fuchite_brick_wall_slabstonecutting");

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.POLISHED_FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_BRICK_WALL)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter, "polished_fuchite_brick_wall_from_polished_slabstonecutting");
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.POLISHED_FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_BRICK_STAIRS)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter, "polished_fuchite_brick_stairs_from_polished_slabstonecutting");
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(BlockInit.POLISHED_FUCHSITE), RecipeCategory.BUILDING_BLOCKS, BlockInit.POLISHED_FUCHSITE_BRICK_SLAB)
                .criterion(FabricRecipeProvider.hasItem(BlockInit.POLISHED_FUCHSITE), FabricRecipeProvider.conditionsFromItem(BlockInit.POLISHED_FUCHSITE))
                .offerTo(exporter, "polished_fuchite_brick_slab_from_polished_slabstonecutting");

    }
    private static @NotNull String hasTag(@NotNull TagKey<Item> tag) {
        return "has_" + tag.id().toString();
    }
}
