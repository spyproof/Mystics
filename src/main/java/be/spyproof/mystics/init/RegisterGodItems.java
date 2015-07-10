package be.spyproof.mystics.init;

import be.spyproof.mystics.item.armor.*;
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

    public static final AetherArmor aetherHelmet = new AetherArmor(ItemArmor.ArmorMaterial.DIAMOND, 0);
    public static final AetherArmor aetherChestplate = new AetherArmor(ItemArmor.ArmorMaterial.DIAMOND, 1);
    public static final AetherArmor aetherLeggings = new AetherArmor(ItemArmor.ArmorMaterial.DIAMOND, 2);
    public static final AetherArmor aetherBoots = new AetherArmor(ItemArmor.ArmorMaterial.DIAMOND, 3);

    public static final HadesArmor hadesHelmet = new HadesArmor(ItemArmor.ArmorMaterial.DIAMOND, 0);
    public static final HadesArmor hadesChestplate = new HadesArmor(ItemArmor.ArmorMaterial.DIAMOND, 1);
    public static final HadesArmor hadesLeggings = new HadesArmor(ItemArmor.ArmorMaterial.DIAMOND, 2);
    public static final HadesArmor hadesBoots = new HadesArmor(ItemArmor.ArmorMaterial.DIAMOND, 3);

    public static final MedusaArmor medusaHelmet = new MedusaArmor(ItemArmor.ArmorMaterial.DIAMOND, 0);
    public static final MedusaArmor medusaChestplate = new MedusaArmor(ItemArmor.ArmorMaterial.DIAMOND, 1);
    public static final MedusaArmor medusaLeggings = new MedusaArmor(ItemArmor.ArmorMaterial.DIAMOND, 2);
    public static final MedusaArmor medusaBoots = new MedusaArmor(ItemArmor.ArmorMaterial.DIAMOND, 3);

    public static final NeptuneArmor neptuneHelmet = new NeptuneArmor(ItemArmor.ArmorMaterial.DIAMOND, 0);
    public static final NeptuneArmor neptuneChestplate = new NeptuneArmor(ItemArmor.ArmorMaterial.DIAMOND, 1);
    public static final NeptuneArmor neptuneLeggings = new NeptuneArmor(ItemArmor.ArmorMaterial.DIAMOND, 2);
    public static final NeptuneArmor neptuneBoots = new NeptuneArmor(ItemArmor.ArmorMaterial.DIAMOND, 3);

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
    }

    private void registerArmor()
    {
        GameRegistry.registerItem(aetherHelmet, Names.Items.AETHER_HELMET);
        GameRegistry.registerItem(aetherChestplate, Names.Items.AETHER_CHESTPLATE);
        GameRegistry.registerItem(aetherLeggings, Names.Items.AETHER_LEGGINGS);
        GameRegistry.registerItem(aetherBoots, Names.Items.AETHER_BOOTS);

        GameRegistry.registerItem(hadesHelmet, Names.Items.HADES_HELMET);
        GameRegistry.registerItem(hadesChestplate, Names.Items.HADES_CHESTPLATE);
        GameRegistry.registerItem(hadesLeggings, Names.Items.HADES_LEGGINGS);
        GameRegistry.registerItem(hadesBoots, Names.Items.HADES_BOOTS);

        GameRegistry.registerItem(medusaHelmet, Names.Items.MEDUSA_HELMET);
        GameRegistry.registerItem(medusaChestplate, Names.Items.MEDUSA_CHESTPLATE);
        GameRegistry.registerItem(medusaLeggings, Names.Items.MEDUSA_LEGGINGS);
        GameRegistry.registerItem(medusaBoots, Names.Items.MEDUSA_BOOTS);

        GameRegistry.registerItem(neptuneHelmet, Names.Items.NEPTUNE_HELMET);
        GameRegistry.registerItem(neptuneChestplate, Names.Items.NEPTUNE_CHESTPLATE);
        GameRegistry.registerItem(neptuneLeggings, Names.Items.NEPTUNE_LEGGINGS);
        GameRegistry.registerItem(neptuneBoots, Names.Items.NEPTUNE_BOOTS);

        GameRegistry.registerItem(zeusHelmet, Names.Items.ZEUS_HELMET);
        GameRegistry.registerItem(zeusChestplate, Names.Items.ZEUS_CHESTPLATE);
        GameRegistry.registerItem(zeusLeggings, Names.Items.ZEUS_LEGGINGS);
        GameRegistry.registerItem(zeusBoots, Names.Items.ZEUS_BOOTS);
    }
}
