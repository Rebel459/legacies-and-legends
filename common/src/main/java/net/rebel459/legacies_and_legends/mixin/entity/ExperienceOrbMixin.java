package net.rebel459.legacies_and_legends.mixin.entity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.rebel459.legacies_and_legends.block.WandPlatformBlock;
import net.rebel459.legacies_and_legends.registry.LaLItems;
import net.rebel459.legacies_and_legends.util.AccessoryHelper;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ExperienceOrb.class)
public abstract class ExperienceOrbMixin {

    @Inject(method = "playerTouch", at = @At(value = "HEAD"))
    private void ringOfRestoration(Player player, CallbackInfo ci) {
        ItemStack stack = AccessoryHelper.getAccessory(player);
        if (stack.is(LaLItems.RING_OF_RESTORATION)) {
            player.heal(1);
            AccessoryHelper.damageAccessory(player, stack);
        }
    }

    @Unique
    private BlockState frictionState;

    @WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;"))
    public Block getBlock(BlockState state, Operation<Block> original) {
        this.frictionState = state;
        return original.call(state);
    }
    @WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Block;getFriction()F"))
    public float getFriction(Block block, Operation<Float> original) {
        if (block instanceof WandPlatformBlock) return WandPlatformBlock.getFriction(this.frictionState);
        else return original.call(block);
    }
}