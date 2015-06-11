package be.spyproof.mystics.item.craftingcomponents;

import be.spyproof.mystics.init.RegisterGodBlocks;
import be.spyproof.mystics.item.BaseItem;
import be.spyproof.mystics.item.entity.ItemEntityThrowable;
import be.spyproof.mystics.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Spyproof.
 */
public class BottledFluidDragonFire extends BaseItem
{
    public BottledFluidDragonFire()
    {
        super();
        this.setUnlocalizedName(Names.Items.BOTTLED_FLUID_DRAGON_FIRE);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return "\u00A74" + super.getItemStackDisplayName(itemStack) + "\u00A7r";
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean p_77624_4_)
    {
        list.add("\u00A7cIt is way to hot to");
        list.add("\u00A7ckeep holding this");
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        return super.getContainerItem(stack);
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote)
        {
            ItemEntityThrowable entityThrowable = new ItemEntityThrowable(world, player);
            entityThrowable.setItemStack(new ItemStack(itemStack.getItem(), 1, itemStack.getItemDamage()));
            entityThrowable.setBlock(RegisterGodBlocks.fluidBlockDragonFire);
            entityThrowable.motionX = player.getLookVec().xCoord;
            entityThrowable.motionY = player.getLookVec().yCoord;
            entityThrowable.motionZ = player.getLookVec().zCoord;
            world.spawnEntityInWorld(entityThrowable);
        }

        itemStack.stackSize--;
        return itemStack;
    }
}
