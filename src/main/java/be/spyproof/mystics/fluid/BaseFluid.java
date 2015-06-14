package be.spyproof.mystics.fluid;

import be.spyproof.mystics.creativeTab.CreativeTabGodSwords;
import be.spyproof.mystics.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by Spyproof.
 */
public class BaseFluid extends BlockFluidFinite
{
    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;

    public BaseFluid(Fluid fluid, Material material)
    {
        super(fluid, material);
        this.setCreativeTab(CreativeTabGodSwords.GS_Tab);
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z)
    {
        if (world.getBlock(x,  y,  z).getMaterial().isLiquid())
            return false;

        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z)
    {
        if (world.getBlock(x, y, z).getMaterial().isLiquid())
            return false;

        return super.displaceIfPossible(world, x, y, z);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1)+"Still");

        this.stillIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1)+"Still");
        this.flowingIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1)+"Flowing");
    }

    protected String getUnwrappedUnlocalizedName(String name)
    {
        return name.substring(name.indexOf(".") + 1);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        super.onNeighborBlockChange(world, x, y, z, block);
    }

    @Override
    public boolean getWeakChanges(IBlockAccess world, int x, int y, int z)
    {
        return super.getWeakChanges(world, x, y, z);
    }
}
