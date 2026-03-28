package net.rebel459.legacies_and_legends.client;

import net.frozenblock.lib.music.api.client.structure.StructureMusic;
import net.frozenblock.lib.music.api.client.structure.StructureMusicApi;
import net.rebel459.legacies_and_legends.config.LaLConfig;
import net.rebel459.legacies_and_legends.sound.LaLSounds;
import net.minecraft.sounds.Music;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;

public final class LaLStructureMusic {

    public static int structureMusicMin = Math.max(0, LaLConfig.get.music.structure_music_min * 20);
    public static int structureMusicMax = Math.max(0, Math.max(LaLConfig.get.music.structure_music_min, LaLConfig.get.music.structure_music_max) * 20);

	public static void init() {
		if (LaLConfig.get.music.stronghold_music) {
			StructureMusicApi.registerMusicForStructure(
					BuiltinStructures.STRONGHOLD,
					new StructureMusic(
                            new Music(LaLSounds.STRONGHOLD_MUSIC, structureMusicMin, structureMusicMax, true),
							true
					)
			);
		}
		if (LaLConfig.get.music.ancient_city_music) {
			StructureMusicApi.registerMusicForStructure(
					BuiltinStructures.ANCIENT_CITY,
					new StructureMusic(
                            new Music(LaLSounds.ANCIENT_CITY_MUSIC, structureMusicMin, structureMusicMax, true),
							false
					)
			);
		}
	}
}