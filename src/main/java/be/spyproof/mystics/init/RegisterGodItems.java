package be.spyproof.mystics.init;

import be.spyproof.mystics.item.craftingcomponents.*;
import be.spyproof.mystics.item.swords.*;
import be.spyproof.mystics.item.swords.hilt.ItemEchidnaHilt;
import be.spyproof.mystics.item.swords.hilt.ItemHadesHilt;
import be.spyproof.mystics.item.swords.hilt.ItemZeusHilt;
import be.spyproof.mystics.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Spyproof.
 */
public class RegisterGodItems
{
    public static final ItemGodSword zeusSword = new ItemZeusGodSword();
    public static final ItemGodSword hadesSword = new ItemHadesGodSword();
    public static final ItemGodSword echidnaSword = new ItemEchidnaGodSword();
    public static final ItemGodSword testSword = new ItemTestGodSword();

    public static final ItemZeusHilt zeusHilt = new ItemZeusHilt();
    public static final ItemHadesHilt hadesHilt = new ItemHadesHilt();
    public static final ItemEchidnaHilt echidnaHilt = new ItemEchidnaHilt();

    public static final BottledFluidLightning bottledFluidLightning = new BottledFluidLightning();
    public static final BottledFluidDragonFire bottledFluidDragonFire = new BottledFluidDragonFire();
    public static final BottledFluidAcid bottledFluidAcid = new BottledFluidAcid();

    public static final CrystallisedLightning crystallisedLightning = new CrystallisedLightning();
    public static final CrystallisedDragonFire crystallisedDragonFire = new CrystallisedDragonFire();
    public static final CrystallisedAcid crystallisedAcid = new CrystallisedAcid();

    public RegisterGodItems()
    {
        GameRegistry.registerItem(zeusSword, Names.Items.ZEUS_SWORD);
        GameRegistry.registerItem(hadesSword, Names.Items.HADES_SWORD);
        GameRegistry.registerItem(echidnaSword, Names.Items.ECHIDNA_SWORD);
        GameRegistry.registerItem(testSword, Names.Items.TEST_SWORD);

        GameRegistry.registerItem(zeusHilt, Names.Items.ZEUS_HILT);
        GameRegistry.registerItem(hadesHilt, Names.Items.HADES_HILT);
        GameRegistry.registerItem(echidnaHilt, Names.Items.ECHIDNA_HILT);

        GameRegistry.registerItem(bottledFluidLightning, Names.Items.BOTTLED_FLUID_LIGHTNING);
        GameRegistry.registerItem(bottledFluidDragonFire, Names.Items.BOTTLED_FLUID_DRAGON_FIRE);
        GameRegistry.registerItem(bottledFluidAcid, Names.Items.BOTTLED_FLUID_ACID);

        GameRegistry.registerItem(crystallisedLightning, Names.Items.CRYSTAL_LIGHTNING);
        GameRegistry.registerItem(crystallisedDragonFire, Names.Items.CRYSTAL_DRAGON_FIRE);
        GameRegistry.registerItem(crystallisedAcid, Names.Items.CRYSTAL_ACID);
    }
}
