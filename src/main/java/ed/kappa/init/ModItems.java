package ed.kappa.init;

import ed.kappa.items.ItemBase;
import ed.kappa.items.ItemHemp;
import ed.kappa.items.ItemWand;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    @GameRegistry.ObjectHolder("kappa:wand")
    public static ItemWand wand;

    @GameRegistry.ObjectHolder("kappa:hemp")
    public static ItemHemp hemp;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        wand.initModel();
        hemp.initModel();
    }

    public static void register(IForgeRegistry<Item> registry) {
        registry.register(new ItemWand());
        registry.register(new ItemHemp());
    }
}
