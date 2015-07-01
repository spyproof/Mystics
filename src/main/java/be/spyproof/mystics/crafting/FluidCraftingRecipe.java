package be.spyproof.mystics.crafting;

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

    public Block getBlock()
    {
        return this.inputBlock;
    }

    public boolean usesBlock(ItemStack block)
    {
        return doItemsMatch(new ItemStack(this.inputBlock), block);
    }

    public boolean usesBlock(Block block)
    {
        return this.inputBlock == block;
    }

    public boolean matches(ItemStack comparedStack, Block block)
    {
        if (comparedStack == null || block == null)
            return false;

        if (doItemsMatch(comparedStack, this.getItem()) && block == inputBlock)
            return true;

        return false;
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
