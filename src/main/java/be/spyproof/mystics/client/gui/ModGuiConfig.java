package be.spyproof.mystics.client.gui;

import be.spyproof.mystics.handler.ConfigHandler;
import be.spyproof.mystics.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by Spyproof.
 */
public class ModGuiConfig extends GuiConfig
{
    public ModGuiConfig(GuiScreen parentScreen)
    {
        super(parentScreen,
              new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
              Reference.MOD_ID,
              false,
              false,
              GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
    }
}
