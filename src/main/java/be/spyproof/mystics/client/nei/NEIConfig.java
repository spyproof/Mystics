package be.spyproof.mystics.client.nei;

import be.spyproof.mystics.reference.Reference;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

/**
 * Created by Spyproof.
 */
public class NEIConfig implements IConfigureNEI
{

    @Override
    public void loadConfig()
    {
        API.registerRecipeHandler(new NEIFluidRecipeHandler());
        API.registerUsageHandler(new NEIFluidRecipeHandler());
        API.registerRecipeHandler(new NEIRightClickRecipe());
        API.registerUsageHandler(new NEIRightClickRecipe());
    }

    @Override
    public String getName()
    {
        return Reference.MOD_NAME + " NEI";
    }

    @Override
    public String getVersion()
    {
        return Reference.VERSION;
    }
}
