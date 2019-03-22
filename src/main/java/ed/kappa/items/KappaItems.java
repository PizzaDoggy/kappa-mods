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
    @GameRegistry.ObjectHolder("kappa:hemp_seeds")
    public static ItemHempSeed hemp_seeds;
    @GameRegistry.ObjectHolder("kappa:hemp_fibers")
    public static ItemBase hemp_fibers;
    @GameRegistry.ObjectHolder("kappa:rope")
    public static ItemBase rope;
    @GameRegistry.ObjectHolder("kappa:flour")
    public static ItemBase flour;
    @GameRegistry.ObjectHolder("kappa:rock")
    public static ItemRock rock;
    @GameRegistry.ObjectHolder("kappa:gear")
    public static ItemBase gear;
    @GameRegistry.ObjectHolder("kappa:grinding_stone")
    public static ItemBase grinding_stone;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        wand.initModel();
        hemp.initModel();
        hemp_seeds.initModel();
        hemp_fibers.initModel();
        rope.initModel();
        flour.initModel();
        rock.initModel();
        gear.initModel();
        grinding_stone.initModel();
    }

    public static void register(IForgeRegistry<Item> registry) {
        registry.register(new ItemWand());
        registry.register(new ItemBase("hemp"));
        registry.register(new ItemHempSeed());
        registry.register(new ItemBase("hemp_fibers"));
        registry.register(new ItemBase("rope"));
        registry.register(new ItemBase("flour"));
        registry.register(new ItemRock());
        registry.register(new ItemBase("gear"));
        registry.register(new ItemBase("grinding_stone"));
    }
}
