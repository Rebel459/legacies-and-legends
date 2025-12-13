package net.legacy.legacies_and_legends;

import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	public static Identifier vanillaId(String path) {
		return Identifier.fromNamespaceAndPath(Identifier.DEFAULT_NAMESPACE, path);
	}

	public static String string(@NotNull String path) {
		return LaLConstants.id(path).toString();
	}

}
