package be.spyproof.mystics.potions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;

/**
 * Created by Spyproof.
 */
public class PotionFly extends PotionBase
{
    public PotionFly(int id, boolean b, int i1)
    {
        super(id, b, i1);
    }

    @Override
    public void onApply(EntityLivingBase entityLiving, PotionEffect potionEffect)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            entityLiving.addPotionEffect(potionEffect);
            ((EntityPlayer) entityLiving).capabilities.allowFlying = true;
        }
    }

    @Override
    public void onTick(EntityLivingBase entityLiving, PotionEffect potionEffect)
    {

    }

    @Override
    public void onRemove(EntityLivingBase entityLiving, PotionEffect potionEffect)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            ((EntityPlayer) entityLiving).capabilities.allowFlying = false;
        }
    }
}
