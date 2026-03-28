package net.rebel459.legacies_and_legends.client;

import net.rebel459.legacies_and_legends.registry.LaLEntityTypes;
import net.rebel459.unified.platform.client.UnifiedClientHelpers;

public class LaLEntityRenderers {

    public static void init() {
        UnifiedClientHelpers.ENTITY_RENDERERS.addEntityRenderer(LaLEntityTypes.BOOMERANG, BoomerangRenderer::new);
    }
}
