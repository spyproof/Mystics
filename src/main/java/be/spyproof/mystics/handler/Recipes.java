package be.spyproof.mystics.handler;

import be.spyproof.mystics.api.FluidCraftingRegistry;
import be.spyproof.mystics.init.RegisterGodBlocks;
import be.spyproof.mystics.init.RegisterGodItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Spyproof.
 */
public class Recipes
{
    public Recipes()
    {
        exampleRecipes();
    }

    private void exampleRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluidLightning), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystals, 1, 0), 'x', new ItemStack(Items.potionitem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluidDragonFire), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystals, 1, 1), 'x', new ItemStack(Items.potionitem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluidAcid), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystals, 1, 2), 'x', new ItemStack(Items.potionitem, 1, 0));

        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.hadesSword), new ItemStack(Items.diamond_sword), RegisterGodBlocks.fluidBlockDragonFire);
        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.zeusSword), new ItemStack(Items.diamond_sword), RegisterGodBlocks.fluidBlockLightning);
        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.echidnaSword), new ItemStack(Items.diamond_sword), RegisterGodBlocks.fluidBlockAcid);
        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.echidnaSword), new ItemStack(RegisterGodItems.hilts, 1, 0), RegisterGodBlocks.fluidBlockAcid);
    }
}
