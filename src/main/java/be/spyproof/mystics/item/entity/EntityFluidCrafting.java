package be.spyproof.mystics.item.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Spyproof.
 */
public class EntityFluidCrafting extends ItemEntityFireproof
{
    private ItemStack craftedItem;
    private Block craftingFluid;
    private boolean destroyBlock = true;

    public EntityFluidCrafting(World world)
    {
        super(world);
    }

    public EntityFluidCrafting(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }


    public EntityFluidCrafting(World world, double x, double y, double z, ItemStack itemStack)
    {
        super(world, x, y, z);
    }


    public EntityFluidCrafting(World world, double x, double y, double z, ItemStack original, ItemStack newItem, Block fluid)
    {
        super(world, x, y, z, original);
        this.craftedItem = newItem;
        this.craftingFluid = fluid;
        this.delayBeforeCanPickup = 20;
    }

    public EntityFluidCrafting(World world, double x, double y, double z, ItemStack original, ItemStack newItem, Block craftingFluid, boolean destroyBlock)
    {
        this(world, x, y, z, original, newItem, craftingFluid);
        this.destroyBlock = destroyBlock;
    }

    @Override
    public void onEntityUpdate()
    {
        super.onEntityUpdate();

        int x = (int)this.posX, y = (int)this.posY, z = (int)this.posZ;
        if (x < 0)
            x--;
        if (z < 0)
            z--;

        if (this.worldObj.getBlock(x, y, z).equals(this.craftingFluid))
        {
            this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, this.craftedItem));
            if (this.destroyBlock)
                this.worldObj.setBlock(x, y, z, Blocks.air);
            this.setDead();
        }
    }
}
