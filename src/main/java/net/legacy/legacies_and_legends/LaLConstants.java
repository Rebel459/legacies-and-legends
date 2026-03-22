package net.legacy.legacies_and_legends;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LaLConstants {
	public static final String MOD_ID = "legacies_and_legends";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ModContainer MOD_CONTAINER = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();

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
