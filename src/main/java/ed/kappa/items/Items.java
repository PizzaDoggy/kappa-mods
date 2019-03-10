package ed.kappa.items;

import ed.kappa.items.ItemBase;
import ed.kappa.items.ItemRock;
import ed.kappa.items.ItemWand;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class Items {
    @GameRegistry.ObjectHolder("kappa:wand")
    public static ItemWand wand;
    @GameRegistry.ObjectHolder("kappa:hemp")
    public static ItemBase hemp;
    @GameRegistry.ObjectHolder("kappa:rock")
    public static ItemRock rock;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        wand.initModel();
        hemp.initModel();
        rock.initModel();
    }

    public static void register(IForgeRegistry<Item> registry) {
        registry.register(new ItemWand());
        registry.register(new ItemBase("hemp"));
        registry.register(new ItemRock());
    }
}
