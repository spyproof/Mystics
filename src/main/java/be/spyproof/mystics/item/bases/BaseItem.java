package be.spyproof.mystics.item.bases;

import be.spyproof.mystics.creativeTab.CreativeTabGodSwords;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by Spyproof.
 */
public class BaseItem extends Item
{
    public BaseItem()
    {
        super();
        this.setCreativeTab(CreativeTabGodSwords.GS_Tab);
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

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b)
    {
        super.addInformation(itemStack, player, list, b);

    }

    protected void addHiddenTooltip(List list, String tooltip)
    {
        String shiftMessage = "\u00A7fPress <Shift>";
        if (GuiScreen.isShiftKeyDown())
            list.add(tooltip);
        else if (!list.contains(shiftMessage))
            list.add(shiftMessage);
    }

    /**
     * Rendering
     */

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String name)
    {
        if (name.contains(":"))
            return name.substring(name.indexOf(":") + 1);
        return name.substring(name.indexOf(".") + 1);
    }
}
