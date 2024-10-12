package lordruby.corruptednether.init;

import lordruby.corruptednether.CorruptedNether;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
public class BoatInit {
    public static final Identifier CORRUPTED_BOAT_ID = Identifier.of(CorruptedNether.MOD_ID, "corrupted_boat");
    public static final Identifier CORRUPTED_CHEST_BOAT_ID = Identifier.of(CorruptedNether.MOD_ID, "corrupted_chest_boat");
    public static final RegistryKey<TerraformBoatType> CORRUPTED_BOAT_KEY = TerraformBoatTypeRegistry.createKey(CORRUPTED_BOAT_ID);

    public static TerraformBoatType CORRUPTED_BOAT;

    public static TerraformBoatType register(RegistryKey<TerraformBoatType> key, TerraformBoatType type) {
        return Registry.register(TerraformBoatTypeRegistry.INSTANCE, key, type);
    }
    public static void load() {
        CORRUPTED_BOAT = register(CORRUPTED_BOAT_KEY, new TerraformBoatType.Builder()
                .item(ItemInit.CORRUPTED_BOAT)
                .chestItem(ItemInit.CORRUPTED_CHEST_BOAT)
                .planks(BlockInit.CORRUPTED_PLANKS.asItem())
                .build());
    }
}
