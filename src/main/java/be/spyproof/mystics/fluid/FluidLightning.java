package be.spyproof.mystics.fluid;

import be.spyproof.mystics.item.entity.LightningEntity;
import be.spyproof.mystics.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;

import java.util.Random;

/**
 * Created by Spyproof.
 */
public class FluidLightning extends BaseFluid
{
    public FluidLightning(Fluid fluid)
    {
        super(fluid, Material.water);
        this.setBlockName(Names.Blocks.FLUID_LIGHTNING);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        super.onEntityCollidedWithBlock(world, x, y, z, entity);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        super.updateTick(world, x, y, z, rand);

        int range = 3;
        int x1 = x + rand.nextInt(range*2) - range;
        int y1 = y;
        int z1 = z + rand.nextInt(range*2) - range;

        while (!world.isAirBlock(x1, y1, z1) || y1 > 255)
            y1++;

        if (y1 <= 255)
            world.addWeatherEffect(new LightningEntity(world, x1, y1, z1));
            //world.spawnEntityInWorld(new LightningEntity(world, x1, y1, z1));
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
}
