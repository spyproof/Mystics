package be.spyproof.mystics.item.bases;

import be.spyproof.mystics.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import java.util.List;

/**
 * Created by Spyproof.
 */
public class BaseDamagedItem extends BaseItem
{
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    private String[] subtypes;

    public BaseDamagedItem(String name, String[] subtypes)
    {
        super();
        this.setUnlocalizedName(name);
        this.hasSubtypes = true;
        this.setMaxStackSize(64);
        this.subtypes = subtypes;
    }

    public BaseDamagedItem(String[] subtypes)
    {
        super();
        this.subtypes = subtypes;
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()), this.subtypes[itemStack.getItemDamage()]);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTab, List list)
    {
        for (int meta = 0; meta < this.subtypes.length; ++meta)
        {
            list.add(new ItemStack(this, 1, meta));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        return icons[MathHelper.clamp_int(meta, 0, this.subtypes.length - 1)];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[this.subtypes.length];

        for (int i = 0; i < this.subtypes.length; i++)
        {
            icons[i] = iconRegister.registerIcon(Textures.RESOURCE_PREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName()) + this.subtypes[i]);
        }
    }
}
