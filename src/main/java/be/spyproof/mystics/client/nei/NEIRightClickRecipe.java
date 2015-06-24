package be.spyproof.mystics.client.nei;

import be.spyproof.mystics.api.LiquidBlockCraftingRecipe;
import be.spyproof.mystics.api.RightClickCraftingRegisty;
import be.spyproof.mystics.reference.Textures;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.item.ItemStack;

/**
 * Created by Spyproof.
 */
public class NEIRightClickRecipe extends TemplateRecipeHandler
{
    public class CachedRecipes extends CachedRecipe
    {
        PositionedStack output;
        PositionedStack input;

        public CachedRecipes(LiquidBlockCraftingRecipe recipe)
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
        return "Right click in the world";
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
        if (RightClickCraftingRegisty.isRequiredForCrafting(ingredient))
        {
            for (LiquidBlockCraftingRecipe recipe : RightClickCraftingRegisty.recipes)
            {
                if (recipe.usesItem(ingredient))
                    this.arecipes.add(new CachedRecipes(recipe));
            }
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result)
    {
        for (LiquidBlockCraftingRecipe recipe: RightClickCraftingRegisty.recipes)
        {
            if (recipe != null && recipe.getResult() != null)
            {
                if (recipe.hasResult(result))
                    arecipes.add(new CachedRecipes(recipe));
            }
        }
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if (outputId.equals(Textures.NeiOverlays.FLUID_CRAFTING) && getClass() == NEIRightClickRecipe.class)
        {
            for (LiquidBlockCraftingRecipe recipe: RightClickCraftingRegisty.recipes)
            {
                if (recipe != null && recipe.getResult() != null)
                {
                    arecipes.add(new CachedRecipes(recipe));
                }
            }
        }
        else
        {
            super.loadCraftingRecipes(outputId, results);
        }
    }
}
