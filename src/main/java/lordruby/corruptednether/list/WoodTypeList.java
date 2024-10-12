package lordruby.corruptednether.list;

import lordruby.corruptednether.CorruptedNether;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class WoodTypeList {
    public static final WoodType CORRUPTED = new WoodType(
            Identifier.of(CorruptedNether.MOD_ID, "corrupted").toString(),
            BlockSetTypeList.CORRUPTED,
            BlockSoundGroup.WOOD,
            BlockSoundGroup.HANGING_SIGN,
            SoundEvents.BLOCK_FENCE_GATE_CLOSE,
            SoundEvents.BLOCK_FENCE_GATE_OPEN
    );
}
