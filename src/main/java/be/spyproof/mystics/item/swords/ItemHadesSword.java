package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.entity.ItemEntityFireproof;
import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.NBTHelper;
import be.spyproof.mystics.util.PlayerHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.HashMap;

/**
 * Created by Spyproof.
 */
public class ItemHadesSword extends BoundSword
{
    public ItemHadesSword()
    {
        super();
        this.setUnlocalizedName(Names.Items.HADES_SWORD);
        this.setMaxDamage(10);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.HADES + super.getItemStackDisplayName(itemStack);
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
        if (super.hitEntity(itemStack, target, player))
            return true;

        if (itemStack.getItemDamage() == getMaxDamage())
            return true;

        if (player instanceof EntityPlayer && !((EntityPlayer) player).capabilities.isCreativeMode)
            itemStack.setItemDamage(itemStack.getItemDamage()+1);

        if (NBTHelper.getBoolean(itemStack, "isActive"))
            target.addPotionEffect(new PotionEffect(Potion.wither.getId(), 100, 2));

        return true;
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack)
    {
        return true;
    }

    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack)
    {
        ItemEntityFireproof entityFireproof = new ItemEntityFireproof(world, location.posX, location.posY, location.posZ, itemstack);
        entityFireproof.motionX = location.motionX;
        entityFireproof.motionY = location.motionY;
        entityFireproof.motionZ = location.motionZ;
        entityFireproof.delayBeforeCanPickup = 10;
        return entityFireproof;
    }

    @Override
    public void addShiftTooltip(ItemStack itemStack, EntityPlayer player, HashMap map, boolean b)
    {
        super.addShiftTooltip(itemStack, player, map, b);
        map.put("\u00A7fLeft click ability:", 1);
        map.put(Names.Colors.HADES + "Add withering", 3);
    }
}
