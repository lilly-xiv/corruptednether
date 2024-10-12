package lordruby.corruptednether.init;

import lordruby.corruptednether.CorruptedNether;
import lordruby.corruptednether.blocks.*;
import lordruby.corruptednether.list.BlockSetTypeList;
import lordruby.corruptednether.list.WoodTypeList;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import java.util.List;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;

import static lordruby.corruptednether.init.ItemInit.CORRUPTED_BOAT;
import static lordruby.corruptednether.init.ItemInit.CORRUPTED_CHEST_BOAT;

public class BlockInit {

    public static final Block CORRUPTED_STEM = registerWithItem("corrupted_stem",
            Blocks.createLogBlock(MapColor.PURPLE, MapColor.PALE_PURPLE));
    public static final Block CORRUPTED_HYPHAE = registerWithItem("corrupted_hyphae",
            Blocks.createLogBlock(MapColor.PURPLE, MapColor.PALE_PURPLE));
    public static final Block CORRUPTED_PLANKS = registerWithItem("corrupted_planks",
            Blocks.createLogBlock(MapColor.PURPLE, MapColor.PALE_PURPLE));
    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, Identifier.of(CorruptedNether.MOD_ID, name), block);
    }
    public static final Block STRIPPED_CORRUPTED_STEM = registerWithItem("stripped_corrupted_stem",
            Blocks.createLogBlock(MapColor.PALE_PURPLE, MapColor.PALE_PURPLE));

    public static final Block STRIPPED_CORRUPTED_HYPHAE = registerWithItem("stripped_corrupted_hyphae",
            Blocks.createLogBlock(MapColor.PURPLE, MapColor.PALE_PURPLE));


    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        T registered = register(name, block);
        ItemInit.register(name, new BlockItem(registered, settings));
        return registered;
    }

    public static <T extends Block> T registerWithItem(String name, T block) {
        return registerWithItem(name, block, new Item.Settings());
    }

    private static SuspiciousStewEffectsComponent createStewEffects(SuspiciousStewEffectsComponent.StewEffect... effects) {
        return new SuspiciousStewEffectsComponent(List.of(effects));
    }
    public static final DoorBlock CORRUPTED_DOOR = registerWithItem("corrupted_door",
            new DoorBlock(BlockSetTypeList.CORRUPTED,
                    AbstractBlock.Settings.create()
                            .mapColor(CORRUPTED_PLANKS.getDefaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(3.0F)
                            .nonOpaque()
                            .pistonBehavior(PistonBehavior.DESTROY)));

    public static final FenceBlock CORRUPTED_FENCE = registerWithItem("corrupted_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .mapColor(CORRUPTED_PLANKS.getDefaultMapColor())
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    ));

    public static final FenceGateBlock CORRUPTED_FENCE_GATE = registerWithItem("corrupted_fence_gate",
            new FenceGateBlock(WoodTypeList.CORRUPTED,
                    AbstractBlock.Settings.create()
                            .mapColor(CORRUPTED_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            ));

    public static final StairsBlock CORRUPTED_STAIRS = registerWithItem("corrupted_stairs",
            new StairsBlock(CORRUPTED_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)
                    .mapColor(CORRUPTED_PLANKS.getDefaultMapColor())));

    public static final SlabBlock CORRUPTED_SLAB = registerWithItem("corrupted_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .mapColor(CORRUPTED_PLANKS.getDefaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    ));

    public static final PressurePlateBlock CORRUPTED_PRESSURE_PLATE = registerWithItem("corrupted_pressure_plate",
            new PressurePlateBlock(BlockSetTypeList.CORRUPTED,
                    AbstractBlock.Settings.create()
                            .mapColor(CORRUPTED_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(0.5F)
                            .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block CORRUPTED_BUTTON = registerWithItem("corrupted_button",
            Blocks.createWoodenButtonBlock(BlockSetTypeList.CORRUPTED));

    public static final TrapdoorBlock CORRUPTED_TRAPDOOR = registerWithItem("corrupted_trapdoor",
            new TrapdoorBlock(BlockSetTypeList.CORRUPTED,
                    AbstractBlock.Settings.create()
                            .mapColor(CORRUPTED_PLANKS.getDefaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(3.0F)
                            .nonOpaque()
                            .allowsSpawning(Blocks::never)));
    private static final Identifier CORRUPTED_SIGN_TEXTURE = Identifier.of(CorruptedNether.MOD_ID, "entity/signs/corrupted");
    private static final Identifier CORRUPTED_HANGING_SIGN_TEXTURE = Identifier.of(CorruptedNether.MOD_ID,"entity/signs/hanging/corrupted");
    private static final Identifier CORRUPTED_HANGING_SIGN_GUI_TEXTURE = Identifier.of(CorruptedNether.MOD_ID,"textures/gui/hanging_signs/corrupted");

    public static final TerraformSignBlock CORRUPTED_SIGN = register("corrupted_sign",
            new TerraformSignBlock(CORRUPTED_SIGN_TEXTURE,
                    AbstractBlock.Settings.create()
                            .mapColor(CORRUPTED_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)));

    public static final TerraformWallSignBlock CORRUPTED_WALL_SIGN = register("corrupted_wall_sign",
            new TerraformWallSignBlock(CORRUPTED_SIGN_TEXTURE,
                    AbstractBlock.Settings.create()
                            .mapColor(CORRUPTED_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)));

    public static final TerraformHangingSignBlock CORRUPTED_HANGING_SIGN = register("corrupted_hanging_sign",
            new TerraformHangingSignBlock(CORRUPTED_HANGING_SIGN_TEXTURE, CORRUPTED_HANGING_SIGN_GUI_TEXTURE,
                    AbstractBlock.Settings.create()
                            .mapColor(CORRUPTED_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)));

    public static final TerraformWallHangingSignBlock CORRUPTED_WALL_HANGING_SIGN = register("corrupted_wall_hanging_sign",
            new TerraformWallHangingSignBlock(CORRUPTED_HANGING_SIGN_TEXTURE, CORRUPTED_HANGING_SIGN_GUI_TEXTURE,
                    AbstractBlock.Settings.create()
                            .mapColor(CORRUPTED_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)));
    //natural
    public static final Block CURSELIGHT = registerWithItem("curselight",
            new Block(AbstractBlock.Settings.copy(Blocks.SHROOMLIGHT)
                    .mapColor(MapColor.GREEN)));

    public static final Block CORRUPTED_WART_BLOCK = registerWithItem("corrupted_wart_block",
            new Block(AbstractBlock.Settings.copy(Blocks.WARPED_WART_BLOCK)
                    .mapColor(MapColor.PURPLE)));

    public static final CorruptedNylium CORRUPTED_NYLIUM = registerWithItem("corrupted_nylium",
            new CorruptedNylium(AbstractBlock.Settings.copy(Blocks.WARPED_NYLIUM)
                    .mapColor(MapColor.PURPLE)));

    public static final VisciousVines VISCIOUS_VINES = registerWithItem("corrupted_vines",
            new VisciousVines(AbstractBlock.Settings.copy(Blocks.TWISTING_VINES_PLANT)
                    .mapColor(MapColor.PURPLE)));

    public static final Block VISCIOUS_VINES_PLANT = registerWithItem("corrupted_vines_plant",
            new Block(AbstractBlock.Settings.copy(Blocks.TWISTING_VINES_PLANT)
                    .mapColor(MapColor.PURPLE)));

    public static final VisciousRoots VISCIOUS_ROOTS = registerWithItem("corrupted_roots",
            new VisciousRoots(AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS)
                    .mapColor(MapColor.PURPLE)));

    public static final Block POTTED_VISCIOUS_ROOTS = registerWithItem("potted_corrupted_roots",
            new Block(AbstractBlock.Settings.copy(Blocks.POTTED_WARPED_ROOTS)
                    .mapColor(MapColor.PURPLE)));

    public static final VisciousFungus VISCIOUS_FUNGUS = registerWithItem("corrupted_fungus",
            new VisciousFungus(AbstractBlock.Settings.copy(Blocks.WARPED_FUNGUS)
                    .mapColor(MapColor.PURPLE)));

    public static final Block POTTED_VISCIOUS_FUNGUS = registerWithItem("potted_corrupted_fungus",
            new Block(AbstractBlock.Settings.copy(Blocks.POTTED_WARPED_FUNGUS)
                    .mapColor(MapColor.PURPLE)));


    public static final Block CORRUPTED_FIRE = register("corrupted_fire",
            new CorruptedFire(AbstractBlock.Settings.copy(Blocks.SOUL_FIRE).mapColor(MapColor.GREEN)));

    public static final CorruptedTorch CORRUPTED_TORCH = register("corrupted_torch",
            new CorruptedTorch(ParticleInit.CORRUPTED_FIRE_FLAME, AbstractBlock.Settings.copy(Blocks.SOUL_TORCH).mapColor(MapColor.GREEN)));

    public static final CorruptedTorchWall CORRUPTED_TORCH_WALL= register("corrupted_torch_wall",
            new CorruptedTorchWall(ParticleInit.CORRUPTED_FIRE_FLAME, AbstractBlock.Settings.copy(Blocks.SOUL_TORCH).mapColor(MapColor.GREEN)));

    public static final CorruptedLantern CORRUPTED_LANTERN = register("corrupted_lantern",
            new CorruptedLantern(AbstractBlock.Settings.copy(Blocks.SOUL_LANTERN).mapColor(MapColor.GREEN)));

    public static final CorruptedCampfire CORRUPTED_CAMPFIRE = register("corrupted_campfire",
            new CorruptedCampfire(true, 2, AbstractBlock.Settings.copy(Blocks.SOUL_CAMPFIRE).mapColor(MapColor.GREEN)));

    public static final Block FUCHSITE = registerWithItem("fuchsite",
           new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)));

    public static final Block POLISHED_FUCHSITE = registerWithItem("polished_fuchsite",
            new Block(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE)));

    public static final Block POLISHED_FUCHSITE_BRICKS = registerWithItem("polished_fuchsite_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE)));

    public static final Block CHISELED_POLISHED_FUCHSITE = registerWithItem("chiseled_polished_fuchsite",
            new Block(AbstractBlock.Settings.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)));

    public static final WallBlock FUCHSITE_WALL = registerWithItem("fuchsite_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE_WALL)));


    public static final StairsBlock FUCHSITE_STAIRS = registerWithItem("fuchsite_stairs",
            new StairsBlock(FUCHSITE.getDefaultState(), AbstractBlock.Settings.copy(Blocks.BLACKSTONE_STAIRS)));

    public static final SlabBlock FUCHSITE_SLAB = registerWithItem("fuchsite_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE_SLAB)));

    public static final WallBlock POLISHED_FUCHSITE_WALL = registerWithItem("polished_fuchsite_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE_WALL)));


    public static final StairsBlock POLISHED_FUCHSITE_STAIRS = registerWithItem("polished_fuchsite_stairs",
            new StairsBlock(POLISHED_FUCHSITE.getDefaultState(), AbstractBlock.Settings.copy(Blocks.BLACKSTONE_STAIRS)));

    public static final SlabBlock POLISHED_FUCHSITE_SLAB = registerWithItem("polished_fuchsite_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE_SLAB)));

    public static final PressurePlateBlock POLISHED_FUCHSITE_PRESSURE_PLATE = registerWithItem("polished_fuchsite_pressure_plate",
            new PressurePlateBlock(BlockSetTypeList.FUCHSITE, AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE)));

    public static final Block POLISHED_FUCHSITE_BUTTON = registerWithItem("polished_fuchsite_button",
            Blocks.createStoneButtonBlock());

    public static final WallBlock POLISHED_FUCHSITE_BRICK_WALL = registerWithItem("polished_fuchsite_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE_WALL)));


    public static final StairsBlock POLISHED_FUCHSITE_BRICK_STAIRS = registerWithItem("polished_fuchsite_brick_stairs",
            new StairsBlock(FUCHSITE.getDefaultState(), AbstractBlock.Settings.copy(Blocks.BLACKSTONE_STAIRS)));

    public static final SlabBlock POLISHED_FUCHSITE_BRICK_SLAB = registerWithItem("polished_fuchsite_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE_SLAB)));
    public static void load() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.add(CORRUPTED_STEM);
            content.add(CORRUPTED_HYPHAE);
            content.add(STRIPPED_CORRUPTED_STEM);
            content.add(STRIPPED_CORRUPTED_HYPHAE);
            content.add(CORRUPTED_PLANKS);
            content.add(CORRUPTED_STAIRS);
            content.add(CORRUPTED_SLAB);
            content.add(CORRUPTED_FENCE);
            content.add(CORRUPTED_FENCE_GATE);
            content.add(CORRUPTED_DOOR);
            content.add(CORRUPTED_TRAPDOOR);
            content.add(CORRUPTED_PRESSURE_PLATE);
            content.add(CORRUPTED_BUTTON);
            content.add(FUCHSITE);
            content.add(FUCHSITE_STAIRS);
            content.add(FUCHSITE_SLAB);
            content.add(FUCHSITE_WALL);
            content.add(CHISELED_POLISHED_FUCHSITE);
            content.add(POLISHED_FUCHSITE);
            content.add(POLISHED_FUCHSITE_STAIRS);
            content.add(POLISHED_FUCHSITE_SLAB);
            content.add(POLISHED_FUCHSITE_WALL);
            content.add(POLISHED_FUCHSITE_PRESSURE_PLATE);
            content.add(POLISHED_FUCHSITE_BUTTON);
            content.add(POLISHED_FUCHSITE_BRICKS);
            content.add(POLISHED_FUCHSITE_BRICK_STAIRS);
            content.add(POLISHED_FUCHSITE_BRICK_SLAB);
            content.add(POLISHED_FUCHSITE_BRICK_WALL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.add(CORRUPTED_SIGN);
            content.add(CORRUPTED_HANGING_SIGN);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.add(CORRUPTED_BOAT);
            content.add(CORRUPTED_CHEST_BOAT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.add(CORRUPTED_NYLIUM);
            content.add(CORRUPTED_WART_BLOCK);
            content.add(CURSELIGHT);
            content.add(VISCIOUS_FUNGUS);
            content.add(VISCIOUS_ROOTS);
            content.add(VISCIOUS_VINES);
            content.add(FUCHSITE);
        });

    }
}
