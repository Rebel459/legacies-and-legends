package net.rebel459.legacies_and_legends.sound;

import net.minecraft.world.level.block.SoundType;

public final class LaLBlockSounds {

    public static final SoundType SAPPHIRE_BLOCK = new SoundType(1F, 1F,
            LaLSounds.SAPPHIRE_BLOCK_BREAK,
            LaLSounds.SAPPHIRE_BLOCK_STEP,
            LaLSounds.SAPPHIRE_BLOCK_PLACE,
            LaLSounds.SAPPHIRE_BLOCK_HIT,
            LaLSounds.SAPPHIRE_BLOCK_FALL
    );
    public static final SoundType WAND_PLATFORM = new SoundType(1F, 1F,
            LaLSounds.WAND_PLATFORM_BREAK,
            LaLSounds.WAND_PLATFORM_STEP,
            LaLSounds.WAND_PLATFORM_PLACE,
            LaLSounds.WAND_PLATFORM_HIT,
            LaLSounds.WAND_PLATFORM_FALL
    );

    public static void init() {
    }
}