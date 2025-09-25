package net.legacy.legacies_and_legends.client;

import net.frozenblock.lib.music.api.client.structure.StructureMusicApi;
import net.frozenblock.lib.music.api.client.structure.StructureMusicInfo;
import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.minecraft.client.sounds.MusicInfo;
import net.minecraft.sounds.Music;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;

public final class LaLStructureMusic {

	public static void init() {
		if (LaLConfig.get.music.stronghold_music) {
			StructureMusicApi.registerMusicInfoForStructure(
					BuiltinStructures.STRONGHOLD,
					new StructureMusicInfo(
							new MusicInfo(new Music(LaLSounds.STRONGHOLD_MUSIC, 6000, 12000, true)),
							true
					)
			);
		}
		if (LaLConfig.get.music.ancient_city_music) {
			StructureMusicApi.registerMusicInfoForStructure(
					BuiltinStructures.ANCIENT_CITY,
					new StructureMusicInfo(
							new MusicInfo(new Music(LaLSounds.ANCIENT_CITY_MUSIC, 6000, 12000, true)),
							false
					)
			);
		}
	}
}