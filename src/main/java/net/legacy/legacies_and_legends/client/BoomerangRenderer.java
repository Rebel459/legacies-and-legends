package net.legacy.legacies_and_legends.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.entity.BoomerangProjectile;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class BoomerangRenderer extends EntityRenderer<BoomerangProjectile, BoomerangRenderState> {
    public static final Identifier TEXTURE = LaLConstants.id("textures/entity/boomerang.png");
    private final BoomerangModel<BoomerangProjectile> model;

    public BoomerangRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new BoomerangModel<>(context.bakeLayer(LaLModelLayers.BOOMERANG));
    }

    @Override
    public void render(@NotNull BoomerangRenderState boomerangRenderState, @NotNull PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(boomerangRenderState.yRot - 45 + boomerangRenderState.spinTick * 20));
        VertexConsumer vertexConsumer = ItemRenderer.getFoilBuffer(multiBufferSource, this.model.renderType(TEXTURE), false, boomerangRenderState.isFoil);
        this.model.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(boomerangRenderState, poseStack, multiBufferSource, i);
    }

    @Override
    public @NotNull BoomerangRenderState createRenderState() {
        return new BoomerangRenderState();
    }

    public void extractRenderState(BoomerangProjectile boomerangProjectile, BoomerangRenderState boomerangRenderState, float partialTick) {
        super.extractRenderState(boomerangProjectile, boomerangRenderState, partialTick);
        //boomerangRenderState.yRot = boomerangProjectile.getYRot(partialTick);
        boomerangRenderState.xRot = boomerangProjectile.getXRot(partialTick);
        boomerangRenderState.boomerangYaw = boomerangProjectile.getBoomerangYaw(partialTick);
        boomerangRenderState.wobbleProgress = boomerangProjectile.getWobbleProgress(partialTick);
        boomerangRenderState.spinTick = boomerangProjectile.getSpinTick();
        boomerangRenderState.isFoil = boomerangProjectile.isFoil();
    }
}
