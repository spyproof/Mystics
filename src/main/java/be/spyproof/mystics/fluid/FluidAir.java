package be.spyproof.mystics.fluid;

import be.spyproof.mystics.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;

import java.util.Random;

/**
 * Created by Spyproof.
 */
public class FluidAir extends BaseFluid
{
    public FluidAir(Fluid fluid)
    {
        super(fluid, Material.water);
        this.setBlockName(Names.Blocks.FLUID_AIR);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        Random rand = new Random();

        float x1 = ((float)rand.nextInt(5))/100;

        if (rand.nextInt(1) == 1) {
            entity.motionX = -(entity.motionX + x1) * 5;
        }else{
            entity.motionX = (entity.motionX + x1)*5;
        }

        float z1 = ((float)rand.nextInt(5))/100;
        if (rand.nextInt(1) == 1) {
            entity.motionZ = -(entity.motionZ + z1) * 5;
        }else{
            entity.motionZ = (entity.motionZ + z1)*5;
        }

        float y1 = ((float)rand.nextInt(5))/10;
        entity.motionY = (y1+1)*1.5;

        if (entity instanceof EntityLivingBase)
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(8, 80, 3));
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        super.updateTick(world, x, y, z, rand);
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
