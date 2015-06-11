package be.spyproof.mystics.handler;

import be.spyproof.mystics.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Spyproof.
 */
public class ConfigHandler
{
    public static Configuration config;
    public static boolean useRecepies = false;


    /**
     * enable/disable binding
     * enable/disable binding upon crafting
     * enable/disable every item
     * enable/disable every item ability
     * enable/disable targeting players
     * if enabled, only use ability when left clicking
     */

    public ConfigHandler(File fileName)
    {
        if (config == null)
        {
            config = new Configuration(fileName);
            loadConfig();
        }
    }

    @SubscribeEvent
    public void onConfigChangeEvent(ConfigChangedEvent.OnConfigChangedEvent e)
    {
        if (e.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfig();
        }
    }

    public void loadConfig()
    {
        useRecepies = config.get(Configuration.CATEGORY_GENERAL, "Use recipies", true, "Enable or disable crafting recipies").getBoolean();

        if (config.hasChanged())
            config.save();
    }

    private void loadGlobalSettings()
    {

    }

    private void loadSwordSettings()
    {

    }
}
