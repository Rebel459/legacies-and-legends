package net.rebel459.legacies_and_legends.sound;

import net.rebel459.legacies_and_legends.LegaciesAndLegends;
import net.rebel459.legacies_and_legends.config.LaLConfig;
import net.rebel459.legacies_and_legends.tag.LaLBiomeTags;
import net.rebel459.unified.platform.UnifiedHelpers;
import net.minecraft.sounds.Musics;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.biome.Biomes;

public final class LaLBiomeMusic {

	public static void init() {
		UnifiedHelpers.BIOME_MODIFICATIONS.register(LaLBiomeTags.MUSIC_SNOWY, context -> {
			if (LaLConfig.get().music.snowy_music && (!LegaciesAndLegends.isWilderWildLoaded || !LaLConfig.get().integrations.wilder_wild)) {
				context.getEnvironmentAttributes().set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(Musics.createGameMusic(LaLSounds.SNOWY_MUSIC)));
			}
		});

		UnifiedHelpers.BIOME_MODIFICATIONS.register(LaLBiomeTags.MUSIC_SAVANNA, context -> {
			if (LaLConfig.get().music.savanna_music) {
				context.getEnvironmentAttributes().set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(Musics.createGameMusic(LaLSounds.SAVANNA_MUSIC)));
			}
		});

		UnifiedHelpers.BIOME_MODIFICATIONS.register(LaLBiomeTags.MUSIC_DARK_FOREST, context -> {
			if (LaLConfig.get().music.dark_forest_music) {
				context.getEnvironmentAttributes().set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(Musics.createGameMusic(LaLSounds.DARK_FOREST_MUSIC)));
			}
		});

		UnifiedHelpers.BIOME_MODIFICATIONS.register(Biomes.THE_END, context -> {
			if (LaLConfig.get().music.main_end_island_music) {
				context.getEnvironmentAttributes().set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(Musics.createGameMusic(LaLSounds.MAIN_END_ISLAND_MUSIC)));
			}
		});
	}
}
