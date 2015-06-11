package be.spyproof.mystics.item.bases;

import be.spyproof.mystics.util.NBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by Spyproof.
 */
public class BoundTool extends BoundItem
{
    @SideOnly(Side.CLIENT)
    private IIcon iconsDeactivated, iconsActivated;
    private final ToolMaterial godMaterial = EnumHelper.addToolMaterial("GodSword", 3, 100, 14.0F, 6.0F, 25);

    public BoundTool()
    {
        this.maxStackSize = 1;
        this.setMaxDamage(godMaterial.getMaxUses());
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase p_150894_7_)
    {
        return false;
    }

    /**
     * Rendering
     */

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
        iconsDeactivated = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "Deactivated");
        iconsActivated = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "Activated");
        this.itemIcon = iconsActivated;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack itemStack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
        if (NBTHelper.getBoolean(itemStack, "isActive"))
            return this.iconsActivated;
        else
            return this.iconsDeactivated;
    }

    public ToolMaterial getToolMaterial()
    {
        return godMaterial;
    }
}
