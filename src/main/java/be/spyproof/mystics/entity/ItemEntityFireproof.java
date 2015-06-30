package be.spyproof.mystics.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * https://github.com/CovertJaguar/Railcraft/blob/master/src/main/java/mods/railcraft/common/items/EntityItemFireproof.java
 */
public class ItemEntityFireproof extends EntityItem
{
    public ItemEntityFireproof(World world, double x, double y, double z)
    {
        super(world, x, y, z);
        init();
    }

    public ItemEntityFireproof(World world, double x, double y, double z, ItemStack itemStack)
    {
        super(world, x, y, z, itemStack);
        init();
    }

    public ItemEntityFireproof(World world)
    {
        super(world);
        init();
    }

    public void init()
    {
        this.isImmuneToFire = true;
    }

    @Override
    protected void dealFireDamage(int p_70081_1_)
    {
        //Do nothing
    }

    @Override
    protected void setOnFireFromLava()
    {
        //Do nothing
    }

    @Override
    public void setFire(int p_70015_1_)
    {
        //Do nothing
    }

    @Override
    public void onEntityUpdate()
    {
        this.extinguish();
    }
}
