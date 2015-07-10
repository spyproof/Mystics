package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.potions.MysticPotions;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.NBTHelper;
import be.spyproof.mystics.util.PlayerHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.HashMap;

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
    public void addShiftTooltip(ItemStack itemStack, EntityPlayer player, HashMap map, boolean b)
    {
        super.addShiftTooltip(itemStack, player, map, b);
        map.put("\u00A7fLeft click ability:", 1);
        map.put(Names.Colors.MEDUSA + "Prevent target", 3);
        map.put(Names.Colors.MEDUSA + "from moving", 4);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.MEDUSA + super.getItemStackDisplayName(itemStack);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) throws NullPointerException
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
        if (super.hitEntity(itemStack, target, player))
            return true;

        if (itemStack.getItemDamage() == getMaxDamage())
            return true;

        if (NBTHelper.getBoolean(itemStack, "isActive"))
        {
            if (target.isPotionActive(MysticPotions.freezeResist) || target.isPotionActive(MysticPotions.freeze))
                return false;

            if (player instanceof EntityPlayer && !((EntityPlayer) player).capabilities.isCreativeMode)
                MysticPotions.freeze.onApply(target, new PotionEffect(MysticPotions.freeze.getId(), 100, 4));

            if (player instanceof EntityPlayer && !((EntityPlayer) player).capabilities.isCreativeMode)
                itemStack.setItemDamage(itemStack.getItemDamage()+1);
        }

        return true;
    }
}
