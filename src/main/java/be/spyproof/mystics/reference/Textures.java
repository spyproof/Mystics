package be.spyproof.mystics.reference;

/**
 * Created by Spyproof.
 */
public class Textures
{
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

    public static class GuiTexture
    {
        private static String GUI_PREFIX = "textures/gui/";
        public static String FLUID_CRAFTING = RESOURCE_PREFIX + GUI_PREFIX + "fluid_crafting.png";
    }

    public static class NeiOverlays
    {
        public static final String FLUID_CRAFTING = RESOURCE_PREFIX + "FluidCrafting";
    }
}
