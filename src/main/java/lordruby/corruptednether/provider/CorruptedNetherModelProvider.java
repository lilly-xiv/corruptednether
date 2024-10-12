package lordruby.corruptednether.provider;

import lordruby.corruptednether.init.BlockInit;
import lordruby.corruptednether.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.util.Identifier;

import java.util.List;

import static net.minecraft.data.client.BlockStateModelGenerator.buildBlockStateVariants;

class CorruptedNetherModelProvider extends FabricModelProvider {
    public CorruptedNetherModelProvider(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(BlockInit.CORRUPTED_STEM).stem(BlockInit.CORRUPTED_STEM).wood(BlockInit.CORRUPTED_HYPHAE);
        blockStateModelGenerator.registerLog(BlockInit.STRIPPED_CORRUPTED_STEM).stem(BlockInit.STRIPPED_CORRUPTED_STEM).wood(BlockInit.STRIPPED_CORRUPTED_HYPHAE);
        var CORRUPTEDFamily = new BlockFamily.Builder(BlockInit.CORRUPTED_PLANKS)
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
        blockStateModelGenerator.registerCubeAllModelTexturePool(CORRUPTEDFamily.getBaseBlock())
                .family(CORRUPTEDFamily);
        blockStateModelGenerator.registerHangingSign(BlockInit.STRIPPED_CORRUPTED_STEM, BlockInit.CORRUPTED_HANGING_SIGN, BlockInit.CORRUPTED_WALL_HANGING_SIGN);

        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.CURSELIGHT);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.CORRUPTED_WART_BLOCK);
        blockStateModelGenerator.registerNetherrackBottomCustomTop(BlockInit.CORRUPTED_NYLIUM);

        blockStateModelGenerator.registerRoots(BlockInit.VISCIOUS_ROOTS, BlockInit.POTTED_VISCIOUS_ROOTS);
        blockStateModelGenerator.registerRoots(BlockInit.VISCIOUS_FUNGUS, BlockInit.POTTED_VISCIOUS_FUNGUS);
        blockStateModelGenerator.registerRoots(BlockInit.VISCIOUS_VINES, BlockInit.VISCIOUS_VINES_PLANT);
        registerCorruptFire(blockStateModelGenerator);
        blockStateModelGenerator.registerTorch(BlockInit.CORRUPTED_TORCH, BlockInit.CORRUPTED_TORCH_WALL);
        blockStateModelGenerator.registerLantern(BlockInit.CORRUPTED_LANTERN);
        blockStateModelGenerator.registerCampfire(BlockInit.CORRUPTED_CAMPFIRE);

        //blockStateModelGenerator.registerSimpleCubeAll(BlockInit.FUCHSITE);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.CHISELED_POLISHED_FUCHSITE);

        var FuchsiteFamily = new BlockFamily.Builder(BlockInit.FUCHSITE)
                .wall(BlockInit.FUCHSITE_WALL)
                .slab(BlockInit.FUCHSITE_SLAB)
                .stairs(BlockInit.FUCHSITE_STAIRS)
                .group("stone")
                .unlockCriterionName("has_stone")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(FuchsiteFamily.getBaseBlock()).family(FuchsiteFamily);

        var PolishedFuchsiteFamily = new BlockFamily.Builder(BlockInit.POLISHED_FUCHSITE)
                .wall(BlockInit.POLISHED_FUCHSITE_WALL)
                .slab(BlockInit.POLISHED_FUCHSITE_SLAB)
                .stairs(BlockInit.POLISHED_FUCHSITE_STAIRS)
                .button(BlockInit.POLISHED_FUCHSITE_BUTTON)
                .pressurePlate(BlockInit.POLISHED_FUCHSITE_PRESSURE_PLATE)
                .group("stone")
                .unlockCriterionName("has_stone")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(PolishedFuchsiteFamily.getBaseBlock()).family(PolishedFuchsiteFamily);

        var PolishedFuchsiteBrickFamily = new BlockFamily.Builder(BlockInit.POLISHED_FUCHSITE_BRICKS)
                .wall(BlockInit.POLISHED_FUCHSITE_BRICK_WALL)
                .slab(BlockInit.POLISHED_FUCHSITE_BRICK_SLAB)
                .stairs(BlockInit.POLISHED_FUCHSITE_BRICK_STAIRS)
                .group("stone")
                .unlockCriterionName("has_stone")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(PolishedFuchsiteBrickFamily.getBaseBlock()).family(PolishedFuchsiteBrickFamily);
    }
    private void registerCorruptFire(BlockStateModelGenerator blockStateModelGenerator){
        List<Identifier> list = blockStateModelGenerator.getFireFloorModels(BlockInit.CORRUPTED_FIRE);
        List<Identifier> list2 =  blockStateModelGenerator.getFireSideModels(BlockInit.CORRUPTED_FIRE);
        blockStateModelGenerator.blockStateCollector
                .accept(
                        MultipartBlockStateSupplier.create(BlockInit.CORRUPTED_FIRE)
                                .with(buildBlockStateVariants(list, variant -> variant))
                                .with(buildBlockStateVariants(list2, variant -> variant))
                                .with(buildBlockStateVariants(list2, variant -> variant.put(VariantSettings.Y, VariantSettings.Rotation.R90)))
                                .with(buildBlockStateVariants(list2, variant -> variant.put(VariantSettings.Y, VariantSettings.Rotation.R180)))
                                .with(buildBlockStateVariants(list2, variant -> variant.put(VariantSettings.Y, VariantSettings.Rotation.R270)))
                );

    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ItemInit.CORRUPTED_BOAT, Models.GENERATED);
        itemModelGenerator.register(ItemInit.CORRUPTED_CHEST_BOAT, Models.GENERATED);
        //itemModelGenerator.register(ItemInit.CORRUPTED_LANTERN, Models.GENERATED);
    }
}

