package net.legacy.legacies_and_legends.registry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;

public final class LaLFuelRegistry {
    public static void registerFuels() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(LaLItems.WOODEN_BUCKET, 300);
            builder.add(LaLItems.COAL_BUCKET, 20000);
            builder.add(LaLItems.CHARCOAL_BUCKET, 20000);
        });
    }
}