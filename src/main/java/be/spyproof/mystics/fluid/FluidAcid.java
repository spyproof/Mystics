package be.spyproof.mystics.fluid;

import be.spyproof.mystics.handler.GodlyDamageSource;
import be.spyproof.mystics.entity.EntityFluidCrafting;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;

import java.util.Random;

/**
 * Created by Spyproof.
 */
public class FluidAcid extends BaseFluid
{

    public FluidAcid(Fluid fluid)
    {
        super(fluid, Material.water);
        this.setBlockName(Names.Blocks.FLUID_ACID);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        super.onEntityCollidedWithBlock(world, x, y, z, entity);

        if (entity instanceof EntityLivingBase)
        {
            entity.attackEntityFrom(GodlyDamageSource.acid, 3);
        }else if (entity instanceof EntityItem) {
            if (!(entity instanceof EntityFluidCrafting))
                entity.setDead();
        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        super.updateTick(world, x, y, z, rand);

        int[] coords = getNextBlock(world, x, y, z);

        if (coords == null)
            return;

        world.setBlockToAir(coords[0], coords[1], coords[2]);

        if (coords[0] == x && coords[1] == y-1 && coords[2] == z)
            world.scheduleBlockUpdate(x, y, z, this, 1);
    }

    @Override
    public BlockFluidBase setTickRate(int tickRate)
    {
        return super.setTickRate(5);
    }

    @Override
    public Block setTickRandomly(boolean p_149675_1_)
    {
        return super.setTickRandomly(true);
    }

    @Override
    public int tickRate(World world)
    {
        return 5;
    }

    protected int[] getNextBlock(World world, int x, int y, int z){
        for (int z1 = -1; z1 <= 1; z1++)
        {
            for (int x1 = -1; x1 <= 1; x1++)
            {
                if (BlockHelper.acidCanBreak(world.getBlock(x+x1, y, z+z1)) && !world.isAirBlock(x+x1, y, z+z1))
                    return new int[]{x+x1, y, z+z1};
            }
        }

        if (BlockHelper.acidCanBreak(world.getBlock(x, y-1, z)))
            return new int[]{x, y-1, z};

        return null;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        //super.onNeighborBlockChange(world, x, y, z, block);
    }
}
