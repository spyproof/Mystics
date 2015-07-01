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
    public static int[] potionIDs = new int[3];

    /**
     * enable/disable binding
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
        potionIDs[0] = config.get("Potions", "Freeze ID", 32).getInt();
        potionIDs[1] = config.get("Potions", "FreezeResist ID", 33).getInt();
        potionIDs[2] = config.get("Potions", "Fly ID", 34).getInt();

        if (config.hasChanged())
            config.save();
    }
}
