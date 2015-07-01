package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.entity.ItemEntityFireproof;
import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.NBTHelper;
import be.spyproof.mystics.util.PlayerHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
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

        if (itemStack.getItemDamage() == getMaxDamage())
            return itemStack;

        itemStack.setItemDamage(itemStack.getItemDamage()+1);

        if (!player.isSneaking() && NBTHelper.getBoolean(itemStack, "isActive") && NBTHelper.isOwner(itemStack, player))
        {
            if (!player.capabilities.isCreativeMode)
                itemStack.setItemDamage(itemStack.getItemDamage()+1);
            MovingObjectPosition mop = PlayerHelper.getLookPos(player);
            //TODO if you cant hurt players, home into enities

            setOnFire(world, mop, 1);
        }


        return itemStack;
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
        map.put("\u00A7fRight click ability:", 1);
        map.put(Names.Colors.HADES + "Start a 3x3 fire", 3);
    }

    private void setOnFire(World world, MovingObjectPosition mop, int radius)
    {
        if (world.isRemote)
            return;
        for (int x = -radius; x <= radius; x++)
        {
            for (int y = -1; y <= 1; y++)
            {
                for (int z = -radius; z <= radius; z++)
                {
                    if (world.getBlock(mop.blockX + x, mop.blockY + y, mop.blockZ + z).equals(Blocks.air) && Blocks.fire.canPlaceBlockAt(world, mop.blockX + x, mop.blockY + y - 1, mop.blockZ + z))
                    {
                        world.setBlock(mop.blockX + x, mop.blockY + y, mop.blockZ + z, Blocks.fire);
                    }
                }
            }
        }
    }
}
