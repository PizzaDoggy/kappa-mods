package ed.kappa.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class KappaItems {
    @GameRegistry.ObjectHolder("kappa:wand")
    public static ItemWand wand;
    @GameRegistry.ObjectHolder("kappa:hemp")
    public static ItemBase hemp;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        wand.initModel();
        hemp.initModel();
    }

    public static void register(IForgeRegistry<Item> registry) {
        registry.register(new ItemWand());
        registry.register(new ItemBase("hemp"));
    }
}
