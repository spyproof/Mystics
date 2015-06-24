package be.spyproof.mystics.item.craftingcomponents;

import be.spyproof.mystics.api.RightClickCraftingRegisty;
import be.spyproof.mystics.item.bases.BaseDamagedItem;
import be.spyproof.mystics.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Spyproof.
 */
public class BottledFluid extends BaseDamagedItem
{
    public BottledFluid()
    {
        super(Names.Items.BOTTLED_FLUID, Names.Items.BOTTLED_FLUID_SUBTYPES);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.SUBTYPES[itemStack.getItemDamage()] + super.getItemStackDisplayName(itemStack);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int sideId, float hitX, float hitY, float hitZ)
    {
        ItemStack fluid = RightClickCraftingRegisty.getResult(itemStack);
        if (fluid == null)
            return false;

        Block clickedBlock = world.getBlock(x, y, z);

        if (!clickedBlock.isReplaceable(world, x, y, z))
        {
            ForgeDirection side = ForgeDirection.getOrientation(sideId);
            x += side.offsetX;
            y += side.offsetY;
            z += side.offsetZ;
        }

        if (fluid.getItem() instanceof ItemBlock)
        {
            if (world.getBlock(x, y, z).isReplaceable(world, x, y, z))
            {
                world.setBlock(x, y, z, Block.getBlockFromItem(fluid.getItem()));
                if (!player.capabilities.isCreativeMode)
                    itemStack.stackSize--;
                return true;
            }
        }


        return false;
    }
}
