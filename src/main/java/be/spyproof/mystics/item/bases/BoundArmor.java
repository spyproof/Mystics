package be.spyproof.mystics.item.bases;

import be.spyproof.mystics.reference.Textures;
import be.spyproof.mystics.util.NBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;


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

    @Override
    public boolean isDamageable()
    {
        return false;
    }

    @Override
    public void setDamage(ItemStack stack, int damage)
    {
        //super.setDamage(stack, damage);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean showDurabilityBar(ItemStack stack)
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (!isOwner(itemStack, player))
        {
            for (int i = 0; i < player.inventory.getSizeInventory(); i++)
                if (player.inventory.getStackInSlot(i) != null && player.inventory.getStackInSlot(i).equals(itemStack))
                {
                    player.inventory.setInventorySlotContents(i, null);
                    player.inventory.addItemStackToInventory(itemStack);
                    return;
                }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b)
    {
        list.add("\u00A7fOwner: " + NBTHelper.getOwnerName(itemStack));
    }

    protected void addHiddenTooltip(List list, String tooltip)
    {
        String shiftMessage = "\u00A7fPress <Shift>";
        if (GuiScreen.isShiftKeyDown())
            list.add(tooltip);
        else if (!list.contains(shiftMessage))
            list.add(shiftMessage);
    }

    protected boolean isOwner(ItemStack itemStack, EntityLivingBase player)
    {
        String owner = NBTHelper.getOwnerUUID(itemStack);

        if (owner == null)
        {
            NBTHelper.setOwner(itemStack, player);
            return true;
        }

        return NBTHelper.isOwner(itemStack, player);
    }
}
