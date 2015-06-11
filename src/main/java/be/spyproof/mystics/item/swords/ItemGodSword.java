package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.creativeTab.CreativeTabGodSwords;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.reference.Reference;
import be.spyproof.mystics.util.NBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import java.util.List;

/**
 * Created by Spyproof.
 */
public class ItemGodSword extends ItemSword
{
    @SideOnly(Side.CLIENT)
    private IIcon iconsDeactivated, iconsActivated;
    protected long lastRightClick = 0l;
    protected static ToolMaterial godMaterial = EnumHelper.addToolMaterial("GodSword", 3, 1561, 14.0F, 6.0F, 25);

    public ItemGodSword()
    {
        super(godMaterial);
        this.setCreativeTab(CreativeTabGodSwords.GS_Tab);
        this.maxStackSize = 1;
    }

    //TODO on death, either consume the sword or keep on death

    /**
     * Names 'n stuff
     */

    @Override
    public String getUnlocalizedName()
    {
        //item.<modid>:<itemname>.name
        //item.GodSwords.ZeusSword.name
        return String.format("item.%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack i)
    {
        return getUnlocalizedName();
    }

    /**
     * Rendering
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        iconsDeactivated = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + Names.Items.SWORD_SUBTYPES[0]);
        iconsActivated = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + Names.Items.SWORD_SUBTYPES[1]);
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

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b)
    {
        if (NBTHelper.getBoolean(itemStack, "isActive"))
          list.add(Names.Items.SWORD_SUBTYPES[1]);
        else
            list.add(Names.Items.SWORD_SUBTYPES[0]);

        list.add("Owner: " + NBTHelper.getOwnerName(itemStack));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean showDurabilityBar(ItemStack stack)
    {
        return false;
    }

    /**
     * Stuff
     */

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase p_150894_7_)
    {
        return false;
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker)
    {
        return NBTHelper.getBoolean(itemStack, "isActive") || NBTHelper.isOwner(itemStack, attacker);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        if (canUse(stack, player, entity))
            return false;
        return !NBTHelper.getBoolean(stack, "isActive");
    }

    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        if (NBTHelper.getBoolean(itemStack, "isActive"))
            return EnumAction.none;
        else
            return EnumAction.block;
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        //Activate blocking (or not)
        if (!player.isSneaking())
            player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));

        //First time binding
        String owner = NBTHelper.getOwnerUUID(itemStack);

        if (owner == null)
            NBTHelper.setOwner(itemStack, player);

        //Activate/deactivate the sword
        if (player.isSneaking() && NBTHelper.isOwner(itemStack, player))
        {
            if (NBTHelper.getBoolean(itemStack, "isActive"))
                NBTHelper.setBoolean(itemStack, "isActive", false);
            else
                NBTHelper.setBoolean(itemStack, "isActive", true);

        }
        return itemStack;
    }

    //Use target in upper classes
    public boolean canUse(ItemStack itemStack, EntityLivingBase livingBase, Entity target)
    {
        if (this.lastRightClick + 1000 < System.currentTimeMillis())
            return false;
        return NBTHelper.isOwner(itemStack, livingBase);
    }

    protected void setLastRightClick()
    {
        this.lastRightClick = System.currentTimeMillis();
    }

    protected String getUnwrappedUnlocalizedName(String name)
    {
        return name.substring(name.indexOf(".") + 1);
    }
}
