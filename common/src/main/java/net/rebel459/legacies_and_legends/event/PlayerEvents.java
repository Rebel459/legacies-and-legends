package net.rebel459.legacies_and_legends.event;

import net.minecraft.world.level.gamerules.GameRules;
import net.rebel459.legacies_and_legends.util.AccessoryHelper;
import net.rebel459.unified.platform.UnifiedEvents;

public class PlayerEvents {

    public static void init(){
        UnifiedEvents.Players.onRespawn((oldPlayer, newPlayer) -> {
            var level = newPlayer.level;
            var serverLevel = level.getServer().getLevel(level.dimension());
            if (serverLevel == null) return;
            if (serverLevel.getGameRules().get(GameRules.KEEP_INVENTORY)) AccessoryHelper.setAccessory(newPlayer, AccessoryHelper.getActualAccessory(oldPlayer));
        });
    }
}
