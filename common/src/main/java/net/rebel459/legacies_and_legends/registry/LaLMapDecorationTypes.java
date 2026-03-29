package net.rebel459.legacies_and_legends.registry;

import net.rebel459.legacies_and_legends.LaLConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.rebel459.unified.platform.UnifiedRegistries;
import org.jetbrains.annotations.NotNull;

public class LaLMapDecorationTypes {

	public static UnifiedRegistries.MapDecorationTypes DECORATIONS = UnifiedRegistries.MapDecorationTypes.create(LaLConstants.MOD_ID);

	public static final Holder<MapDecorationType> SIMPLE_DUNGEON = DECORATIONS.register(
			"simple_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> ARID_DUNGEON = DECORATIONS.register(
			"arid_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> FROZEN_DUNGEON = DECORATIONS.register(
			"frozen_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> DEEP_DUNGEON = DECORATIONS.register(
			"deep_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> VERDANT_DUNGEON = DECORATIONS.register(
			"verdant_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> INFERNAL_DUNGEON = DECORATIONS.register(
			"infernal_dungeon",
			true,
			6450790,
			false,
			true
	);

	public static void init() {}
}