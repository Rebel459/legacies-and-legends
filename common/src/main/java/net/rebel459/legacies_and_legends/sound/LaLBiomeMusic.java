package net.rebel459.legacies_and_legends.sound;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.rebel459.legacies_and_legends.LaLConstants;
import net.rebel459.legacies_and_legends.LegaciesAndLegends;
import net.rebel459.legacies_and_legends.config.LaLConfig;
import net.rebel459.legacies_and_legends.tag.LaLBiomeTags;
import net.minecraft.sounds.Musics;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.biome.Biomes;

public final class LaLBiomeMusic {

	public static void init() {
		BiomeModifications.create(LaLConstants.id("snowy_music")).add(
				ModificationPhase.REPLACEMENTS,
				BiomeSelectors.tag(LaLBiomeTags.MUSIC_SNOWY),
				(selectionContext, modificationContext) -> {
					if (LaLConfig.get.music.snowy_music && (!LegaciesAndLegends.isWilderWildLoaded || !LaLConfig.get.integrations.wilder_wild)) {
						modificationContext.getAttributes().set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(Musics.createGameMusic(LaLSounds.SNOWY_MUSIC)));
					}
				});

		BiomeModifications.create(LaLConstants.id("savanna_music")).add(
				ModificationPhase.REPLACEMENTS,
				BiomeSelectors.tag(LaLBiomeTags.MUSIC_SAVANNA),
				(selectionContext, modificationContext) -> {
					if (LaLConfig.get.music.savanna_music) {
                        modificationContext.getAttributes().set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(Musics.createGameMusic(LaLSounds.SAVANNA_MUSIC)));
					}
				});

		BiomeModifications.create(LaLConstants.id("dark_forest_music")).add(
				ModificationPhase.REPLACEMENTS,
				BiomeSelectors.tag(LaLBiomeTags.MUSIC_DARK_FOREST),
				(selectionContext, modificationContext) -> {
					if (LaLConfig.get.music.dark_forest_music) {
                        modificationContext.getAttributes().set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(Musics.createGameMusic(LaLSounds.DARK_FOREST_MUSIC)));
					}
				});

		BiomeModifications.create(LaLConstants.id("end_island_music")).add(
				ModificationPhase.REPLACEMENTS,
				BiomeSelectors.includeByKey(Biomes.THE_END),
				(selectionContext, modificationContext) -> {
					if (LaLConfig.get.music.main_end_island_music) {
                        modificationContext.getAttributes().set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(Musics.createGameMusic(LaLSounds.MAIN_END_ISLAND_MUSIC)));
					}
				});
	}
}