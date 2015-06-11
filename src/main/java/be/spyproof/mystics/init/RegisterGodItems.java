package be.spyproof.mystics.init;

import be.spyproof.mystics.item.bases.BaseDamagedItem;
import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.item.craftingcomponents.BottledFluidAcid;
import be.spyproof.mystics.item.craftingcomponents.BottledFluidDragonFire;
import be.spyproof.mystics.item.craftingcomponents.BottledFluidLightning;
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

    public static final BaseDamagedItem crystals = new BaseDamagedItem("Crystal", Names.Items.ORE_SUBTYPES);
    public static final BaseDamagedItem hilts = new BaseDamagedItem("Hilt", Names.Items.HILT_SUBTYPES);

    public static final BottledFluidLightning bottledFluidLightning = new BottledFluidLightning();
    public static final BottledFluidDragonFire bottledFluidDragonFire = new BottledFluidDragonFire();
    public static final BottledFluidAcid bottledFluidAcid = new BottledFluidAcid();

    public RegisterGodItems()
    {
        GameRegistry.registerItem(zeusSword, Names.Items.ZEUS_SWORD);
        GameRegistry.registerItem(hadesSword, Names.Items.HADES_SWORD);
        GameRegistry.registerItem(echidnaSword, Names.Items.ECHIDNA_SWORD);
        GameRegistry.registerItem(testSword, Names.Items.TEST_SWORD);

        GameRegistry.registerItem(bottledFluidLightning, Names.Items.BOTTLED_FLUID_LIGHTNING);
        GameRegistry.registerItem(bottledFluidDragonFire, Names.Items.BOTTLED_FLUID_DRAGON_FIRE);
        GameRegistry.registerItem(bottledFluidAcid, Names.Items.BOTTLED_FLUID_ACID);

        GameRegistry.registerItem(crystals, Names.Items.CRYSTAL);
        GameRegistry.registerItem(hilts, Names.Items.HILT);
    }
}
