package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.init.RegisterGodBlocks;
import be.spyproof.mystics.init.RegisterGodItems;
import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.item.entity.LightningEntity;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.NBTHelper;
import be.spyproof.mystics.util.PlayerHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Spyproof.
 */
public class ItemZeusGodSword extends BoundSword
{
    public ItemZeusGodSword()
    {
        super();
        this.setUnlocalizedName(Names.Items.ZEUS_SWORD);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return "\u00A7e" + super.getItemStackDisplayName(itemStack) + "\u00A7r";
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        try {
            super.onItemRightClick(itemStack, world, player);
        } catch (IllegalArgumentException e) {
            return itemStack;
        }

        if (!player.isSneaking() && NBTHelper.getBoolean(itemStack, "isActive") && NBTHelper.isOwner(itemStack, player))
        {
            MovingObjectPosition mop = PlayerHelper.getLookPos(player);
            //TODO if you cant hurt players, home into enities

            if (!world.isRemote)
            {
                world.addWeatherEffect(new LightningEntity(world, mop.blockX, mop.blockY + 1, mop.blockZ));
                if (world.getBlock(mop.blockX, mop.blockY, mop.blockZ).equals(RegisterGodBlocks.chargedBlock))
                {
                    world.setBlock(mop.blockX, mop.blockY, mop.blockZ, Blocks.air);
                    world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(RegisterGodItems.crystals, 2, 0)));
                }
            }
        }

        return itemStack;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        if (super.onLeftClickEntity(stack, player, entity))
            return true;

        if (new Random().nextInt(10) == 1)
            player.worldObj.playSoundEffect(entity.posX, entity.posY, entity.posZ, "ambient.weather.thunder", 10.0F, 0.8F + player.worldObj.rand.nextFloat() * 0.2F);
        return false;
    }
}
