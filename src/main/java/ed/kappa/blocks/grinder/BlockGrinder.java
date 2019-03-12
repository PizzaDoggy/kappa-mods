package ed.kappa.blocks.grinder;

import ed.kappa.Kappa;
import ed.kappa.blocks.BlockBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockGrinder extends BlockBase implements ITileEntityProvider {

    public BlockGrinder() {
        super("grinder", Material.ROCK);
        setHarvestLevel("pickaxe", 0);
        setHardness(1);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileGrinder();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        // Only execute on the server
        if (world.isRemote)
            return true;
        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof TileGrinder))
            return false;
        player.openGui(Kappa.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
