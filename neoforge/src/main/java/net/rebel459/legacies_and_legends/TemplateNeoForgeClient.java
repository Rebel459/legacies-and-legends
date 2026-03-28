package net.rebel459.legacies_and_legends;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = Template.MOD_ID, dist = Dist.CLIENT)
public class TemplateNeoForgeClient {

    public TemplateNeoForgeClient(IEventBus modEventBus) {
        TemplateClient.initClient();
    }
}