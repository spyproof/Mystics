package be.spyproof.mystics.entity;

import be.spyproof.mystics.api.FluidCraftingRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Spyproof.
 */
public class EntityFluidCrafting extends EntityItem
{
    private boolean destroyBlock = true;

    public EntityFluidCrafting(World world, double x, double y, double z, ItemStack originalItem) //originalItem + fluid = new Itemstack
    {
        super(world, x, y, z, originalItem);
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

        if (FluidCraftingRegistry.isRequiredItemValid(this.getEntityItem(), this.worldObj.getBlock(x, y, z)))
        {
            this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, FluidCraftingRegistry.getResult(this.getEntityItem(), this.worldObj.getBlock(x, y, z))));
            if (this.destroyBlock)
                this.worldObj.setBlock(x, y, z, Blocks.air);
            this.setDead();
        }
    }
}
