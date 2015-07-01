package be.spyproof.mystics.reference;

/**
 * Created by Spyproof.
 */
public class Textures
{
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

    public static final class GuiTexture
    {
        private static String GUI_PREFIX = "textures/gui/";
        public static String FLUID_CRAFTING = RESOURCE_PREFIX + GUI_PREFIX + "fluid_crafting.png";
        public static String LIQUID_CRAFTING = RESOURCE_PREFIX + GUI_PREFIX + "liquid_crafting.png";
    }

    public static final class NeiOverlayNames
    {
        public static final String FLUID_CRAFTING = RESOURCE_PREFIX + "FluidCrafting";
        public static final String LIQUID_CRAFTING = RESOURCE_PREFIX + "LiquidCrafting";
    }

    public static final class Entities
    {
        private static final String PREFIX = RESOURCE_PREFIX + "textures/entity/";
        public static final String STONE = PREFIX + "stoned.png";
        public static final String FORCED_PLAYER_TEXTURE = PREFIX + "steve.png";
    }
}
