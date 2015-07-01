package be.spyproof.mystics.proxy;

import be.spyproof.mystics.SpecialPlayerRender;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Spyproof.
 */
public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRendering()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new SpecialPlayerRender());
    }
    
    public World getPlayerWorld()
    {
        return Minecraft.getMinecraft().theWorld;
    }
}
