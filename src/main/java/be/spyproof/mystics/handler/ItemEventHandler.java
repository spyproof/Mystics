package be.spyproof.mystics.handler;

import be.spyproof.mystics.item.swords.ItemGodSword;
import be.spyproof.mystics.util.NBTHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

/**
 * Created by Spyproof.
 */
public class ItemEventHandler
{
    @SubscribeEvent
    public void onCratingItem(PlayerEvent.ItemCraftedEvent e)
    {
        if (e.isCanceled())
            return;

        try {
            if (e.crafting.getItem() instanceof ItemGodSword)
                NBTHelper.setOwner(e.crafting, e.player);
        } catch(NullPointerException ignore) {}
    }
}