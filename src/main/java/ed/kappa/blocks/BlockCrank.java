package ed.kappa.blocks;

import ed.kappa.Kappa;
import ed.kappa.blocks.grinder.TileGrinder;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCrank extends BlockBase {
    public static final PropertyBool POWERED = PropertyBool.create("powered");
    protected static final AxisAlignedBB CRANK_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, .125D, 1.0D);

    // TODO fix crank hitbox, can't walk across it
    // TODO only place crank on top another block
    public BlockCrank() {
        super("crank", Material.ROCK);
        setHarvestLevel("pickaxe", 0);
        setHardness(1);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return CRANK_AABB;
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{POWERED});
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(POWERED, (meta & 8) > 0);
    }

    public int getMetaFromState(IBlockState state) {
        int i = 0;
        if ((Boolean)state.getValue(POWERED))
            i |= 8;
        return i;
    }

    @Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
	public boolean isTranslucent(IBlockState state) {
		return true;
	}

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            TileEntity tileentity = worldIn.getTileEntity(pos.down());
            if (tileentity instanceof TileGrinder) {
                TileGrinder te = (TileGrinder) tileentity;
                if (te.getProgress() == 0)
                    te.startGrinding();
                else
                    te.attemptGrinding();
            }
            state = state.cycleProperty(POWERED);
            worldIn.setBlockState(pos, state, 3);
            float pitch = (Boolean)state.getValue(POWERED) ? 0.6F : 0.5F;
            worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.3F, pitch);
        }
        return true;
    }

//    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side) {
//        return canAttachTo(worldIn, pos, side);
//    }

//    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
//        return true;
//        IBlockState iblockstate = worldIn.getBlockState(pos);
//        boolean flag = iblockstate.getBlockFaceShape(worldIn, blockpos, direction) == BlockFaceShape.SOLID;
//        Block block = iblockstate.getBlock();
//        if (direction == EnumFacing.UP) {
//            return iblockstate.isTopSolid() || !isExceptionBlockForAttaching(block) && flag;
//        } else {
//            return !isExceptBlockForAttachWithPiston(block) && flag;
//        }
//
//        if (worldIn.getBlockState(pos.down()).())
//        EnumFacing[] var3 = EnumFacing.values();
//        int var4 = var3.length;
//
//        for(int var5 = 0; var5 < var4; ++var5) {
//            EnumFacing enumfacing = var3[var5];
//            if (canAttachTo(worldIn, pos, enumfacing)) {
//                return true;
//            }
//        }
//
//        return false;
//    }

//    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
//        if (this.checkCanSurvive(worldIn, pos, state) && !canAttachTo(worldIn, pos, ((BlockLever.EnumOrientation)state.getValue(FACING)).getFacing())) {
//            this.dropBlockAsItem(worldIn, pos, state, 0);
//            worldIn.setBlockToAir(pos);
//        }
//
//    }
//
//    private boolean checkCanSurvive(World worldIn, BlockPos pos, IBlockState state) {
//        if (this.canPlaceBlockAt(worldIn, pos)) {
//            return true;
//        } else {
//            this.dropBlockAsItem(worldIn, pos, state, 0);
//            worldIn.setBlockToAir(pos);
//            return false;
//        }
//    }

}
