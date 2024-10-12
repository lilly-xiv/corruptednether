package lordruby.corruptednether.init;

import lordruby.corruptednether.CorruptedNether;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ParticleInit {
    public static final SimpleParticleType CORRUPTED_FIRE_FLAME = FabricParticleTypes.simple();

    public static final SimpleParticleType CORRUPTED_SPORE = FabricParticleTypes.simple();

    public static void load(){
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(CorruptedNether.MOD_ID, "corrupted_fire_flame"), CORRUPTED_FIRE_FLAME);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(CorruptedNether.MOD_ID, "corrupted_spore"), CORRUPTED_SPORE);
    }
}
