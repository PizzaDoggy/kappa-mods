package ed.kappa.init;

import ed.kappa.blocks.BlockGrinder;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
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
