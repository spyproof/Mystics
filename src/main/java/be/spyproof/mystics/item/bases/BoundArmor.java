package be.spyproof.mystics.item.bases;

import be.spyproof.mystics.reference.Textures;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;


/**
 * Created by Spyproof.
 */
public class BoundArmor extends ItemArmor
{

    public BoundArmor(ArmorMaterial armorMaterial, int type)
    {
        super(armorMaterial, 0, type);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack i)
    {
        return getUnlocalizedName();
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return super.getItemStackDisplayName(itemStack) + "\u00A7r";
    }

    protected String getUnwrappedUnlocalizedName(String name)
    {
        if (name.contains(":"))
            return name.substring(name.indexOf(":") + 1);
        return name.substring(name.indexOf(".") + 1);
    }
}
