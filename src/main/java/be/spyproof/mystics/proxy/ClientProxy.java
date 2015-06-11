package be.spyproof.mystics.proxy;

import be.spyproof.mystics.item.entity.ItemEntityThrowable;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderArrow;

/**
 * Created by Spyproof.
 */
public class ClientProxy extends CommonProxy
{
    @Override
    public void RegisterRendering()
    {
        RenderingRegistry.registerEntityRenderingHandler(ItemEntityThrowable.class, new RenderArrow());
    }
}
