package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.NBTHelper;
import be.spyproof.mystics.util.PlayerHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.HashMap;

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
    public void addShiftTooltip(ItemStack itemStack, EntityPlayer player, HashMap map, boolean b)
    {
        super.addShiftTooltip(itemStack, player, map, b);
        map.put("\u00A7fLeft click ability:", 1);
        map.put(Names.Colors.NEPTUNE + "Give yourself", 3);
        map.put(Names.Colors.NEPTUNE + "Regeneration", 4);
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
            if (!world.isRemote)
                PlayerHelper.messagePlayer(player, e.getMessage());
        }

        if (itemStack.getItemDamage() == getMaxDamage())
            return itemStack;

        if (!player.isSneaking() && NBTHelper.getBoolean(itemStack, "isActive") && NBTHelper.isOwner(itemStack, player))
        {
            if (player.isPotionActive(Potion.regeneration))
                return itemStack;

            player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 100, 2));

            if (!player.capabilities.isCreativeMode)
                itemStack.setItemDamage(itemStack.getItemDamage()+1);
        }


        return itemStack;
    }

}
