package net.rebel459.legacies_and_legends;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.world.item.Items;
import net.rebel459.legacies_and_legends.config.LaLConfig;
import net.rebel459.legacies_and_legends.registry.LaLTrimMaterials;
import net.rebel459.legacies_and_legends.util.loot.LootTableFabricEvent;

public class LegaciesAndLegendsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        LootTableFabricEvent.init();
        LegaciesAndLegends.initRegistries();
        LegaciesAndLegends.init();
        DefaultItemComponentEvents.MODIFY.register(context -> {
            context.modify(Items.ECHO_SHARD, (builder, lookupProvider, item) -> {
                if (LaLConfig.get().misc.echo_shard_trim) {
                    if (item == Items.ECHO_SHARD) {
                        builder.set(DataComponents.PROVIDES_TRIM_MATERIAL, lookupProvider.lookup(Registries.TRIM_MATERIAL).get().getOrThrow(LaLTrimMaterials.ECHO));
                    }
                }
            });
        });
    }
}
