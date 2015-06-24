package be.spyproof.mystics.api;

import net.minecraft.item.ItemStack;

/**
 * Created by Spyproof.
 */
public class LiquidBlockCraftingRecipe
{
    private ItemStack inputItem;
    private ItemStack result;

    public LiquidBlockCraftingRecipe(ItemStack result, ItemStack input)
    {
        this.inputItem = input;
        this.result = result;
    }

    public ItemStack getResult()
    {
        return this.result;
    }

    public boolean hasResult(ItemStack itemStack)
    {
        return doItemsMatch(itemStack, this.result);
    }

    public ItemStack getItem()
    {
        return this.inputItem;
    }

    public boolean usesItem(ItemStack itemStack)
    {
        return doItemsMatch(itemStack, this.getItem());
    }

    private boolean doItemsMatch(ItemStack itemStack1, ItemStack itemStack2)
    {
        if (itemStack2.getItem().getHasSubtypes())
        {
            if (itemStack2.getItemDamage() != itemStack1.getItemDamage())
                return false;
        }

        if (itemStack2.getItem() == itemStack1.getItem())
            return true;

        return false;
    }
}
