package be.spyproof.mystics.item.bases;

import be.spyproof.mystics.creativeTab.CreativeTabGodSwords;
import be.spyproof.mystics.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.*;

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

        HashMap<String, Integer> tooltip = new HashMap<String, Integer>();

        addTooltip(itemStack, player, tooltip, b);
        addToList(list, tooltip);

        tooltip.clear();
        addShiftTooltip(itemStack, player, tooltip, b);
        if (tooltip.size() != 0)
        {
            if (GuiScreen.isShiftKeyDown())
            {
                addToList(list, tooltip);
            }else{
                if (!GuiScreen.isCtrlKeyDown())
                    list.add("\u00A7fPress <\u00A77Shift\u00A7f>");
            }
        }

        tooltip.clear();
        addControlTooltip(itemStack, player, tooltip, b);
        if (tooltip.size() != 0)
        {
            if (GuiScreen.isCtrlKeyDown())
            {
                addToList(list, tooltip);
            }else{
                if (!GuiScreen.isShiftKeyDown())
                    list.add("\u00A7fPress <\u00A77Ctrl\u00A7f>");
            }
        }
    }

    protected void addToList(List list, Map<String, Integer> map)
    {
        List<Integer> priorities = new ArrayList<Integer>();

        for (int i : map.values())
            if (!priorities.contains(i))
                priorities.add(i);

        Collections.sort(priorities);

        for (int priority : priorities)
            for (String s : map.keySet())
                if (map.get(s) == priority)
                    list.add(s);
    }

    protected void addTooltip(ItemStack itemStack, EntityPlayer player, HashMap map, boolean b)
    {

    }

    protected void addShiftTooltip(ItemStack itemStack, EntityPlayer player, HashMap map, boolean b)
    {

    }

    protected void addControlTooltip(ItemStack itemStack, EntityPlayer player, HashMap map, boolean b)
    {

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
