package lordruby.corruptednether.init;

import lordruby.corruptednether.CorruptedNether;
import lordruby.corruptednether.entities.CorruptedSkeleton;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.BoggedEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

public class EntityInit {
    public static final EntityType<CorruptedSkeleton> CORRUPTED_SKELETON = register("corrupted_skeleton",
            EntityType.Builder.create(CorruptedSkeleton::new, SpawnGroup.MONSTER).dimensions(0.6F, 1.99F).eyeHeight(1.74F).vehicleAttachment(-0.7F).maxTrackingRange(8));
    public static void load(){
        FabricDefaultAttributeRegistry.register(CORRUPTED_SKELETON, CorruptedSkeleton.createSkeletonAttributes());
    }
    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, Identifier.of(CorruptedNether.MOD_ID, id), type.build(id));
    }

}
