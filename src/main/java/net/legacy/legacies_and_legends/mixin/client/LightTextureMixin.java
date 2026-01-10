package net.legacy.legacies_and_legends.mixin.client;

import net.legacy.legacies_and_legends.config.LaLConfig;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LightTexture.class)
public class LightTextureMixin {

    @ModifyVariable(
            method = "updateLightTexture(F)V",
            name = "n",
            at = @At("STORE")
    )
    private float turtleHelmetVision(float original) {
        if (!LaLConfig.get.misc.improved_turtle_shell) return original;
        LightTexture light = LightTexture.class.cast(this);
        LocalPlayer player = light.minecraft.player;
        float waterVision = player.getWaterVision();
        if (player.isEquipped(Items.TURTLE_HELMET) && waterVision > original) return player.getWaterVision();
        return original;
    }
}