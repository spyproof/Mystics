package be.spyproof.mystics.api;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Spyproof.
 */
public class LiquidBlockCraftingRegisty
{
    public static List<LiquidBlockCraftingRecipe> fluidRecipes = new LinkedList<LiquidBlockCraftingRecipe>();

    public static void registerFluidRecipe(ItemStack result, ItemStack requiredItem)
    {
        fluidRecipes.add(new LiquidBlockCraftingRecipe(result, requiredItem));
    }

    public static boolean isRequiredForCrafting(ItemStack testItem)
    {
    	if(testItem == null)
    		return false;


        for (LiquidBlockCraftingRecipe recipe : fluidRecipes)
            if (recipe.usesItem(testItem))
                return true;

        return false;
    }

    public static ItemStack getResult(ItemStack testItem)
    {
        for (LiquidBlockCraftingRecipe recipe : fluidRecipes)
        {
            if (recipe.usesItem(testItem))
            {
                return ItemStack.copyItemStack(recipe.getResult());
            }
        }

        return testItem;
    }
}
