package lordruby.corruptednether.list;

import lordruby.corruptednether.CorruptedNether;
import net.minecraft.block.BlockSetType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class BlockSetTypeList {
    public static final BlockSetType CORRUPTED = new BlockSetType(Identifier.of(CorruptedNether.MOD_ID, "corrupted").toString());
    public static final BlockSetType FUCHSITE = new BlockSetType(Identifier.of(CorruptedNether.MOD_ID, "fuchsite").toString(),true,
            true,
            false,
            BlockSetType.ActivationRule.MOBS,
            BlockSoundGroup.STONE,
            SoundEvents.BLOCK_IRON_DOOR_CLOSE,
            SoundEvents.BLOCK_IRON_DOOR_OPEN,
            SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE,
            SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN,
            SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF,
            SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON);
}