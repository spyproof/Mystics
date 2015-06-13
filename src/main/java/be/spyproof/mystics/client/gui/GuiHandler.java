package be.spyproof.mystics.client.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Spyproof.
 */
public class GuiHandler implements IGuiHandler
{
    public enum GuiIDs{
        DROP_ON_FLUID
    }

    /**
     * Returns a Server side Container to be displayed to the user.
     *
     * @param ID The Gui ID Number
     * @param player The player viewing the Gui
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) throws IllegalArgumentException
    {
        switch(GuiIDs.values()[ID]){
            case DROP_ON_FLUID:
                return null;
        }

        throw new IllegalArgumentException("Did not find the GUI with id " + ID);
    }

    /**
     * Returns a Container to be displayed to the user. On the client side, this
     * needs to return a instance of GuiScreen On the server side, this needs to
     * return a instance of Container
     *
     * @param ID The Gui ID Number
     * @param player The player viewing the Gui
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) throws IllegalArgumentException
    {
        switch(GuiIDs.values()[ID]){
            case DROP_ON_FLUID:
                return new FluidCraftingGUI(player);
        }

        throw new IllegalArgumentException("Did not find the GUI with id " + ID);
    }
}
