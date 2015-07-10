package be.spyproof.mystics.crafting;

import be.spyproof.mystics.reference.Reference;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import net.minecraftforge.oredict.RecipeSorter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spyproof.
 */
public class ShapelessRepairRecipe extends ShapelessRecipes
{
    static {
        RecipeSorter.register(Reference.MOD_ID + ":" + "repairrecipe", ShapelessRepairRecipe.class, RecipeSorter.Category.SHAPELESS, "");
    }

    public ShapelessRepairRecipe(ItemStack output, List input)
    {
        super(output, input);
    }

    public ShapelessRepairRecipe(ItemStack output, final ItemStack input, final ItemStack consumable)
    {
        super(output, new ArrayList<ItemStack>()
        {{
                add(input);
                add(consumable);
            }});
    }

    public ItemStack getRecipeOutput()
    {
        return super.getRecipeOutput();
    }

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world)
    {
        int foundItems = 0;
        for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++)
        {
            boolean matches = false;

            if (inventoryCrafting.getStackInSlot(i) != null)
            {
                for (int j = 0; j < this.recipeItems.size(); j++)
                    if (doItemsMatch(inventoryCrafting.getStackInSlot(i), (ItemStack) this.recipeItems.get(j)))
                    {
                        matches = true;
                        foundItems++;
                    }
            }else
                matches = true;


            if (!matches)
                return false;
        }

        if (foundItems == this.recipeItems.size())
            return true;
        else
            return false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting)
    {
        //TODO indicate in NEI that it repairs
        ItemStack repairedItem = null;
        for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++)
        {
            boolean matches = false;

            if (inventoryCrafting.getStackInSlot(i) != null)
                if (doItemsMatch(inventoryCrafting.getStackInSlot(i), this.getRecipeOutput()))
                        matches = true;


            if (matches)
                repairedItem = inventoryCrafting.getStackInSlot(i);

        }

        if (repairedItem != null)
            repairedItem.setItemDamage(0);
        if (matches(inventoryCrafting, null))
            return repairedItem;
        else
            return null;
    }
    
    public int getRecipeSize()
    {
        return this.recipeItems.size();
    }
    
    private static boolean doItemsMatch(ItemStack stack1, ItemStack stack2)
    {
        if (stack1.getItem() != stack2.getItem())
            return false;

        /*if (stack1.getHasSubtypes())
        {
            if (stack1.getItemDamage() == stack2.getItemDamage())
                return true;
        }else{
            return true;
        }*/
        if (stack1.getItemDamage() == stack2.getItemDamage())
                return true;

        return false;
    }
}
