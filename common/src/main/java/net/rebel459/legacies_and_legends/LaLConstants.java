package net.rebel459.legacies_and_legends;

import net.minecraft.resources.Identifier;
import net.rebel459.unified.api.codec.ExtensibleCodecs;
import net.rebel459.unified.api.codec.ExtensiblePredicateCodec;
import net.rebel459.unified.api.core.UnifiedData;
import net.rebel459.unified.api.registry.UnifiedLoadRequirementCodecs;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LaLConstants {
	public static final String MOD_ID = "legacies_and_legends";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	public static Identifier vanillaId(String path) {
		return Identifier.withDefaultNamespace(path);
	}

	public static String string(@NotNull String path) {
		return LaLConstants.id(path).toString();
	}

	public static UnifiedData DATA = UnifiedData.create(MOD_ID).autoName().build();

	public static UnifiedData dataWithMod(String modId) {
		return UnifiedData.create(MOD_ID).requirement(UnifiedLoadRequirementCodecs.MODS_LOADED.create(() -> List.of(modId))).autoName().build();
	}

	public static UnifiedData dataWithoutMod(String modId) {
		return UnifiedData.create(MOD_ID).requirement(ExtensibleCodecs.LOAD_REQUIREMENT.not().create(() -> UnifiedLoadRequirementCodecs.MODS_LOADED.create(() -> List.of(modId)))).autoName().build();
	}
}
