package be.spyproof.mystics.listeners;

import be.spyproof.mystics.potions.IPotion;
import be.spyproof.mystics.potions.MysticPotions;
import be.spyproof.mystics.potions.PotionBase;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent;


/**
 * Created by Spyproof.
 */
public class PotionListener
{
    @SubscribeEvent
    public void onEntityUpdate(LivingEvent.LivingUpdateEvent event)
    {
        for (Object potionEffect : event.entityLiving.getActivePotionEffects())
        {
            if (potionEffect instanceof PotionEffect)
            {
                Potion potion = getPotion(((PotionEffect) potionEffect).getPotionID());

                if (event.entityLiving.getActivePotionEffect(potion) != null && event.entityLiving.getActivePotionEffect(potion).getDuration() == 0)
                {
                    event.entityLiving.removePotionEffect(potion.getId());
                    return;
                }

                if (potion instanceof  IPotion)
                {
                    ((IPotion)potion).onTick(event.entityLiving, event.entityLiving.getActivePotionEffect(potion));
                    if (event.entityLiving.getActivePotionEffect(potion) != null && event.entityLiving.getActivePotionEffect(potion).getDuration() == 1)
                        ((IPotion)potion).onRemove(event.entityLiving, event.entityLiving.getActivePotionEffect(potion));
                }

            }
        }
    }

    private Potion getPotion(int id)
    {
        for (Potion potion : Potion.potionTypes)
        {
            if (potion != null && potion.getId() == id)
                return potion;
        }

        return null;
    }
}
