package net.rebel459.legacies_and_legends;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = LaLConstants.MOD_ID, dist = Dist.CLIENT)
public class LegaciesAndLegendsNeoForgeClient {

    public LegaciesAndLegendsNeoForgeClient(IEventBus modEventBus) {
        LegaciesAndLegendsClient.init();
    }
}