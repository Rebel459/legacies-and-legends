package net.rebel459.legacies_and_legends.mixin.client;

import net.minecraft.sounds.Music;
import net.rebel459.legacies_and_legends.client.LaLStructureMusic;
import net.rebel459.legacies_and_legends.registry.LaLItems;
import net.rebel459.legacies_and_legends.util.AccessoryHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow private int rightClickDelay;

    @Shadow @Nullable public LocalPlayer player;

    @Inject(method = "startUseItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/InteractionHand;values()[Lnet/minecraft/world/InteractionHand;"))
    private void ringOfConstruction(CallbackInfo ci) {
        if (AccessoryHelper.getAccessory(this.player).is(LaLItems.RING_OF_CONSTRUCTION)) this.rightClickDelay = 3;
    }

    @Inject(method = "getSituationalMusic", at = @At("HEAD"), cancellable = true)
    private void structureMusicOverride(CallbackInfoReturnable<Music> cir) {
        Minecraft minecraft = Minecraft.class.cast(this);
        Music override = LaLStructureMusic.getOverride(minecraft);
        if (override != null) {
            cir.setReturnValue(override);
        }
    }
}
