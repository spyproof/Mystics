package be.spyproof.mystics.listeners;

import be.spyproof.mystics.potions.MysticPotions;
import be.spyproof.mystics.potions.PotionBase;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent;


/**
 * Created by Spyproof.
 */
public class PotionListener
{
    @SubscribeEvent
    public void onEntityUpdate(LivingEvent.LivingUpdateEvent event)
    {
        for (PotionBase potion : MysticPotions.getAllPotions())
        {
            if (event.entityLiving.isPotionActive(potion.getId()))
            {
                potion.onTick(event.entityLiving, event.entityLiving.getActivePotionEffect(potion));
                if (event.entityLiving.getActivePotionEffect(potion) != null && event.entityLiving.getActivePotionEffect(potion).getDuration() == 1)
                    potion.onRemove(event.entityLiving, event.entityLiving.getActivePotionEffect(potion));
            }
        }
    }
}
