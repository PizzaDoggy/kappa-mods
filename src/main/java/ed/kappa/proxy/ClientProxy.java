package ed.kappa.proxy;

import ed.kappa.blocks.KappaBlocks;
import ed.kappa.entity.EntityRock;
import ed.kappa.entity.EntityRockFactory;
import ed.kappa.items.KappaItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        KappaBlocks.initModels();
        KappaItems.initModels();
        RenderingRegistry.registerEntityRenderingHandler(EntityRock.class, new EntityRockFactory());
    }
}

