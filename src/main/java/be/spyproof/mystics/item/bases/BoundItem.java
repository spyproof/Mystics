package be.spyproof.mystics.item.bases;

import be.spyproof.mystics.util.NBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

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
            if (player.isSneaking() && NBTHelper.isOwner(itemStack, player))
            {
                if (NBTHelper.getBoolean(itemStack, "isActive"))
                    NBTHelper.setBoolean(itemStack, "isActive", false);
                else
                    NBTHelper.setBoolean(itemStack, "isActive", true);

            }
            return itemStack;
        }
        else
            throw new IllegalArgumentException("Not the owner!");
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker)
    {
        return NBTHelper.getBoolean(itemStack, "isActive") || isOwner(itemStack, attacker);
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

        return NBTHelper.isOwner(itemStack, player);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b)
    {
        if (NBTHelper.getBoolean(itemStack, "isActive"))
          list.add("Activated");
        else
            list.add("Deactivated");

        list.add("Owner: " + NBTHelper.getOwnerName(itemStack));
    }
}
