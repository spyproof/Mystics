package be.spyproof.mystics.item.bases;

import be.spyproof.mystics.util.NBTHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.HashMap;

/**
 * Created by Spyproof.
 */
public class BoundItem extends BaseItem
{
    public BoundItem()
    {
        super();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) throws IllegalArgumentException
    {
        if (isOwner(itemStack, player))
        {
            if (player.isSneaking())
            {
                if (NBTHelper.getBoolean(itemStack, "isActive"))
                    NBTHelper.setBoolean(itemStack, "isActive", false);
                else
                    NBTHelper.setBoolean(itemStack, "isActive", true);

            }
            return itemStack;
        }
        else
        {
            player.setItemInUse(itemStack, itemStack.getMaxItemUseDuration());
            throw new IllegalArgumentException("&cYou are not the owner of this sword!");
        }
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker)
    {
        return super.hitEntity(itemStack, target, attacker);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        return !isOwner(stack, player);
    }

    protected boolean isOwner(ItemStack itemStack, EntityLivingBase player)
    {
        String owner = NBTHelper.getOwnerUUID(itemStack);

        if (owner == null)
        {
            NBTHelper.setOwner(itemStack, player);
            return true;
        }

        if (NBTHelper.isOwner(itemStack, player))
        {
            if (!NBTHelper.getOwnerName(itemStack).equals(player.getCommandSenderName()))
                NBTHelper.setOwner(itemStack, player);
            return true;
        }else
            return false;
    }

    @Override
    protected void addTooltip(ItemStack itemStack, EntityPlayer player, HashMap map, boolean b)
    {
        super.addTooltip(itemStack, player, map, b);
        /*if (NBTHelper.getBoolean(itemStack, "isActive"))
            map.put("\u00A7aActivated", 1);
        else
            map.put("\u00A7cDeactivated", 1);*/

        map.put("\u00A7fOwner: " + NBTHelper.getOwnerName(itemStack), 2);
    }

    @Override
    protected void addShiftTooltip(ItemStack itemStack, EntityPlayer player, HashMap map, boolean b)
    {
        super.addShiftTooltip(itemStack, player, map, b);
        if (NBTHelper.getBoolean(itemStack, "isActive"))
            map.put("\u00A7aActivated", 1);
        else
            map.put("\u00A7cDeactivated", 1);
    }

    @Override
    protected void addControlTooltip(ItemStack itemStack, EntityPlayer player, HashMap map, boolean b)
    {
        super.addControlTooltip(itemStack, player, map, b);
        if (NBTHelper.getBoolean(itemStack, "isActive"))
            return;

        map.put("\u00A77Sneak + right click", 1);
        map.put("\u00A77To activate", 2);

    }
}
