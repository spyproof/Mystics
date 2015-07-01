package be.spyproof.mystics.potions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * Created by Spyproof.
 */
public interface IPotion
{
    PotionBase setIconIndex(int x, int y);

    PotionBase setPotionName(String name);

    int getId();

    void onApply(EntityLivingBase entityLiving, PotionEffect potionEffect);

    void onTick(EntityLivingBase entityLiving, PotionEffect potionEffect);

    void onRemove(EntityLivingBase entityLiving, PotionEffect potionEffect);
}
