package net.rebel459.legacies_and_legends.mixin.entity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.rebel459.legacies_and_legends.block.WandPlatformBlock;
import net.rebel459.legacies_and_legends.item.WandItem;
import net.rebel459.legacies_and_legends.registry.LaLDataComponents;
import net.rebel459.legacies_and_legends.registry.LaLItems;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.level.Level;
import net.rebel459.legacies_and_legends.util.Gem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {

    @Shadow
    public abstract ItemStack getItem();

    protected ItemEntityMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Inject(at = @At("HEAD"), method = "playerTouch")
    private void dropWand(CallbackInfo ci) {
        ItemStack stack = this.getItem();
        if (stack.getItem() instanceof WandItem) {
            WandItem.checkComponents(stack);
            WandItem.updateModel(stack, stack.get(LaLDataComponents.WAND_SLOTS.get()), true);
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