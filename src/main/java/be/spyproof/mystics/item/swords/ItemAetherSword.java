package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.reference.Names;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Spyproof.
 */
public class ItemAetherSword extends BoundSword
{
    public ItemAetherSword()
    {
        super();
        this.setUnlocalizedName(Names.Items.AETHER_SWORD);
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
        /*
        if (!player.isSneaking() && NBTHelper.getBoolean(itemStack, "isActive") && NBTHelper.isOwner(itemStack, player))
        {
            MovingObjectPosition mop = PlayerHelper.getLookPos(player);
            //TODO if you cant hurt players, home into enities

            setOnFire(world, mop, 1);
        }*/


        return itemStack;
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player)
    {
        if (super.hitEntity(itemStack, target, player))
            return true;

        target.motionY = target.motionY + 1;

        return true;
    }
}
