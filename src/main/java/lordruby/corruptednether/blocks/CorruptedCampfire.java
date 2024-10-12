package lordruby.corruptednether.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.tick.SimpleTickScheduler;

public class CorruptedCampfire extends CampfireBlock {
    public CorruptedCampfire(boolean emitsParticles, int fireDamage, Settings settings) {
        super(emitsParticles, fireDamage, settings);
    }


    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        if(state.get(CampfireBlock.LIT)){
            for (int i = 0; i < random.nextInt(2) + 2; i++) {
                spawnSmokeParticle(world, pos, (Boolean)state.get(CampfireBlock.SIGNAL_FIRE), false);
            }
        }
    }
}
