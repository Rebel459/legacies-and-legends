package net.legacy.legacies_and_legends.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.legacy.legacies_and_legends.registry.LaLBlocks;
import net.minecraft.client.renderer.RenderType;

@Environment(EnvType.CLIENT)
public final class LaLBlockRenderLayers {

	public static void init() {
		BlockRenderLayerMap renderLayerRegistry = BlockRenderLayerMap.INSTANCE;

		renderLayerRegistry.putBlock(LaLBlocks.SAPPHIRE_LANTERN, RenderType.cutout());
		renderLayerRegistry.putBlock(LaLBlocks.WAND_PLATFORM, RenderType.cutout());

	}
}