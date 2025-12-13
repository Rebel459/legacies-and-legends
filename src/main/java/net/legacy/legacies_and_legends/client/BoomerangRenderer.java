package net.legacy.legacies_and_legends.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.entity.BoomerangProjectile;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.ThrownTridentRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Environment(EnvType.CLIENT)
public class BoomerangRenderer extends EntityRenderer<BoomerangProjectile, BoomerangRenderState> {
    public static final Identifier TEXTURE = LaLConstants.id("textures/entity/boomerang.png");
    private final BoomerangModel<BoomerangProjectile> model;

    public BoomerangRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new BoomerangModel<>(context.bakeLayer(LaLModelLayers.BOOMERANG));
    }

    @Override
    public void submit(BoomerangRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(state.yRot - 45 + state.spinTick * 20));
        List<RenderType> list = ItemRenderer.getFoilRenderTypes(this.model.renderType(TEXTURE), false, state.isFoil);
        for (RenderType renderType : list) {
            submitNodeCollector.submitModel(
                    this.model,
                    state,
                    poseStack,
                    renderType,
                    state.lightCoords,
                    OverlayTexture.NO_OVERLAY,
                    state.outlineColor,
                    null
            );
        }
        poseStack.popPose();
        super.submit(state, poseStack, submitNodeCollector, cameraRenderState);
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
