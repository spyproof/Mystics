package be.spyproof.mystics.handler;

import be.spyproof.mystics.api.FluidCraftingRegistry;
import be.spyproof.mystics.init.RegisterGodBlocks;
import be.spyproof.mystics.init.RegisterGodItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
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
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluid, 1 ,0), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystals, 1, 0), 'x', new ItemStack(Items.potionitem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluid, 1 ,1), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystals, 1, 1), 'x', new ItemStack(Items.potionitem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluid, 1 ,2), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystals, 1, 2), 'x', new ItemStack(Items.potionitem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluid, 1 ,3), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystals, 1, 3), 'x', new ItemStack(Items.potionitem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluid, 1, 4), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystals, 1, 4), 'x', new ItemStack(Items.potionitem, 1, 0));

        GameRegistry.addSmelting(RegisterGodBlocks.LIGHTNING_BLOCK, new ItemStack(RegisterGodItems.crystals, 1, 0), 0.1f);
        GameRegistry.addSmelting(RegisterGodBlocks.FIRE_BLOCK, new ItemStack(RegisterGodItems.crystals, 1, 1), 0.1f);
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.crystals, 1, 2), "yzy", "sxs", "yzy", 's', new ItemStack(Blocks.deadbush), 'x', new ItemStack(Items.quartz), 'y', new ItemStack(Items.slime_ball), 'z', new ItemStack(Blocks.cactus));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.crystals, 1, 3), "ysy", "sxs", "ysy", 's', new ItemStack(Items.feather), 'x', new ItemStack(Items.quartz), 'y', new ItemStack(Items.ghast_tear));
        GameRegistry.addSmelting(RegisterGodBlocks.WATER_BLOCK, new ItemStack(RegisterGodItems.crystals, 1, 4), 0.1f);

        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.hadesSword), new ItemStack(Items.diamond_sword), RegisterGodBlocks.fluidBlockFire);
        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.zeusSword), new ItemStack(Items.diamond_sword), RegisterGodBlocks.fluidBlockLightning);
        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.medusaSword), new ItemStack(Items.diamond_sword), RegisterGodBlocks.fluidBlockAcid);
        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.aetherSword), new ItemStack(Items.diamond_sword), RegisterGodBlocks.fluidBlockAir);
        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.neptuneSword), new ItemStack(Items.diamond_sword), RegisterGodBlocks.fluidBlockWater);
    }
}
