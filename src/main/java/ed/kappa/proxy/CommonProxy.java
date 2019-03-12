package ed.kappa.proxy;

import ed.kappa.Kappa;
import ed.kappa.blocks.BlockCrank;
import ed.kappa.blocks.grinder.BlockGrinder;
import ed.kappa.blocks.grinder.TileGrinder;
import ed.kappa.items.ItemBase;
import ed.kappa.items.ItemRock;
import ed.kappa.items.ItemWand;
import ed.kappa.blocks.KappaBlocks;
import ed.kappa.items.KappaItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Kappa.instance, new GuiProxy());
        GameRegistry.addSmelting(new ItemStack(KappaItems.flour), new ItemStack(Items.BREAD), 1.0f);
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockGrinder());
        event.getRegistry().register(new BlockCrank());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(KappaBlocks.grinder).setRegistryName(KappaBlocks.grinder.getRegistryName()));
        GameRegistry.registerTileEntity(TileGrinder.class, new ResourceLocation(Kappa.MODID,"grinder"));
        event.getRegistry().register(new ItemBlock(KappaBlocks.crank).setRegistryName(KappaBlocks.crank.getRegistryName()));
        event.getRegistry().register(new ItemWand());
        event.getRegistry().register(new ItemBase("hemp"));
        event.getRegistry().register(new ItemBase("rope"));
        event.getRegistry().register(new ItemBase("flour"));
        event.getRegistry().register(new ItemRock());
        event.getRegistry().register(new ItemBase("gear"));
    }
}

