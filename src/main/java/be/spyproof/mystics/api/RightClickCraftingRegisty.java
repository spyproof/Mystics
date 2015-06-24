package be.spyproof.mystics.api;

import net.minecraft.item.ItemStack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Spyproof.
 */
public class RightClickCraftingRegisty
{
    public static List<LiquidBlockCraftingRecipe> recipes = new LinkedList<LiquidBlockCraftingRecipe>();

    public static void registerRecipe(ItemStack result, ItemStack requiredItem)
    {
        recipes.add(new LiquidBlockCraftingRecipe(result, requiredItem));
    }

    public static boolean isRequiredForCrafting(ItemStack testItem)
    {
    	if(testItem == null)
    		return false;


        for (LiquidBlockCraftingRecipe recipe : recipes)
            if (recipe.usesItem(testItem))
                return true;

        return false;
    }

    public static ItemStack getResult(ItemStack testItem)
    {
        for (LiquidBlockCraftingRecipe recipe : recipes)
        {
            if (recipe.usesItem(testItem))
            {
                return ItemStack.copyItemStack(recipe.getResult());
            }
        }

        return testItem;
    }
}
