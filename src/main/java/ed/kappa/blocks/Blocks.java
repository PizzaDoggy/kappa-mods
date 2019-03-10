package ed.kappa.blocks;

import ed.kappa.blocks.grinder.BlockGrinder;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class Blocks {
    @GameRegistry.ObjectHolder("kappa:grinder")
    public static BlockGrinder grinder;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        grinder.initModel();
    }

    public static void register(IForgeRegistry<Block> registry) {
        registry.register(new BlockGrinder());
    }
}
