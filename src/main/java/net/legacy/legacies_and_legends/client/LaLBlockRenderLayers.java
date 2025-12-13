package net.legacy.legacies_and_legends.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

@Environment(EnvType.CLIENT)
public final class LaLBlockRenderLayers {

	public static void init() {

        BlockRenderLayerMap.putBlock(LaLBlocks.SAPPHIRE_LANTERN, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(LaLBlocks.WAND_PLATFORM, ChunkSectionLayer.CUTOUT);
	}
}