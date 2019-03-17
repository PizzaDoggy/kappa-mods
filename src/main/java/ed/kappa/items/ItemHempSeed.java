package ed.kappa.items;

import ed.kappa.Kappa;
import ed.kappa.blocks.KappaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHempSeed extends ItemSeeds {
    public ItemHempSeed() {
        super(KappaBlocks.hemp_crop, Blocks.FARMLAND);
        this.setRegistryName(new ResourceLocation(Kappa.MODID,"hemp_seeds"));
        this.setTranslationKey(Kappa.MODID + ".hemp_seeds");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}