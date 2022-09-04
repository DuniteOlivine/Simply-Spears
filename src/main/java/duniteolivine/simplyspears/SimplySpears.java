package duniteolivine.simplyspears;

import duniteolivine.simplyspears.init.EntityInit;
import duniteolivine.simplyspears.init.ItemInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SimplySpears.MODID)

public class SimplySpears {
    public static final String MODID = "simplyspears";
    public SimplySpears(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.ITEMS.register(bus);
        EntityInit.ENTITIES.register(bus);
    }
}
