package net.rebel459.legacies_and_legends.registry;

import net.rebel459.legacies_and_legends.LaLConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import org.jetbrains.annotations.NotNull;

public class LaLMapDecorationTypes {
	public static final Holder<MapDecorationType> SIMPLE_DUNGEON = register(
			"simple_dungeon",
			"simple_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> ARID_DUNGEON = register(
			"arid_dungeon",
			"arid_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> FROZEN_DUNGEON = register(
			"frozen_dungeon",
			"frozen_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> DEEP_DUNGEON = register(
			"deep_dungeon",
			"deep_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> VERDANT_DUNGEON = register(
			"verdant_dungeon",
			"verdant_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> INFERNAL_DUNGEON = register(
			"infernal_dungeon",
			"infernal_dungeon",
			true,
			6450790,
			false,
			true
	);

	public static void init() {
	}

	private static @NotNull Holder<MapDecorationType> register(String string, String string2, boolean showOnItemFrame, boolean trackCount) {
		return register(string, string2, showOnItemFrame, -1, trackCount, false);
	}

	private static @NotNull Holder<MapDecorationType> register(
			String string, String string2, boolean showOnItemFrame, int mapColor, boolean trackCount, boolean explorationMapElement
	) {
		ResourceKey<MapDecorationType> resourceKey = ResourceKey.create(Registries.MAP_DECORATION_TYPE, LaLConstants.id(string));
		MapDecorationType mapDecorationType = new MapDecorationType(
				LaLConstants.id(string2), showOnItemFrame, mapColor, explorationMapElement, trackCount
		);
		return Registry.registerForHolder(BuiltInRegistries.MAP_DECORATION_TYPE, resourceKey, mapDecorationType);
	}

}