package be.spyproof.mystics.api;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * Created by Spyproof.
 */
public class FluidCraftingRecipe
{
    private ItemStack inputItem;
    private Block inputBlock;
    private ItemStack result;

    public FluidCraftingRecipe(ItemStack result, ItemStack input1, Block input2)
    {
        this.inputItem = input1;
        this.inputBlock = input2;
        this.result = result;
    }

    public ItemStack getResult()
    {
        return this.result;
    }

    public ItemStack getItem()
    {
        return this.inputItem;
    }

    public boolean doItemsMatch(ItemStack itemStack)
    {
        /*if (this.getItem().getItem() == itemStack.getItem() && this.getItem().getItemDamage() == itemStack.getItemDamage())
            return true;*/
        if (this.getItem().getItem().getHasSubtypes())
        {
            if (this.getItem().getItemDamage() != itemStack.getItemDamage())
                return false;
        }

        if (this.getItem().getItem() == itemStack.getItem())
            return true;

        return false;
    }

    public Block getBlock()
    {
        return this.inputBlock;
    }

    public boolean matches(ItemStack comparedStack, Block block)
    {
        if (comparedStack == null || block == null)
            return false;

        if (doItemsMatch(comparedStack) && block == inputBlock)
            return true;

        return false;
    }
}
