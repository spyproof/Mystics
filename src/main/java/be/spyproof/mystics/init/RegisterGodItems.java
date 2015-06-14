package be.spyproof.mystics.init;

import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.item.craftingcomponents.BottledFluid;
import be.spyproof.mystics.item.craftingcomponents.Crystals;
import be.spyproof.mystics.item.swords.*;
import be.spyproof.mystics.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Spyproof.
 */
public class RegisterGodItems
{
    public static final BoundSword zeusSword = new ItemZeusSword();
    public static final BoundSword hadesSword = new ItemHadesSword();
    public static final BoundSword medusaSword = new ItemMedusaSword();
    public static final BoundSword aetherSword = new ItemAetherSword();
    public static final BoundSword testSword = new ItemTestSword();

    public static final Crystals crystals = new Crystals();
    public static final BottledFluid bottledFluid = new BottledFluid();

    public RegisterGodItems()
    {
        GameRegistry.registerItem(zeusSword, Names.Items.ZEUS_SWORD);
        GameRegistry.registerItem(hadesSword, Names.Items.HADES_SWORD);
        GameRegistry.registerItem(medusaSword, Names.Items.MEDUSA_SWORD);
        GameRegistry.registerItem(aetherSword, Names.Items.AETHER_SWORD);
        GameRegistry.registerItem(testSword, Names.Items.TEST_SWORD);

        GameRegistry.registerItem(crystals, Names.Items.CRYSTAL);
        GameRegistry.registerItem(bottledFluid, Names.Items.BOTTLED_FLUID);
    }
}
