package be.spyproof.mystics.handler;

import be.spyproof.mystics.init.RegisterGodItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Spyproof.
 */
public class Recipies
{
    public Recipies()
    {
        exampleRecipies();
    }

    private void exampleRecipies()
    {
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluidLightning), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystallisedLightning), 'x', new ItemStack(Items.potionitem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluidDragonFire), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystallisedDragonFire), 'x', new ItemStack(Items.potionitem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(RegisterGodItems.bottledFluidAcid), "sss", "sxs", "sss", 's', new ItemStack(RegisterGodItems.crystallisedAcid), 'x', new ItemStack(Items.potionitem, 1, 0));
    }
}
