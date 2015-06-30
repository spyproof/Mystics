package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.NBTHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Spyproof.
 */
public class ItemAetherSword extends BoundSword
{
    public ItemAetherSword()
    {
        super();
        this.setUnlocalizedName(Names.Items.AETHER_SWORD);
        this.setMaxDamage(10);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b)
    {
        super.addInformation(itemStack, player, list, b);
        addHiddenTooltip(list, "\u00A7fLeft click ability:");
        addHiddenTooltip(list, Names.Colors.AETHER + "Send the target flying");
        //addHiddenTooltip(list, Names.Colors.AETHER + "and can fly");
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.AETHER + super.getItemStackDisplayName(itemStack);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        try {
            super.onItemRightClick(itemStack, world, player);
        } catch (IllegalArgumentException e) {
            return itemStack;
        }

        return itemStack;
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
            target.motionY = target.motionY + 1;

        return true;
    }
}
