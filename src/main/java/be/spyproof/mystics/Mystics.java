package be.spyproof.mystics;

import be.spyproof.mystics.crafting.FluidCraftingRegistry;
import be.spyproof.mystics.handler.ConfigHandler;
import be.spyproof.mystics.handler.Recipes;
import be.spyproof.mystics.init.EntityRegister;
import be.spyproof.mystics.init.RegisterGodBlocks;
import be.spyproof.mystics.init.RegisterGodItems;
import be.spyproof.mystics.listeners.ArmorListener;
import be.spyproof.mystics.listeners.PotionListener;
import be.spyproof.mystics.potions.MysticPotions;
import be.spyproof.mystics.proxy.CommonProxy;
import be.spyproof.mystics.reference.Reference;
import be.spyproof.mystics.util.BlockHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by Spyproof.
 * A lot of code has been inspired by bloodmagic! @ https://github.com/WayofTime
 *
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
public class Mystics
{
    @Mod.Instance(Reference.MOD_ID)
    public static Mystics instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //Register the config change event
        FMLCommonHandler.instance().bus().register(new ConfigHandler(event.getSuggestedConfigurationFile()));

        //Register blocks
        new RegisterGodBlocks();

        //Register items
        new RegisterGodItems();

        //Register entities
        EntityRegister.mainRegistry();

        //Register listeners
        MinecraftForge.EVENT_BUS.register(new FluidCraftingRegistry());
        MinecraftForge.EVENT_BUS.register(new ArmorListener());
        MinecraftForge.EVENT_BUS.register(new PotionListener());

        //Register GUI handler
        //NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

        //Init potions
        MysticPotions.init();

        //Add recipies
        new Recipes();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        new BlockHelper();
        //proxy.registerRendering();

        //Load potions
        MysticPotions.load();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
    }
}
