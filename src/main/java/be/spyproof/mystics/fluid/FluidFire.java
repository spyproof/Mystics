package be.spyproof.mystics.fluid;

import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.PlayerHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

import java.util.List;
import java.util.Random;

/**
 * Created by Spyproof.
 */
public class FluidFire extends BaseFluid
{

    public FluidFire(Fluid fluid)
    {
        super(fluid, Material.lava);
        this.setBlockName(Names.Blocks.FLUID_DRAGON_FIRE);
    }

    /**
     * A randomly called display update to be able to add particles or other items for display
     */

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        double d5;
        double d6;
        double d7;

        if (world.getBlock(x, y + 1, z).getMaterial() == Material.air && !world.getBlock(x, y + 1, z).isOpaqueCube())
        {
            if (random.nextInt(100) == 0)
            {
                d5 = (double)((float)x + random.nextFloat());
                d6 = (double)y + this.maxY;
                d7 = (double)((float)z + random.nextFloat());
                world.spawnParticle("lava", d5, d6, d7, 0.0D, 0.0D, 0.0D);
                world.playSound(d5, d6, d7, "liquid.lavapop", 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }

            if (random.nextInt(200) == 0)
            {
                world.playSound((double)x, (double)y, (double)z, "liquid.lava", 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }
        }

        if (random.nextInt(10) == 0 && World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !world.getBlock(x, y - 2, z).getMaterial().blocksMovement())
        {
            d5 = (double)((float)x + random.nextFloat());
            d6 = (double)y - 1.05D;
            d7 = (double)((float)z + random.nextFloat());

            world.spawnParticle("dripLava", d5, d6, d7, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        super.updateTick(world, x, y, z, rand);

        int range = 3;
        List<EntityLivingBase> entities = PlayerHelper.getLivingEntitiesInRange(world, x, y, z, range, range / 2);
        for (int i = 0; i < entities.size(); i++)
            entities.get(i).setFire(10);
    }
}
