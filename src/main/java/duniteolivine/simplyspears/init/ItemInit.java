package duniteolivine.simplyspears.init;

import duniteolivine.simplyspears.SimplySpears;
import duniteolivine.simplyspears.world.item.SpearItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimplySpears.MODID);
    public static RegistryObject<SpearItem> IRON_SPEAR = ITEMS.register("iron_spear",() -> new SpearItem(Tiers.IRON,7.0F,-3.0F,new Item.Properties().durability(250).tab(CreativeModeTab.TAB_COMBAT)));
    public static RegistryObject<SpearItem> DIAMOND_SPEAR = ITEMS.register("diamond_spear",() -> new SpearItem(Tiers.DIAMOND,8.0F,-3.0F,new Item.Properties().durability(1560).tab(CreativeModeTab.TAB_COMBAT)));
}
