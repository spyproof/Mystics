package be.spyproof.mystics.crafting;

import be.spyproof.mystics.entity.EntityFluidCrafting;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Spyproof.
 */
public class FluidCraftingRegistry
{
    public static List<FluidCraftingRecipe> fluidRecipes = new LinkedList<FluidCraftingRecipe>();

    public static void registerFluidRecipe(ItemStack result, ItemStack requiredItem, Block block)
    {
        fluidRecipes.add(new FluidCraftingRecipe(result, requiredItem, block));
    }

    public static boolean isRequiredItemValid(ItemStack testItem, Block block)
    {
    	if(testItem == null || block == null)
    		return false;


        for (FluidCraftingRecipe recipe : fluidRecipes)
            if (recipe.matches(testItem, block))
                return true;

        return false;
    }

    public static boolean isRequiredForCrafting(ItemStack testItem)
    {
        if(testItem == null)
    		return false;

        for (FluidCraftingRecipe recipe : fluidRecipes)
        {
            if (recipe.usesItem(testItem))
                return true;
            else if (new ItemStack(recipe.getBlock()).getItem() == testItem.getItem())
                return true;
        }

        return false;
    }

    public static ItemStack getResult(ItemStack testItem, Block block)
    {
        for (FluidCraftingRecipe recipe : fluidRecipes)
        {
            if (recipe.matches(testItem, block))
            {
                return ItemStack.copyItemStack(recipe.getResult());
            }
        }

        return testItem;
    }

    @SubscribeEvent
    public void onItemDrop(ItemTossEvent event)
    {
        if (isRequiredForCrafting(event.entityItem.getEntityItem()))
        {
            event.setCanceled(true);
            EntityFluidCrafting entityFluidCrafting = new EntityFluidCrafting(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, event.entityItem.getEntityItem());
            entityFluidCrafting.motionX = event.entity.motionX;
            entityFluidCrafting.motionY = event.entity.motionY;
            entityFluidCrafting.motionZ = event.entity.motionZ;
            entityFluidCrafting.delayBeforeCanPickup = 20;
            event.entity.worldObj.spawnEntityInWorld(entityFluidCrafting);
        }
    }
}
