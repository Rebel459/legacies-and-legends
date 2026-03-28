package net.rebel459.legacies_and_legends.registry;

import net.frozenblock.lib.item.impl.sherd.DecoratedPotPatternRegistryEntrypoint;
import net.rebel459.legacies_and_legends.LaLConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import org.jetbrains.annotations.NotNull;

public class LaLDecoratedPotPatterns implements DecoratedPotPatternRegistryEntrypoint {

    @Override
    public void bootstrap(Registry<DecoratedPotPattern> registry) {
        register(registry, "dusk");
        register(registry, "harvest");
        register(registry, "verdant");
        register(registry, "forager");
    }

    public static void register(@NotNull Registry<DecoratedPotPattern> registry, String sherdName) {
        Identifier id = LaLConstants.id(sherdName + "_pottery_pattern");
        DecoratedPotPatternRegistryEntrypoint.register(
                registry,
                ResourceKey.create(Registries.DECORATED_POT_PATTERN, id),
                id
        );
    }
}