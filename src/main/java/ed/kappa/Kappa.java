package ed.kappa;

import ed.kappa.items.KappaItems;
import ed.kappa.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Kappa.MODID, name = Kappa.MODNAME, version = Kappa.MODVERSION, dependencies = "required-after:forge@[14.23.5.2768,)", useMetadata = true)
public class Kappa {

    public static final String MODID = "kappa";
    public static final String MODNAME = "Kappa";
    public static final String MODVERSION= "0.0.1";

    @SidedProxy(clientSide = "ed.kappa.proxy.ClientProxy", serverSide = "ed.kappa.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static CreativeTabs creativeTab = new CreativeTabs("kappa") {
        @Override
        public ItemStack createIcon() { return new ItemStack(KappaItems.hemp); }
    };

    @Mod.Instance
    public static Kappa instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
