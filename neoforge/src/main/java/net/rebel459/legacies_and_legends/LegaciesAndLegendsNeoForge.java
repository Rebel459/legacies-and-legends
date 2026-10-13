package net.rebel459.legacies_and_legends;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.rebel459.unified.neoforge.NeoForgeUnifiedBus;

@Mod(LaLConstants.MOD_ID)
public class LegaciesAndLegendsNeoForge {

    public LegaciesAndLegendsNeoForge(IEventBus modEventBus) {
        NeoForgeUnifiedBus.register(LaLConstants.MOD_ID, modEventBus);
        LegaciesAndLegends.initRegistries();
        modEventBus.addListener(LegaciesAndLegendsNeoForge::commonSetup);
    }

    private static void commonSetup(final FMLCommonSetupEvent event) {
        LegaciesAndLegends.init();
    }
}