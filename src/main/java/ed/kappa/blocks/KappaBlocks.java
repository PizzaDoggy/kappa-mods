package ed.kappa.blocks;

import ed.kappa.blocks.grinder.BlockGrinder;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class KappaBlocks {
    @GameRegistry.ObjectHolder("kappa:grinder")
    public static BlockGrinder grinder;
    @GameRegistry.ObjectHolder("kappa:crank")
    public static BlockCrank crank;
    @GameRegistry.ObjectHolder("kappa:hemp_crop")
    public static BlockHempCrop hemp_crop;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        grinder.initModel();
        crank.initModel();
        hemp_crop.initModel();
    }

    public static void register(IForgeRegistry<Block> registry) {
        registry.register(new BlockGrinder());
        registry.register(new BlockCrank());
        registry.register(new BlockHempCrop("hemp_crop"));
    }
}
