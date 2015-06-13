package be.spyproof.mystics.init;

import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.item.craftingcomponents.BottledFluid;
import be.spyproof.mystics.item.craftingcomponents.Crystals;
import be.spyproof.mystics.item.swords.ItemEchidnaGodSword;
import be.spyproof.mystics.item.swords.ItemHadesGodSword;
import be.spyproof.mystics.item.swords.ItemTestGodSword;
import be.spyproof.mystics.item.swords.ItemZeusGodSword;
import be.spyproof.mystics.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Spyproof.
 */
public class RegisterGodItems
{
    public static final BoundSword zeusSword = new ItemZeusGodSword();
    public static final BoundSword hadesSword = new ItemHadesGodSword();
    public static final BoundSword echidnaSword = new ItemEchidnaGodSword();
    public static final BoundSword testSword = new ItemTestGodSword();

    public static final Crystals crystals = new Crystals();
    public static final BottledFluid bottledFluid = new BottledFluid();

    public RegisterGodItems()
    {
        GameRegistry.registerItem(zeusSword, Names.Items.ZEUS_SWORD);
        GameRegistry.registerItem(hadesSword, Names.Items.HADES_SWORD);
        GameRegistry.registerItem(echidnaSword, Names.Items.ECHIDNA_SWORD);
        GameRegistry.registerItem(testSword, Names.Items.TEST_SWORD);

        GameRegistry.registerItem(crystals, Names.Items.CRYSTAL);
        GameRegistry.registerItem(bottledFluid, Names.Items.BOTTLED_FLUID);
    }
}
