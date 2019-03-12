package ed.kappa.proxy;

import ed.kappa.blocks.grinder.ContainerGrinder;
import ed.kappa.blocks.grinder.GuiGrinder;
import ed.kappa.blocks.grinder.TileGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileGrinder) {
            return new ContainerGrinder(player.inventory, (TileGrinder) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileGrinder) {
            TileGrinder containerTileEntity = (TileGrinder) te;
            return new GuiGrinder(containerTileEntity, new ContainerGrinder(player.inventory, containerTileEntity));
        }
        return null;
    }
}

