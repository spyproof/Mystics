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
public class ItemZeusSword extends BoundSword
{
    public ItemZeusSword()
    {
        super();
        this.setUnlocalizedName(Names.Items.ZEUS_SWORD);
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
            return itemStack;
        }

        if (!player.isSneaking() && NBTHelper.getBoolean(itemStack, "isActive") && NBTHelper.isOwner(itemStack, player))
        {
            MovingObjectPosition mop = PlayerHelper.getLookPos(player);
            //TODO if you cant hurt players, home into enities

            if (!world.isRemote)
                world.addWeatherEffect(new LightningEntity(world, mop.blockX, mop.blockY + 1, mop.blockZ));
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
