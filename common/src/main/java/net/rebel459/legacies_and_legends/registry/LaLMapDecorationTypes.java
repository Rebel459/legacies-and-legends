package net.rebel459.legacies_and_legends.registry;

import net.minecraft.resources.Identifier;
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

	public static UnifiedRegistries.DeferredRegistry DECORATIONS = UnifiedRegistries.DeferredRegistry.create(LaLConstants.MOD_ID, BuiltInRegistries.MAP_DECORATION_TYPE);

	public static final Holder<MapDecorationType> SIMPLE_DUNGEON = register(
			"simple_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> ARID_DUNGEON = register(
			"arid_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> FROZEN_DUNGEON = register(
			"frozen_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> DEEP_DUNGEON = register(
			"deep_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> VERDANT_DUNGEON = register(
			"verdant_dungeon",
			true,
			6450790,
			false,
			true
	);
	public static final Holder<MapDecorationType> INFERNAL_DUNGEON = register(
			"infernal_dungeon",
			true,
			6450790,
			false,
			true
	);

	public static void init() {}

	private static Holder<MapDecorationType> register(String string, boolean showOnItemFrame, int mapColor, boolean trackCount, boolean explorationMapElement) {
		return DECORATIONS.registerHolder(string, () -> new MapDecorationType(LaLConstants.id(string), showOnItemFrame, mapColor, explorationMapElement, trackCount));
	}
}