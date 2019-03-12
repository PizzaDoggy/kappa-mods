package ed.kappa.blocks.grinder;

import ed.kappa.Kappa;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiGrinder extends GuiContainer {
    public static final int WIDTH = 176;
    public static final int HEIGHT = 149;

    private static final ResourceLocation background = new ResourceLocation(Kappa.MODID, "textures/gui/grinder.png");
    private TileGrinder grinder;


    public GuiGrinder(TileGrinder tileEntity, ContainerGrinder container) {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;
        grinder = tileEntity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        if (grinder.getProgress() > 0) {
            int perc = (grinder.getProgress() * 12 / grinder.MAX_PROGRESS) - 2;
            drawTexturedModalRect(guiLeft + 81, guiTop + 28 + perc, xSize, perc, 13, 13 - perc);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }
}
