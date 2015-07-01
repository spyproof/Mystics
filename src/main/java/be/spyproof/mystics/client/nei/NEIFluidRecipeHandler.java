package be.spyproof.mystics.client.nei;

import be.spyproof.mystics.crafting.FluidCraftingRecipe;
import be.spyproof.mystics.crafting.FluidCraftingRegistry;
import be.spyproof.mystics.reference.Textures;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spyproof.
 */
public class NEIFluidRecipeHandler extends TemplateRecipeHandler
{
    public class CachedFluidRecipe extends CachedRecipe
    {
        PositionedStack output;
        List<PositionedStack> inputs;

        public CachedFluidRecipe(FluidCraftingRecipe recipe)
        {
            List<PositionedStack> inputs = new ArrayList<PositionedStack>();
            inputs.add(new PositionedStack(recipe.getItem(), 67, 3));
            inputs.add(new PositionedStack(new ItemStack(recipe.getBlock()), 67, 44));
            this.inputs = inputs;
            this.output = new PositionedStack(recipe.getResult(), 123, 23);
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return inputs;
        }

        @Override
        public PositionedStack getResult() {
            return output;
        }
    }

    @Override
    public String getGuiTexture()
    {
        return Textures.GuiTexture.FLUID_CRAFTING;
    }

    @Override
    public String getOverlayIdentifier()
    {
        return Textures.NeiOverlayNames.FLUID_CRAFTING;
    }

    @Override
    public String getRecipeName()
    {
        return "Fluid Crafting";
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
        if (FluidCraftingRegistry.isRequiredForCrafting(ingredient))
        {
            for (FluidCraftingRecipe recipe : FluidCraftingRegistry.fluidRecipes)
            {
                if (recipe.usesItem(ingredient))
                    this.arecipes.add(new CachedFluidRecipe(recipe));
                else if (recipe.usesBlock(ingredient))
                    this.arecipes.add(new CachedFluidRecipe(recipe));
            }
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result)
    {
        for (FluidCraftingRecipe recipe: FluidCraftingRegistry.fluidRecipes)
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
        if (outputId.equals(Textures.NeiOverlayNames.FLUID_CRAFTING) && getClass() == NEIFluidRecipeHandler.class)
        {
            for (FluidCraftingRecipe recipe : FluidCraftingRegistry.fluidRecipes)
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
