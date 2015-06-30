package be.spyproof.mystics.item.armor;

import be.spyproof.mystics.item.bases.BoundArmor;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Spyproof.
 */
public class HadesArmor extends BoundArmor
{
    public HadesArmor(ItemArmor.ArmorMaterial material, int armorType)
    {
        super(material, armorType);
        switch (armorType)
        {
            case 0:
                this.setUnlocalizedName(Names.Items.HADES_HELMET);
                break;
            case 1:
                this.setUnlocalizedName(Names.Items.HADES_CHESTPLATE);
                break;
            case 2:
                this.setUnlocalizedName(Names.Items.HADES_LEGGINGS);
                break;
            case 3:
                this.setUnlocalizedName(Names.Items.HADES_BOOTS);
                break;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b)
    {
        super.addInformation(itemStack, player, list, b);
        addHiddenTooltip(list, "\u00A7fSet bonus:");
        addHiddenTooltip(list, Names.Colors.HADES + "Immunity to");
        addHiddenTooltip(list, Names.Colors.HADES + "lava and fire");
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.HADES + super.getItemStackDisplayName(itemStack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if (armorType == 2)
            return Textures.RESOURCE_PREFIX + "textures/armor/HadesArmor2.png";
        else
            return Textures.RESOURCE_PREFIX + "textures/armor/HadesArmor1.png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        super.onArmorTick(world, player, itemStack);
        int pieces = 0;

        for (int i = 0; i < 4; i++)
        {
            Item armor = null;
        try {
            armor = (player.getCurrentArmor(i).getItem());
            if (armor == null)
                return;
        } catch (NullPointerException e) {
            return;
        }

        if (armor instanceof HadesArmor)
            pieces++;
        }


        if (pieces == 4)
        {
            player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 4, 9, true));
            player.extinguish();
        }
    }


}
