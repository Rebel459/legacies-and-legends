package net.rebel459.legacies_and_legends.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightmapRenderStateExtractor;
import net.minecraft.client.renderer.state.LightmapRenderState;
import net.minecraft.world.item.Items;
import net.rebel459.legacies_and_legends.config.LaLConfig;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightmapRenderStateExtractor.class)
public class LightmapRenderStateExtractorMixin {

    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(method = "extract", at = @At(value = "HEAD"))
    private void modifyNightVisionUniform(LightmapRenderState renderState, float partialTicks, CallbackInfo ci) {
        if (!LaLConfig.get.misc.improved_turtle_shell) return;
        LocalPlayer player = this.minecraft.player;
        if (player == null) return;
        if (player.isEquipped(Items.TURTLE_HELMET)) renderState.nightVisionEffectIntensity = player.getWaterVision();
    }
}