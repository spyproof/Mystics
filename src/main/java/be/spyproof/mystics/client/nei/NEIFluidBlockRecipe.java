package be.spyproof.mystics.client.nei;

import be.spyproof.mystics.api.FluidCraftingRecipe;
import be.spyproof.mystics.api.FluidCraftingRegistry;
import be.spyproof.mystics.api.LiquidBlockCraftingRecipe;
import be.spyproof.mystics.api.LiquidBlockCraftingRegisty;
import be.spyproof.mystics.reference.Textures;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spyproof.
 */
public class NEIFluidBlockRecipe extends TemplateRecipeHandler
{
    public class CachedFluidRecipe extends CachedRecipe
    {
        PositionedStack output;
        PositionedStack input;

        public CachedFluidRecipe(LiquidBlockCraftingRecipe recipe)
        {
            this.input = new PositionedStack(recipe.getItem(), 35, 25);
            this.output = new PositionedStack(recipe.getResult(), 112, 25);
        }

        @Override
        public PositionedStack getIngredient() {
            return input;
        }

        @Override
        public PositionedStack getResult() {
            return output;
        }
    }

    @Override
    public String getGuiTexture()
    {
        return Textures.GuiTexture.LIQUID_CRAFTING;
    }

    @Override
    public String getOverlayIdentifier()
    {
        return Textures.NeiOverlays.LIQUID_CRAFTING;
    }

    @Override
    public String getRecipeName()
    {
        return "Getting the Fluids";
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
        if (LiquidBlockCraftingRegisty.isRequiredForCrafting(ingredient))
        {
            for (LiquidBlockCraftingRecipe recipe : LiquidBlockCraftingRegisty.fluidRecipes)
            {
                if (recipe.usesItem(ingredient))
                    this.arecipes.add(new CachedFluidRecipe(recipe));
            }
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result)
    {
        for (LiquidBlockCraftingRecipe recipe: LiquidBlockCraftingRegisty.fluidRecipes)
        {
            if (recipe != null && recipe.getResult() != null)
            {
                if (recipe.hasResult(result))
                    arecipes.add(new CachedFluidRecipe(recipe));
            }
        }
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if (outputId.equals(Textures.NeiOverlays.FLUID_CRAFTING) && getClass() == NEIFluidBlockRecipe.class)
        {
            for (LiquidBlockCraftingRecipe recipe: LiquidBlockCraftingRegisty.fluidRecipes)
            {
                if (recipe != null && recipe.getResult() != null)
                {
                    arecipes.add(new CachedFluidRecipe(recipe));
                }
            }
        }
        else
        {
            super.loadCraftingRecipes(outputId, results);
        }
    }
}
