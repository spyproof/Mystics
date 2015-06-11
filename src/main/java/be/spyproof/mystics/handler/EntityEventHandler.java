package be.spyproof.mystics.handler;

import be.spyproof.mystics.init.RegisterGodBlocks;
import be.spyproof.mystics.item.entity.LightningEntity;
import be.spyproof.mystics.util.BlockHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

/**
 * Created by Spyproof.
 */
public class EntityEventHandler
{
    @SubscribeEvent
    public void onLightningString(EntityJoinWorldEvent e)
    {
        if (e.isCanceled())
            return;

        if (!e.world.isRemote)
        {
            if (e.entity instanceof EntityLightningBolt && !(e.entity instanceof LightningEntity))
            {
                if (e.entity.worldObj.isAirBlock((int) e.entity.posX, (int) e.entity.posY, (int) e.entity.posZ) || BlockHelper.isMundane(e.entity.worldObj.getBlock((int) e.entity.posX, (int) e.entity.posY, (int) e.entity.posZ)))
                    e.entity.worldObj.setBlock((int) e.entity.posX, (int) e.entity.posY, (int) e.entity.posZ, RegisterGodBlocks.chargedBlock);

                else if (e.entity.worldObj.isAirBlock((int) e.entity.posX, (int) e.entity.posY + 1, (int) e.entity.posZ) || BlockHelper.isMundane(e.entity.worldObj.getBlock((int) e.entity.posX, (int) e.entity.posY + 1, (int) e.entity.posZ)))
                    e.entity.worldObj.setBlock((int) e.entity.posX, (int) e.entity.posY + 1, (int) e.entity.posZ, RegisterGodBlocks.chargedBlock);
            }
        }
    }
}
