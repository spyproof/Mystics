package be.spyproof.mystics.item.craftingcomponents;

import be.spyproof.mystics.init.RegisterGodBlocks;
import be.spyproof.mystics.item.bases.BaseDamagedItem;
import be.spyproof.mystics.item.entity.ItemEntityThrowable;
import be.spyproof.mystics.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spyproof.
 */
public class BottledFluid extends BaseDamagedItem
{
    List<Block> blocks;
    public BottledFluid() //Plass blocks based on damage value
    {
        super(Names.Items.BOTTLED_FLUID, Names.Items.BOTTLED_FLUID_SUBTYPES);
        this.blocks = new ArrayList<Block>(){{
            add(RegisterGodBlocks.fluidBlockLightning);
            add(RegisterGodBlocks.fluidBlockDragonFire);
            add(RegisterGodBlocks.fluidBlockAcid);
            add(RegisterGodBlocks.fluidBlockLightning);
            add(RegisterGodBlocks.fluidBlockLightning);
        }};
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.SUBTYPES[itemStack.getItemDamage()] + super.getItemStackDisplayName(itemStack);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote)
        {
            ItemEntityThrowable entityThrowable = new ItemEntityThrowable(world, player);
            entityThrowable.setItemStack(new ItemStack(itemStack.getItem(), 1, itemStack.getItemDamage()));
            if (itemStack.getItemDamage() < this.blocks.size())
                entityThrowable.setBlock(this.blocks.get(itemStack.getItemDamage()));
            switch (itemStack.getItemDamage())
            {
                case 0:
                    entityThrowable.setBlock(RegisterGodBlocks.fluidBlockLightning);
                    break;
                case 1:
                    entityThrowable.setBlock(RegisterGodBlocks.fluidBlockDragonFire);
                    break;
                case 2:
                    entityThrowable.setBlock(RegisterGodBlocks.fluidBlockAcid);
                    break;
                case 3:
                    entityThrowable.setBlock(RegisterGodBlocks.fluidBlockLightning);
                    break;
                case 4:
                    entityThrowable.setBlock(RegisterGodBlocks.fluidBlockLightning);
                    break;
                default:
                    break;
            }
            entityThrowable.motionX = player.getLookVec().xCoord;
            entityThrowable.motionY = player.getLookVec().yCoord;
            entityThrowable.motionZ = player.getLookVec().zCoord;
            world.spawnEntityInWorld(entityThrowable);
        }

        itemStack.stackSize--;
        return itemStack;
    }
}
