package net.legacy.legacies_and_legends.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.world.level.Level;

import java.util.Optional;

public interface PlatformInterface {
    void lal$setLastPlatformPos(Level level, BlockPos pos);
    void lal$eraseLastPlatformPos();
    Optional<GlobalPos> lal$getLastPlatformPos();
    boolean getPlatformSummoned();
    void setPlatformSummoned(boolean summoned);
}
