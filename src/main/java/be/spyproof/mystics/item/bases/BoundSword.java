package be.spyproof.mystics.item.bases;

import be.spyproof.mystics.util.NBTHelper;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Spyproof.
 */
public class BoundSword extends BoundTool
{
    private float damage;
    //TODO Fix getting damage from mining blocks

    public BoundSword()
    {
        this.maxStackSize = 1;
        this.damage = 4.0F + super.getToolMaterial().getDamageVsEntity();
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b)
    {
        super.addInformation(itemStack, player, list, b);
    }

    protected void addTooltip(ItemStack itemStack, EntityPlayer player, HashMap map, boolean b)
    {
        super.addTooltip(itemStack, player, map, b);
        map.put("\u00A7fCharges: " + (itemStack.getMaxDamage() - itemStack.getItemDamage()) + "/" + itemStack.getMaxDamage(), 3);
    }

    public float getDamage()
    {
        return super.getToolMaterial().getDamageVsEntity();
    }

    public float func_150893_a(ItemStack itemStack, Block block)
    {
        if (block == Blocks.web)
        {
            return 15.0F;
        }
        else
        {
            Material material = block.getMaterial();
            return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd ? 1.0F : 1.5F;
        }
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player)
    {
        if (target instanceof EntityPlayer)
            if (((EntityPlayer) target).capabilities.isCreativeMode)
                return true;
        return false;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase p_150894_7_)
    {
        return false;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        if (NBTHelper.getBoolean(itemStack, "isActive"))
            return EnumAction.none;
        else
            return EnumAction.block;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) throws IllegalArgumentException
    {
        super.onItemRightClick(itemStack, world, player);
        player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public boolean func_150897_b(Block block)
    {
        return block == Blocks.web;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    @Override
    public int getItemEnchantability()
    {
        return super.getToolMaterial().getEnchantability();
    }

    /**
     * Return the name for this tool's material.
     */
    public String getToolMaterialName()
    {
        return super.getToolMaterial().toString();
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack itemStack, ItemStack repairStack)
    {
        ItemStack mat = super.getToolMaterial().getRepairItemStack();
        if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repairStack, false)) return true;
        return super.getIsRepairable(itemStack, repairStack);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack)
    {
        if (stack.getItemDamage() == 0)
            return false;
        return true;
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    @Override
    @SuppressWarnings("All")
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.damage, 0));
        return multimap;
    }
}
