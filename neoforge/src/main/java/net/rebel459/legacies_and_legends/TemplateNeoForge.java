package net.rebel459.legacies_and_legends;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Template.MOD_ID)
public class TemplateNeoForge {

    public TemplateNeoForge(IEventBus modEventBus) {
        Template.initRegistries();
        modEventBus.addListener(TemplateNeoForge::commonSetup);
    }

    private static void commonSetup(final FMLCommonSetupEvent event) {
        Template.init();
    }
}