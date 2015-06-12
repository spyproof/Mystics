package be.spyproof.mystics.client.gui;

import be.spyproof.mystics.inventory.ContainerFluidCrafting;
import be.spyproof.mystics.reference.Textures;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Spyproof.
 */
public class FluidCraftingGUI extends BaseGUI
{
    public FluidCraftingGUI(EntityPlayer player)
    {
        super(new ContainerFluidCrafting(player.inventory), Textures.GuiTexture.FLUID_CRAFTING);
    }


}
