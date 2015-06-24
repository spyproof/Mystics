package be.spyproof.mystics.handler;

import be.spyproof.mystics.api.FluidCraftingRegistry;
import be.spyproof.mystics.api.RightClickCraftingRegisty;
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
        vanillaCrafting();
        fluidCrafting();
        rightClickRecipies();
    }

    private void vanillaCrafting()
    {
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluid, 1 ,0), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystals, 1, 0), 'x', new ItemStack(Items.potionitem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluid, 1 ,1), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystals, 1, 1), 'x', new ItemStack(Items.potionitem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluid, 1 ,2), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystals, 1, 2), 'x', new ItemStack(Items.potionitem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluid, 1 ,3), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystals, 1, 3), 'x', new ItemStack(Items.potionitem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluid, 1, 4), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystals, 1, 4), 'x', new ItemStack(Items.potionitem, 1, 0));

        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.crystals, 1, 0), "ysy", "sxs", "ysy", 's', new ItemStack(Blocks.glowstone), 'x', new ItemStack(Items.gold_ingot), 'y', new ItemStack(Blocks.glass));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.crystals, 1, 1), "ysy", "sxs", "ysy", 's', new ItemStack(Blocks.obsidian), 'x', new ItemStack(Blocks.redstone_block), 'y', new ItemStack(Items.lava_bucket));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.crystals, 1, 2), "yzy", "sxs", "yzy", 's', new ItemStack(Blocks.deadbush), 'x', new ItemStack(Items.emerald), 'y', new ItemStack(Items.slime_ball), 'z', new ItemStack(Blocks.cactus));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.crystals, 1, 3), "ysy", "sxs", "ysy", 's', new ItemStack(Items.feather), 'x', new ItemStack(Blocks.quartz_block), 'y', new ItemStack(Items.ghast_tear));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.crystals, 1, 4), "ysy", "sxs", "ysy", 's', new ItemStack(Items.apple), 'x', new ItemStack(Items.diamond), 'y', new ItemStack(Items.water_bucket));
    }

    private void fluidCrafting()
    {
        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.hadesSword), new ItemStack(Items.diamond_sword), RegisterGodBlocks.fluidBlockFire);
        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.zeusSword), new ItemStack(Items.diamond_sword), RegisterGodBlocks.fluidBlockLightning);
        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.medusaSword), new ItemStack(Items.diamond_sword), RegisterGodBlocks.fluidBlockAcid);
        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.aetherSword), new ItemStack(Items.diamond_sword), RegisterGodBlocks.fluidBlockAir);
        FluidCraftingRegistry.registerFluidRecipe(new ItemStack(RegisterGodItems.neptuneSword), new ItemStack(Items.diamond_sword), RegisterGodBlocks.fluidBlockWater);
    }

    //Right clicking the bottles + NEI support
    private void rightClickRecipies()
    {
        RightClickCraftingRegisty.registerRecipe(new ItemStack(RegisterGodBlocks.fluidBlockLightning), new ItemStack(RegisterGodItems.bottledFluid, 1, 0));
        RightClickCraftingRegisty.registerRecipe(new ItemStack(RegisterGodBlocks.fluidBlockFire), new ItemStack(RegisterGodItems.bottledFluid, 1, 1));
        RightClickCraftingRegisty.registerRecipe(new ItemStack(RegisterGodBlocks.fluidBlockAcid), new ItemStack(RegisterGodItems.bottledFluid, 1, 2));
        RightClickCraftingRegisty.registerRecipe(new ItemStack(RegisterGodBlocks.fluidBlockAir), new ItemStack(RegisterGodItems.bottledFluid, 1, 3));
        RightClickCraftingRegisty.registerRecipe(new ItemStack(RegisterGodBlocks.fluidBlockWater), new ItemStack(RegisterGodItems.bottledFluid, 1, 4));
    }
}
