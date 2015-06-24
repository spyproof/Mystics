package be.spyproof.mystics.init;

import be.spyproof.mystics.item.armor.ZeusArmor;
import be.spyproof.mystics.item.bases.BoundArmor;
import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.item.craftingcomponents.BottledFluid;
import be.spyproof.mystics.item.craftingcomponents.Crystals;
import be.spyproof.mystics.item.swords.*;
import be.spyproof.mystics.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemArmor;

/**
 * Created by Spyproof.
 */
public class RegisterGodItems
{
    public static final BoundSword zeusSword = new ItemZeusSword();
    public static final BoundSword hadesSword = new ItemHadesSword();
    public static final BoundSword medusaSword = new ItemMedusaSword();
    public static final BoundSword aetherSword = new ItemAetherSword();
    public static final BoundSword neptuneSword = new ItemNeptuneSword();
    public static final BoundSword testSword = new ItemTestSword();

    public static final ZeusArmor zeusHelmet = new ZeusArmor(ItemArmor.ArmorMaterial.DIAMOND, 0);
    public static final ZeusArmor zeusChestplate = new ZeusArmor(ItemArmor.ArmorMaterial.DIAMOND, 1);
    public static final ZeusArmor zeusLeggings = new ZeusArmor(ItemArmor.ArmorMaterial.DIAMOND, 2);
    public static final ZeusArmor zeusBoots = new ZeusArmor(ItemArmor.ArmorMaterial.DIAMOND, 3);

    public static final Crystals crystals = new Crystals();
    public static final BottledFluid bottledFluid = new BottledFluid();

    public RegisterGodItems()
    {
        registerSwords();
        registerArmor();

        GameRegistry.registerItem(crystals, Names.Items.CRYSTAL);
        GameRegistry.registerItem(bottledFluid, Names.Items.BOTTLED_FLUID);
    }

    private void registerSwords()
    {
        GameRegistry.registerItem(zeusSword, Names.Items.ZEUS_SWORD);
        GameRegistry.registerItem(hadesSword, Names.Items.HADES_SWORD);
        GameRegistry.registerItem(medusaSword, Names.Items.MEDUSA_SWORD);
        GameRegistry.registerItem(aetherSword, Names.Items.AETHER_SWORD);
        GameRegistry.registerItem(neptuneSword, Names.Items.NEPTUNE_SWORD);
        GameRegistry.registerItem(testSword, Names.Items.TEST_SWORD);
    }

    private void registerArmor()
    {
        GameRegistry.registerItem(zeusHelmet, Names.Items.ZEUS_HELMET);
        GameRegistry.registerItem(zeusChestplate, Names.Items.ZEUS_CHESTPLATE);
        GameRegistry.registerItem(zeusLeggings, Names.Items.ZEUS_LEGGINGS);
        GameRegistry.registerItem(zeusBoots, Names.Items.ZEUS_BOOTS);
    }
}
