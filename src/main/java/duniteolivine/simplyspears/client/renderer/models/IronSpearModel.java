package duniteolivine.simplyspears.client.renderer.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import duniteolivine.simplyspears.SimplySpears;
import duniteolivine.simplyspears.world.entity.projectile.ThrownIronSpear;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IronSpearModel extends Model {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SimplySpears.MODID,"iron_spear"),"main");
    private final ModelPart body;

    public IronSpearModel(ModelPart root) {
        super(RenderType::entitySolid);
        this.body = root.getChild("pole");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("pole", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 5.0F, -0.5F, 1.0F, 24.0F, 1.0F), PartPose.ZERO);
        partdefinition1.addOrReplaceChild("base", CubeListBuilder.create().texOffs(4, 0).addBox(-2.5F, 2.0F, -0.5F, 5.0F, 2.0F, 1.0F), PartPose.ZERO);
        partdefinition1.addOrReplaceChild("blade", CubeListBuilder.create().texOffs(4, 3).addBox(-1.5F, -1.0F, -0.5F, 3.0F, 3.0F, 1.0F), PartPose.ZERO);
        partdefinition1.addOrReplaceChild("tip", CubeListBuilder.create().texOffs(4 ,7).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 2.0F, 1.0F), PartPose.ZERO);
        partdefinition1.addOrReplaceChild("binding", CubeListBuilder.create().texOffs(16, 0).addBox(-1.5F, 4.0F, -0.5F, 3.0F, 1.0F, 1.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    public void setupAnim(ThrownIronSpear entity){

    }

    public void renderToBuffer(PoseStack p_103919_, VertexConsumer p_103920_, int p_103921_, int p_103922_, float p_103923_, float p_103924_, float p_103925_, float p_103926_) {
        body.render(p_103919_, p_103920_, p_103921_, p_103922_, p_103923_, p_103924_, p_103925_, p_103926_);
    }
}
