package net.legacy.legacies_and_legends;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.legacies_and_legends.client.LaLBlockRenderLayers;
import net.legacy.legacies_and_legends.client.LaLEntityRenderers;
import net.legacy.legacies_and_legends.client.LaLModelLayers;
import net.legacy.legacies_and_legends.client.LaLStructureMusic;
import net.legacy.legacies_and_legends.config.LaLConfig;
import net.minecraft.network.chat.Component;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public final class LegaciesAndLegendsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(LaLConstants.MOD_ID);

        LaLEntityRenderers.init();
        LaLModelLayers.init();
        LaLBlockRenderLayers.init();
        LaLStructureMusic.init();

        ResourceManagerHelper.registerBuiltinResourcePack(
                LaLConstants.id("asset_overrides"), modContainer.get(),
                Component.translatable("pack.legacies_and_legends.asset_overrides"),
                ResourcePackActivationType.ALWAYS_ENABLED
        );
        if (LaLConfig.get.music.music_and_melody) {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    LaLConstants.id("music_and_melody"), modContainer.get(),
                    Component.translatable("pack.legacies_and_legends.music_and_melody"),
                    ResourcePackActivationType.ALWAYS_ENABLED
            );
        }
        if (!LaLConfig.get.music.end_portal_music) {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    LaLConstants.id("no_end_portal_music"), modContainer.get(),
                    Component.translatable("pack.legacies_and_legends.no_end_portal_music"),
                    ResourcePackActivationType.ALWAYS_ENABLED
            );
        }
    }
}
