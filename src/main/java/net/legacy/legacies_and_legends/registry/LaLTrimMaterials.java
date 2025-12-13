package net.legacy.legacies_and_legends.registry;

import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.datagen.LaLModelProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;

import java.util.List;

public class LaLTrimMaterials {
    public static final List<String> TRIM_MATERIALS = List.of("echo_shard", "sapphire");

    public static final ResourceKey<TrimMaterial> ECHO = register("echo_shard");
    public static final ResourceKey<TrimMaterial> SAPPHIRE = register("sapphire");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        TrimMaterials.register(context, ECHO, Style.EMPTY.withColor(675936), LaLModelProvider.ECHO_SHARD);
        TrimMaterials.register(context, SAPPHIRE, Style.EMPTY.withColor(34303), LaLModelProvider.SAPPHIRE);
    }

    private static ResourceKey<TrimMaterial> register(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, LaLConstants.id(name));

    }
}
