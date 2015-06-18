package be.spyproof.mystics.blocks;

import be.spyproof.mystics.creativeTab.CreativeTabGodSwords;
import be.spyproof.mystics.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by Spyproof.
 */
public class MythicOre extends Block
{
    ArrayList<ItemStack> drops;

    protected MythicOre(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabGodSwords.GS_Tab);
        this.blockHardness = 10.0F;
        this.setResistance(7.0F);
        this.setHarvestLevel("pickaxe", 3);
    }

    public MythicOre()
    {
        this(Material.rock);
    }

    public MythicOre(String name)
    {
        this();
        this.setBlockName(name);
    }

    public MythicOre(String name, Material material)
    {
        this(material);
        this.setBlockName(name);
    }

    public MythicOre(String name, ItemStack drops)
    {
        this(name);
        this.drops = new ArrayList<ItemStack>();
        this.drops.add(drops);
    }

    public MythicOre(String name, ArrayList<ItemStack> drops)
    {
        this(name);
        this.drops = drops;
    }

    public MythicOre(String name, ItemStack drops, Material material)
    {
        this(name, material);
        this.drops = new ArrayList<ItemStack>();
        this.drops.add(drops);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        //player.openGui(Mystics.instance, GuiHandler.GuiIDs.DROP_ON_FLUID.ordinal(), world, x, y, z);
        return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        return drops;
    }

    @Override
    public String getUnlocalizedName()
    {
        //tile.<modid>:<itemname>.name
        //tile.GodSwords.ZeusSword.name
        return String.format("tile.%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }




    protected String getUnwrappedUnlocalizedName(String name)
    {
        return name.substring(name.indexOf(".") + 1);
    }
}
