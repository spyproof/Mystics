package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.NBTHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

/**
 * Created by Spyproof.
 */
public class ItemEchidnaGodSword extends BoundSword
{
    public ItemEchidnaGodSword()
    {
        super();
        this.setUnlocalizedName(Names.Items.ECHIDNA_SWORD);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return "\u00A72" + super.getItemStackDisplayName(itemStack) + "\u00A7r";
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker)
    {
        if (super.hitEntity(itemStack, target, attacker))
            return true;

        if (!NBTHelper.isOwner(itemStack, attacker))
            return true;

        target.addPotionEffect(new PotionEffect(17, 100, 4));
        target.addPotionEffect(new PotionEffect(19, 100, 4));

        return true;
    }
}
