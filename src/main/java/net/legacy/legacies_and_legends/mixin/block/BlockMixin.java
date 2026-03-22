package net.legacy.legacies_and_legends.mixin.block;

import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.util.AccessoryHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "playerDestroy", at = @At(value = "TAIL"))
    private void excavationRing(Level level, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool, CallbackInfo ci) {
        ItemStack stack = AccessoryHelper.getAccessory(player);
        if (AccessoryHelper.getAccessory(player).is(LaLItems.RING_OF_EXCAVATION)) {
            AccessoryHelper.damageAccessory(player, stack);
        }
    }
}
