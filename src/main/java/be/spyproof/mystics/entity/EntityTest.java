package be.spyproof.mystics.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.world.World;

/**
 * Created by Spyproof.
 */
public class EntityTest extends EntityTameable
{

    public EntityTest(World world)
    {
        super(world);
        this.setSize(1, 2);
        this.tasks.addTask(0, new EntityAIWander(this, 0.3));
        this.tasks.addTask(1, new EntityAIPanic(this, 0.5));
        this.tasks.addTask(2, new EntityAISit(this));
        this.tasks.addTask(3, new EntityAIEatGrass(this));
    }



    @Override
    protected boolean isAIEnabled()
    {
        return true;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_)
    {
        return new EntityTest(worldObj);
    }
}
