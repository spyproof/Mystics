package be.spyproof.mystics.fluid;

import be.spyproof.mystics.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;

import java.util.Random;

/**
 * Created by Spyproof.
 */
public class FluidWater extends BaseFluid
{
    public FluidWater(Fluid fluid)
    {
        super(fluid, Material.water);
        this.setBlockName(Names.Blocks.FLUID_LIVING_WATER);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if (entity instanceof EntityLivingBase && !world.isRemote)
        {
            if (!((EntityLivingBase) entity).isPotionActive(Potion.regeneration))
                ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 50, 1));
            if (entity instanceof EntityPigZombie)
            {
                EntityPig entitypig = new EntityPig(entity.worldObj);
                entitypig.setLocationAndAngles(entity.posX, entity.posY+.5, entity.posZ, entity.rotationYaw, entity.rotationPitch);
                entity.worldObj.spawnEntityInWorld(entitypig);
                entity.setDead();
                world.setBlockToAir(x, y, z);
            }
        }


    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        super.updateTick(world, x, y, z, rand);
        if (rand.nextInt(3) != 1)
            return;
        int radius = 2;
        for (int i = -radius; i <= radius; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                for (int k = -radius; k <= radius; k++)
                {
                    if (world.getBlock(x + i, y + j, z + k).equals(Blocks.cobblestone))
                    {
                        world.setBlock(x + i, y + j, z + k, Blocks.mossy_cobblestone);
                        return;
                    }
                }
            }
        }
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
