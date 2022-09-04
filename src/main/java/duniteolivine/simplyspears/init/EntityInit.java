package duniteolivine.simplyspears.init;

import duniteolivine.simplyspears.SimplySpears;
import duniteolivine.simplyspears.world.entity.projectile.ThrownDiamondSpear;
import duniteolivine.simplyspears.world.entity.projectile.ThrownIronSpear;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SimplySpears.MODID);
    public static ResourceLocation iron_spear_resource = new ResourceLocation(SimplySpears.MODID,"iron_spear");
    public static ResourceLocation diamond_spear_resource = new ResourceLocation(SimplySpears.MODID,"diamond_spear");
    public static final RegistryObject<EntityType<ThrownIronSpear>> IRON_SPEAR = ENTITIES.register("iron_spear",() -> EntityType.Builder.<ThrownIronSpear>of(ThrownIronSpear::new, MobCategory.MISC).build(iron_spear_resource.toString()));
    public static final RegistryObject<EntityType<ThrownDiamondSpear>> DIAMOND_SPEAR = ENTITIES.register("diamond_spear",() -> EntityType.Builder.<ThrownDiamondSpear>of(ThrownDiamondSpear::new, MobCategory.MISC).build(diamond_spear_resource.toString()));
}
