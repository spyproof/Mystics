package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Spyproof.
 */
public class ItemNeptuneSword extends BoundSword
{
    public ItemNeptuneSword()
    {
        super();
        this.setUnlocalizedName(Names.Items.NEPTUNE_SWORD);
        this.setMaxDamage(20);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b)
    {
        super.addInformation(itemStack, player, list, b);
        addHiddenTooltip(list, "\u00A7fRight click ability:");
        addHiddenTooltip(list, Names.Colors.NEPTUNE + "Give yourself");
        addHiddenTooltip(list, Names.Colors.NEPTUNE + "Regeneration");
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.NEPTUNE + super.getItemStackDisplayName(itemStack);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        try {
            super.onItemRightClick(itemStack, world, player);
        } catch (IllegalArgumentException e) {
            return itemStack;
        }

        if (itemStack.getItemDamage() == getMaxDamage())
            return itemStack;

        if (!player.isSneaking() && NBTHelper.getBoolean(itemStack, "isActive") && NBTHelper.isOwner(itemStack, player))
        {
            if (player.isPotionActive(Potion.regeneration))
                return itemStack;

            player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 100, 2));
            itemStack.setItemDamage(itemStack.getItemDamage()+1);
        }


        return itemStack;
    }

}
