package be.spyproof.mystics.blocks;

import be.spyproof.mystics.creativeTab.CreativeTabGodSwords;
import be.spyproof.mystics.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by Spyproof.
 */
public class GodOre extends Block
{
    protected GodOre(Material material)
    {
        super(material);
    }

    public GodOre()
    {
        this(Material.rock);
        this.setCreativeTab(CreativeTabGodSwords.GS_Tab);
        this.blockHardness = 10.0F;
        this.setResistance(7.0F);
        this.setHarvestLevel("pickaxe", 3);
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
