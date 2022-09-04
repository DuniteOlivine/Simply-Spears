package duniteolivine.simplyspears.events;

import duniteolivine.simplyspears.SimplySpears;
import duniteolivine.simplyspears.client.renderer.entity.ThrownIronSpearRenderer;
import duniteolivine.simplyspears.client.renderer.entity.ThrownDiamondSpearRenderer;
import duniteolivine.simplyspears.client.renderer.models.DiamondSpearModel;
import duniteolivine.simplyspears.client.renderer.models.IronSpearModel;
import duniteolivine.simplyspears.init.EntityInit;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;;

@Mod.EventBusSubscriber(modid = SimplySpears.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void entityRenderer(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer((EntityType)ForgeRegistries.ENTITY_TYPES.getValue(EntityInit.iron_spear_resource), ThrownIronSpearRenderer::new);
        event.registerEntityRenderer((EntityType)ForgeRegistries.ENTITY_TYPES.getValue(EntityInit.diamond_spear_resource), ThrownDiamondSpearRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(IronSpearModel.LAYER_LOCATION, IronSpearModel::createLayer);
        event.registerLayerDefinition(DiamondSpearModel.DIAMOND_LAYER_LOCATION, DiamondSpearModel::createLayer);
    }
}

