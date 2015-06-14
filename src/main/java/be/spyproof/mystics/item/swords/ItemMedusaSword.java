package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.reference.Names;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

/**
 * Created by Spyproof.
 */
public class ItemMedusaSword extends BoundSword
{
    public ItemMedusaSword()
    {
        super();
        this.setUnlocalizedName(Names.Items.MEDUSA_SWORD);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.MEDUSA + super.getItemStackDisplayName(itemStack);
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player)
    {
        if (super.hitEntity(itemStack, target, player))
            return true;

        target.addPotionEffect(new PotionEffect(17, 100, 4));
        target.addPotionEffect(new PotionEffect(19, 100, 4));

        return true;
    }
}
