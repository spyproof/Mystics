package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.potions.MysticPotions;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.NBTHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

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
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) throws NullPointerException
    {
        if (NBTHelper.getBoolean(itemStack, "isActive"))
            MysticPotions.freeze.onApply(player, new PotionEffect(MysticPotions.freeze.getId(), 100, 4));
        return super.onItemRightClick(itemStack, world, player);
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player)
    {
        if (super.hitEntity(itemStack, target, player))
            return true;

        if (NBTHelper.getBoolean(itemStack, "isActive"))
            MysticPotions.freeze.onApply(target, new PotionEffect(MysticPotions.freeze.getId(), 100, 4));

        return true;
    }
}
