package be.spyproof.mystics.potions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

/**
 * Created by Spyproof.
 */
public class PotionFreeze extends PotionBase
{
    public PotionFreeze(int id, boolean isBadEffect, int i1)
    {
        super(id, isBadEffect, i1);
    }

    @Override
    public void onApply(EntityLivingBase entityLiving, PotionEffect potionEffect)
    {
        if (!entityLiving.isPotionActive(MysticPotions.freeze.getId()))
            entityLiving.addPotionEffect(potionEffect);
    }

    @Override
    public void onTick(EntityLivingBase entityLiving, PotionEffect potionEffect)
    {
        if (entityLiving.isPotionActive(MysticPotions.freezeResist))
        {
            entityLiving.removePotionEffect(MysticPotions.freeze.getId());
            return;
        }

        entityLiving.motionX = 0;
        entityLiving.motionY = 0;
        entityLiving.motionZ = 0;
    }

    @Override
    public void onRemove(EntityLivingBase entityLiving, PotionEffect potionEffect)
    {
        //entityLiving.addPotionEffect(new PotionEffect(MysticPotions.freezeResist.getId(), 20*20, 0));
    }
}
