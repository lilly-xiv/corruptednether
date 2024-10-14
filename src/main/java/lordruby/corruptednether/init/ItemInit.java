package lordruby.corruptednether.init;

import lordruby.corruptednether.CorruptedNether;
import lordruby.corruptednether.entities.CorruptedSkeleton;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.minecraft.util.math.Direction;

import javax.swing.text.html.parser.Entity;
import java.awt.*;
import java.util.function.BiFunction;

public class ItemInit {
    public static final SignItem CORRUPTED_SIGN = register("corrupted_sign",
            new SignItem(new Item.Settings().maxCount(16), BlockInit.CORRUPTED_SIGN, BlockInit.CORRUPTED_WALL_SIGN));

    public static final HangingSignItem CORRUPTED_HANGING_SIGN = register("corrupted_hanging_sign",
            new HangingSignItem(BlockInit.CORRUPTED_HANGING_SIGN, BlockInit.CORRUPTED_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));
    public static final Item CORRUPTED_BOAT =
            TerraformBoatItemHelper.registerBoatItem(BoatInit.CORRUPTED_BOAT_ID, BoatInit.CORRUPTED_BOAT_KEY, false);

    public static final Item CORRUPTED_CHEST_BOAT =
            TerraformBoatItemHelper.registerBoatItem(BoatInit.CORRUPTED_CHEST_BOAT_ID, BoatInit.CORRUPTED_BOAT_KEY, true);

    public static final Item CORRUPTED_TORCH = Items.register(
            new VerticallyAttachableBlockItem(BlockInit.CORRUPTED_TORCH, BlockInit.CORRUPTED_TORCH_WALL, new Item.Settings(), Direction.DOWN)
    );

    public static final Item CORRUPTED_LANTERN = Items.register(
            BlockInit.CORRUPTED_LANTERN
    );
    public static final Item CORRUPTED_CAMPFIRE = Items.register(BlockInit.CORRUPTED_CAMPFIRE, settings -> settings.component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    //

    public static final SpawnEggItem CORRUPTED_SKELETON_SPAWN_EGG = register("corrupted_skeleton_spawn_egg",
            new SpawnEggItem(EntityInit.CORRUPTED_SKELETON, 16382457, 16382457, new Item.Settings()));
    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, Identifier.of(CorruptedNether.MOD_ID, name), item);
    }

    public static void load() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.add(CORRUPTED_TORCH);
            content.add(CORRUPTED_LANTERN);
            content.add(CORRUPTED_CAMPFIRE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
            content.add(CORRUPTED_SKELETON_SPAWN_EGG);
        });
    }
}
