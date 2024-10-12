package lordruby.corruptednether.tags;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CorruptedNetherTags {
    public static final TagKey<Block> CORRUPTED_FIRE_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "corrupted_fire_blocks"));
}
