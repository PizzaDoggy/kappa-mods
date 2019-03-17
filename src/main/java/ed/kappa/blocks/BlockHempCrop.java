package ed.kappa.blocks;

import ed.kappa.Kappa;
import ed.kappa.items.KappaItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.init.Biomes;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockHempCrop extends BlockCrops {

    public static final PropertyInteger CROP_AGE = PropertyInteger.create("age", 0, 7);
    private static final AxisAlignedBB[] CROP_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.35D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.40D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D)};

    public BlockHempCrop(String name) {
        super();
        this.setRegistryName(new ResourceLocation(Kappa.MODID,"hemp_crop"));
        this.setTranslationKey(Kappa.MODID + ".hemp_crop");
    }

    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == Blocks.FARMLAND;
    }

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        IBlockState soil = worldIn.getBlockState(pos.down());
        return (((worldIn.getBiome(pos) == Biomes.JUNGLE || worldIn.getBiome(pos) == Biomes.JUNGLE_EDGE || worldIn.getBiome(pos) == Biomes.JUNGLE_HILLS)
                && worldIn.canSeeSky(pos)) && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), EnumFacing.UP, this)
                || ((!worldIn.canSeeSky(pos)) && worldIn.getLight(pos) >= 10 && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), EnumFacing.UP, this)));
    }

    protected PropertyInteger getAgeProperty()
    {
        return CROP_AGE;
    }

    public int getMaxAge()
    {
        return 7;
    }

    protected Item getSeed()
    {
        return KappaItems.hemp_seeds;
    }

    protected Item getCrop()
    {
        return KappaItems.hemp;
    }

    protected int getBonemealAgeIncrease(World worldIn)
    {
        return MathHelper.getInt(worldIn.rand, 1, 3);
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, CROP_AGE);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
