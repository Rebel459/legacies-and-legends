package net.legacy.legacies_and_legends.sound;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.LegaciesAndLegends;
import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.tag.LaLBiomeTags;
import net.minecraft.sounds.Musics;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public final class LaLMusic {

	public static void insertMusic() {
		BiomeModifications.create(LaLConstants.id("snowy_music")).add(
				ModificationPhase.REPLACEMENTS,
				BiomeSelectors.tag(LaLBiomeTags.MUSIC_SNOWY),
				(selectionContext, modificationContext) -> {
					if (LaLConfig.get.music.snowy_music && !LegaciesAndLegends.isWilderWildLoaded) {
						modificationContext.getEffects().setMusic(Musics.createGameMusic(LaLSounds.SNOWY_MUSIC));
					}
					else if (LaLConfig.get.music.snowy_music && !LaLConfig.get.integrations.wilder_wild) {
						modificationContext.getEffects().setMusic(Musics.createGameMusic(LaLSounds.SNOWY_MUSIC));
					}
				});

		BiomeModifications.create(LaLConstants.id("savanna_music")).add(
				ModificationPhase.REPLACEMENTS,
				BiomeSelectors.tag(LaLBiomeTags.MUSIC_SAVANNA),
				(selectionContext, modificationContext) -> {
					if (LaLConfig.get.music.savanna_music) {
						modificationContext.getEffects().setMusic(Musics.createGameMusic(LaLSounds.SAVANNA_MUSIC));
					}
				});

		BiomeModifications.create(LaLConstants.id("dark_forest_music")).add(
				ModificationPhase.REPLACEMENTS,
				BiomeSelectors.tag(LaLBiomeTags.MUSIC_DARK_FOREST),
				(selectionContext, modificationContext) -> {
					if (LaLConfig.get.music.dark_forest_music) {
						modificationContext.getEffects().setMusic(Musics.createGameMusic(LaLSounds.DARK_FOREST_MUSIC));
					}
				});

		BiomeModifications.create(LaLConstants.id("end_island_music")).add(
				ModificationPhase.REPLACEMENTS,
				BiomeSelectors.includeByKey(Biomes.THE_END),
				(selectionContext, modificationContext) -> {
					if (LaLConfig.get.music.main_end_island_music) {
						modificationContext.getEffects().setMusic(Musics.createGameMusic(LaLSounds.MAIN_END_ISLAND_MUSIC));
					}
				});
	}
}