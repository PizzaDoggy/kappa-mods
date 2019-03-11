package ed.kappa.entity;

import ed.kappa.items.KappaItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityRockFactory implements IRenderFactory<EntityRock> {
    @Override
    public Render<? super EntityRock> createRenderFor(RenderManager manager) {
        return new RenderSnowball<EntityRock>(manager, KappaItems.rock, Minecraft.getMinecraft().getRenderItem());
    }
}
