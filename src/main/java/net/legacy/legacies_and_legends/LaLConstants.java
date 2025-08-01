package net.legacy.legacies_and_legends;

import dev.emi.trinkets.api.TrinketsApi;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Map;

public class LaLConstants {
	public static final String MOD_ID = "legacies_and_legends";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ModContainer MOD_CONTAINER = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();

	public static boolean hasAccessory(Player player) {
		return (TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_BARTERING) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_ISOLATION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_LEAPING) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_PROTECTION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_PURITY) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_REGENERATION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_RESILIENCE) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.RING_OF_RESTORATION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.RING_OF_EXCAVATION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.RING_OF_CONSTRUCTION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.RING_OF_EVASION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.RING_OF_HUNTING) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.RING_OF_STRIKING) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.RING_OF_ARCHERY) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.AMULET_OF_DEFLECTION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.AMULET_OF_OBSIDIAN) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.AMULET_OF_ABSORPTION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.TOTEM_OF_RESURRECTION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.TOTEM_OF_TELEPORTATION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(Items.TOTEM_OF_UNDYING)
		);
	}
	public static boolean hasNecklace(Player player) {
		return (TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_BARTERING) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_ISOLATION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_LEAPING) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_PROTECTION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_PURITY) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_REGENERATION) ||
				TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_RESILIENCE)
		);
	}

	/**
	 * Used for datafixers.
	 * <p>
	 * Is not necessary for a normal mod, but can be useful in some cases.
	 */
	public static final int DATA_VERSION = 0;
	// MEASURING
	public static final Map<Object, Long> INSTANT_MAP = new Object2ObjectOpenHashMap<>();
	public static boolean DEV_LOGGING = false;
	/**
	 * Used for features that may be unstable and crash in public builds.
	 * <p>
	 * It's smart to use this for at least registries.
	 */
	public static boolean UNSTABLE_LOGGING = FabricLoader.getInstance().isDevelopmentEnvironment();

	public static void startMeasuring(Object object) {
		long started = System.nanoTime();
		String name = object.getClass().getName();
		LOGGER.info("Started measuring {}", name.substring(name.lastIndexOf(".") + 1));
		INSTANT_MAP.put(object, started);
	}

	public static void stopMeasuring(Object object) {
		if (INSTANT_MAP.containsKey(object)) {
			String name = object.getClass().getName();
			LOGGER.info("{} took {} nanoseconds", name.substring(name.lastIndexOf(".") + 1), System.nanoTime() - INSTANT_MAP.get(object));
			INSTANT_MAP.remove(object);
		}
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	public static ResourceLocation vanillaId(String path) {
		return ResourceLocation.fromNamespaceAndPath(ResourceLocation.DEFAULT_NAMESPACE, path);
	}

	public static String string(@NotNull String path) {
		return LaLConstants.id(path).toString();
	}

	public static String safeString(String path) {
		return MOD_ID + "_" + path;
	}

	/**
	 * @return A text component for use in a Config GUI
	 */
	public static Component text(String key) {
		return Component.translatable("option." + MOD_ID + "." + key);
	}

	/**
	 * @return A tooltip component for use in a Config GUI
	 */
	public static Component tooltip(String key) {
		return Component.translatable("tooltip." + MOD_ID + "." + key);
	}

	public static Path configPath(String name, boolean json5) {
		return Path.of("./config/" + MOD_ID + "/" + name + "." + (json5 ? "json5" : "json"));
	}
}
