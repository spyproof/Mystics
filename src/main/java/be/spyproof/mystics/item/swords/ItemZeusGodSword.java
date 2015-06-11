package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.init.RegisterGodBlocks;
import be.spyproof.mystics.init.RegisterGodItems;
import be.spyproof.mystics.item.entity.LightningEntity;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.NBTHelper;
import be.spyproof.mystics.util.PlayerHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by Spyproof.
 */
public class ItemZeusGodSword extends ItemGodSword
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
        super.onItemRightClick(itemStack, world, player);

        if (canUse(itemStack, player, null))
            return itemStack;

        if (!player.isSneaking() && NBTHelper.getBoolean(itemStack, "isActive") && NBTHelper.isOwner(itemStack, player))
        {
            MovingObjectPosition mop = PlayerHelper.getLookPos(player);
            //TODO if you cant hurt players, home into enities

            //world.spawnEntityInWorld(new LightningEntity(world, mop.blockX, mop.blockY + 1, mop.blockZ));

            if (!world.isRemote)
            {
                world.addWeatherEffect(new LightningEntity(world, mop.blockX, mop.blockY + 1, mop.blockZ));
                if (world.getBlock(mop.blockX, mop.blockY, mop.blockZ).equals(RegisterGodBlocks.chargedBlock))
                {
                    world.setBlock(mop.blockX, mop.blockY, mop.blockZ, Blocks.air);
                    world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(RegisterGodItems.crystallisedLightning, 2)));
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

        player.worldObj.playSoundEffect(entity.posX, entity.posY, entity.posZ, "ambient.weather.thunder", 10.0F, 0.8F + player.worldObj.rand.nextFloat() * 0.2F);
        return false;
    }

    @Override
    public boolean canUse(ItemStack itemStack, EntityLivingBase sender, Entity target)
    {
        if (!super.canUse(itemStack, sender, target))
            return false;

        //Check config stuff
        return true;
    }
}
