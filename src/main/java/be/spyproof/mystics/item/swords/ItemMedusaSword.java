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

import java.util.List;

/**
 * Created by Spyproof.
 */
public class ItemMedusaSword extends BoundSword
{
    public ItemMedusaSword()
    {
        super();
        this.setUnlocalizedName(Names.Items.MEDUSA_SWORD);
        this.setMaxDamage(25);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b)
    {
        super.addInformation(itemStack, player, list, b);
        addHiddenTooltip(list, "\u00A7fLeft click ability:");
        addHiddenTooltip(list, Names.Colors.MEDUSA + "Prevent target");
        addHiddenTooltip(list, Names.Colors.MEDUSA + "from moving");
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.MEDUSA + super.getItemStackDisplayName(itemStack);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) throws NullPointerException
    {
        return super.onItemRightClick(itemStack, world, player);
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player)
    {
        if (super.hitEntity(itemStack, target, player))
            return true;

        if (itemStack.getItemDamage() == getMaxDamage())
            return true;

        itemStack.setItemDamage(itemStack.getItemDamage()+1);

        if (NBTHelper.getBoolean(itemStack, "isActive"))
            MysticPotions.freeze.onApply(target, new PotionEffect(MysticPotions.freeze.getId(), 100, 4));

        return true;
    }
}
