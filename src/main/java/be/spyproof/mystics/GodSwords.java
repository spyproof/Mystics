package be.spyproof.mystics;

import be.spyproof.mystics.handler.ConfigHandler;
import be.spyproof.mystics.handler.EntityEventHandler;
import be.spyproof.mystics.handler.ItemEventHandler;
import be.spyproof.mystics.handler.Recipies;
import be.spyproof.mystics.init.RegisterGodBlocks;
import be.spyproof.mystics.init.RegisterGodEntities;
import be.spyproof.mystics.init.RegisterGodItems;
import be.spyproof.mystics.proxy.IProxy;
import be.spyproof.mystics.reference.Reference;
import be.spyproof.mystics.util.BlockHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by Spyproof.
 * Want to learn about modding? Here is where I learned the stuff for this mod
 *  - https://www.youtube.com/playlist?list=PLQPiZYWovwmnZlgvbHCbz6TefIgeEiVcj < beginners
 *  - https://www.youtube.com/playlist?list=PL5oCR-MRH-12rXI0USklAz6rQagXr4nl5 < advanced (Follow up to the first playlist)
 *  - Open source projects on github
 *    - https://github.com/CovertJaguar
 *    - https://github.com/Chicken-Bones/
 *    - https://github.com/pahimar
 *    - https://github.com/Vazkii
 *    - https://github.com/WayofTime
 *    - https://github.com/agaricusb/ForgeMod/wiki/List-of-Open-Source-Forge-Mods
 */
@Mod(useMetadata = true, modid = Reference.MOD_ID, canBeDeactivated = true, guiFactory = Reference.GUI_FACTORY_CLASS)
public class GodSwords
{
    @Mod.Instance(Reference.MOD_ID)
    public static GodSwords instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //Register the config change event
        FMLCommonHandler.instance().bus().register(new ConfigHandler(event.getSuggestedConfigurationFile()));

        //Register items
        new RegisterGodItems();

        //Register blocks
        new RegisterGodBlocks();

        //Register entities
        new RegisterGodEntities();

        //Register listeners
        ItemEventHandler itemEventHandler = new ItemEventHandler();
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());
        MinecraftForge.EVENT_BUS.register(itemEventHandler);
        FMLCommonHandler.instance().bus().register(itemEventHandler);


        //Add recipies
        new Recipies();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        new BlockHelper();
        proxy.RegisterRendering();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}