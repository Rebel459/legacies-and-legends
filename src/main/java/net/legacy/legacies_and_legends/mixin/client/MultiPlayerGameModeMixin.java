package net.legacy.legacies_and_legends.mixin.client;

import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.util.AccessoryHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MultiPlayerGameMode.class)
public class MultiPlayerGameModeMixin {
    @Shadow @Final private Minecraft minecraft;

    @ModifyConstant(method = "continueDestroyBlock", constant = @Constant(intValue = 5))
    private int ringOfExcavation(int value) {
        if (AccessoryHelper.getAccessory(this.minecraft.player).is(LaLItems.RING_OF_EXCAVATION)) return 2;
        else return 5;
    }
}