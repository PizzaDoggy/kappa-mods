package ed.kappa.blocks;

import ed.kappa.Kappa;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGrinder extends Block {
    public BlockGrinder() {
        super(Material.ROCK);
        setRegistryName(new ResourceLocation(Kappa.MODID,"grinder"));
        setTranslationKey(Kappa.MODID + ".grinder");
        setHarvestLevel("pickaxe", 0);
        setHardness(1);
        setCreativeTab(Kappa.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
