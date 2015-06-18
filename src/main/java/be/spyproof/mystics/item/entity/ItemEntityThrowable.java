package be.spyproof.mystics.item.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by Spyproof.
 */
public class ItemEntityThrowable extends EntityThrowable
{
    private ItemStack itemStack;
    private Block block;


    public ItemEntityThrowable(World world)
    {
        super(world);
    }

    public ItemEntityThrowable(World world, EntityLivingBase livingBase)
    {
        super(world, livingBase);
    }

    public ItemEntityThrowable(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    public void setItemStack(ItemStack itemStack)
    {
        this.itemStack = itemStack;
    }

    public void setBlock(Block block)
    {
        this.block = block;
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition mop)
    {
        if (!this.worldObj.isRemote)
        {
            try {
                //Try to place block
                boolean blockPlaced = false;

                if (this.block != null)
                {
                    if (this.worldObj.isAirBlock(mop.blockX, mop.blockY, mop.blockZ))
                    {
                        this.worldObj.setBlock(mop.blockX, mop.blockY, mop.blockZ, this.block);
                        blockPlaced = true;
                    }
                    else if (this.worldObj.isAirBlock(mop.blockX, mop.blockY + 1, mop.blockZ))
                    {
                        this.worldObj.setBlock(mop.blockX, mop.blockY + 1, mop.blockZ, this.block);
                        blockPlaced = true;
                    }
                }

                if (!blockPlaced)
                    this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, mop.blockX, mop.blockY+1, mop.blockZ, this.itemStack));

            } catch (Exception e) {
                this.setDead();
            }
        }

        this.setDead();
    }

    public ItemStack getItemStack()
    {
        return this.itemStack;
    }
}
