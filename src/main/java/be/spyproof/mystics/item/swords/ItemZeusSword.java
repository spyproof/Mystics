package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.entity.LightningEntity;
import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.NBTHelper;
import be.spyproof.mystics.util.PlayerHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.HashMap;

/**
 * Created by Spyproof.
 */
public class ItemZeusSword extends BoundSword
{
    public ItemZeusSword()
    {
        super();
        this.setUnlocalizedName(Names.Items.ZEUS_SWORD);
        this.setMaxDamage(15);
    }

    @Override
    public void addShiftTooltip(ItemStack itemStack, EntityPlayer player, HashMap map, boolean b)
    {
        super.addShiftTooltip(itemStack, player, map, b);
        map.put("\u00A7fLeft click ability:", 1);
        map.put(Names.Colors.ZEUS + "Summon lightning", 3);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.ZEUS + super.getItemStackDisplayName(itemStack);
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

        return itemStack;
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player)
    {
        if (super.hitEntity(itemStack, player, target))
            return true;

        if (!player.isSneaking() && NBTHelper.getBoolean(itemStack, "isActive") && NBTHelper.isOwner(itemStack, player))
        {
            if (itemStack.getItemDamage() == getMaxDamage())
                return false;

            if (player instanceof EntityPlayer && !((EntityPlayer) player).capabilities.isCreativeMode)
                itemStack.setItemDamage(itemStack.getItemDamage()+1);

            if (!player.worldObj.isRemote)
                player.worldObj.addWeatherEffect(new LightningEntity(player.worldObj, target.posX, target.posY, target.posZ, player));
        }

        return false;
    }
}
