package duniteolivine.simplyspears.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import duniteolivine.simplyspears.client.renderer.models.DiamondSpearModel;
import duniteolivine.simplyspears.world.entity.projectile.ThrownDiamondSpear;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class ThrownDiamondSpearRenderer extends EntityRenderer<ThrownDiamondSpear> {
    public static final ResourceLocation DIAMOND_SPEAR_LOCATION = new ResourceLocation("simplyspears:textures/entity/diamond_spear.png");
    private final DiamondSpearModel model;

    public ThrownDiamondSpearRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
        this.model = new DiamondSpearModel(ctx.bakeLayer(DiamondSpearModel.DIAMOND_LAYER_LOCATION));
    }

    public void render(ThrownDiamondSpear p_116111_, float p_116112_, float p_116113_, PoseStack p_116114_, MultiBufferSource p_116115_, int p_116116_) {
        p_116114_.pushPose();
        p_116114_.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(p_116113_, p_116111_.yRotO, p_116111_.getYRot()) - 90.0F));
        p_116114_.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(p_116113_, p_116111_.xRotO, p_116111_.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(p_116115_, this.model.renderType(this.getTextureLocation(p_116111_)), false, p_116111_.isFoil());
        this.model.renderToBuffer(p_116114_, vertexconsumer, p_116116_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        p_116114_.popPose();
        super.render(p_116111_, p_116112_, p_116113_, p_116114_, p_116115_, p_116116_);
    }

    public ResourceLocation getTextureLocation(@NotNull ThrownDiamondSpear p_116109_) {
        return DIAMOND_SPEAR_LOCATION;
    }
}