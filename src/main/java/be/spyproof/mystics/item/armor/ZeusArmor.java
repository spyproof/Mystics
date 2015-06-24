package be.spyproof.mystics.item.armor;

import be.spyproof.mystics.item.bases.BoundArmor;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.reference.Textures;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by Spyproof.
 */
public class ZeusArmor extends BoundArmor
{
    public ZeusArmor(ItemArmor.ArmorMaterial material, int armorType)
    {
        super(material, armorType);
        switch (armorType)
        {
            case 0:
                this.setUnlocalizedName(Names.Items.ZEUS_HELMET);
                break;
            case 1:
                this.setUnlocalizedName(Names.Items.ZEUS_CHESTPLATE);
                break;
            case 2:
                this.setUnlocalizedName(Names.Items.ZEUS_LEGGINGS);
                break;
            case 3:
                this.setUnlocalizedName(Names.Items.ZEUS_BOOTS);
                break;
        }
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.ZEUS + super.getItemStackDisplayName(itemStack);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if (armorType == 2)
            return Textures.RESOURCE_PREFIX + "textures/items/ZeusArmor2.png";
        else
            return Textures.RESOURCE_PREFIX + "textures/items/ZeusArmor1.png";
        //return Main.MODID + ":textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }
}
