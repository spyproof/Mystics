package be.spyproof.mystics.proxy;

import be.spyproof.mystics.init.RegisterGodItems;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.projectile.EntityThrowable;

/**
 * Created by Spyproof.
 */
public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRendering()
    {
        //RenderingRegistry.registerEntityRenderingHandler(EntityThrowable.class, new RenderSnowball(RegisterGodItems.bottledFluid));
    }
}
