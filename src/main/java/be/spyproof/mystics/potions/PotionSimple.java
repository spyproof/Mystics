package be.spyproof.mystics.potions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

/**
 * Created by Spyproof.
 */
public class PotionSimple extends PotionBase
{
    public PotionSimple(int id, boolean b, int i1)
    {
        super(id, b, i1);
    }


    @Override
    public void onApply(EntityLivingBase entityLiving, PotionEffect potionEffect)
    {

    }

    @Override
    public void onTick(EntityLivingBase entityLiving, PotionEffect potionEffect)
    {

    }

    @Override
    public void onRemove(EntityLivingBase entityLiving, PotionEffect potionEffect)
    {

    }
}
