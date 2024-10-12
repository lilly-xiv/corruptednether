package lordruby.corruptednether.factory;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
@Environment(EnvType.CLIENT)
public class CorruptedParticleFactory extends WaterSuspendParticle.WarpedSporeFactory {

        public CorruptedParticleFactory(SpriteProvider spriteProvider) {
            super(spriteProvider);
        }

        public Particle createParticle(SimpleParticleType simpleParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            Particle p = super.createParticle(simpleParticleType, clientWorld, d, e, f, g, h, i);
            p.setColor(0.45f, 0.25f, 0.45f);
            return p;
        }
    }

