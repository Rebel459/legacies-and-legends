package net.rebel459.legacies_and_legends.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class WandPlatformBlock extends TransparentSlabBlock {

    public WandPlatformBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void tick(BlockState state, @NotNull ServerLevel level, BlockPos pos, RandomSource random) {
        level.destroyBlock(pos, false);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        entity.causeFallDamage(fallDistance, 0F, entity.damageSources().fall());
    }
}
