package be.spyproof.mystics.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Spyproof.
 */
public class LightningEntity extends EntityLightningBolt
{
    private int lightningState, boltLivingTime;
    private EntityLivingBase creator;

    public LightningEntity(World world, double x, double y, double z)
    {
        super(world, x, y, z);
        this.setLocationAndAngles(x, y, z, 0.0F, 0.0F);
        this.lightningState = 2;
        this.boltVertex = this.rand.nextLong();
        this.boltLivingTime = this.rand.nextInt(3) + 1;
    }

    public LightningEntity(World world, double x, double y, double z, EntityLivingBase creator)
    {
        this(world, x, y, z);
        this.creator = creator;
    }

    @Override
    public void onUpdate()
    {
        if (this.lightningState == 2)
        {
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0F, 0.8F + this.rand.nextFloat() * 0.2F);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 2.0F, 0.5F + this.rand.nextFloat() * 0.2F);
        }

        --this.lightningState;

        if (this.boltLivingTime == 0)
        {
            this.setDead();
        }
        else if (this.lightningState < -this.rand.nextInt(10))
        {
            --this.boltLivingTime;
            this.boltVertex = this.rand.nextLong();
        }

        if (this.lightningState >= 0)
        {
            if (this.worldObj.isRemote)
            {
                this.worldObj.lastLightningBolt = 2;
            }
            else
            {
                double d0 = 3.0D;
                List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, AxisAlignedBB.getBoundingBox(this.posX - d0, this.posY - d0, this.posZ - d0, this.posX + d0, this.posY + 6.0D + d0, this.posZ + d0));

                for (int l = 0; l < list.size(); ++l)
                {
                    Entity entity = (Entity)list.get(l);
                    if (this.creator != null && this.creator.getUniqueID()!= entity.getUniqueID())
                        if (!net.minecraftforge.event.ForgeEventFactory.onEntityStruckByLightning(entity, this))
                        {
                            entity.onStruckByLightning(this);
                            if (entity instanceof EntityLivingBase && this.lightningState == 0)
                                ((EntityLivingBase) entity).setHealth(((EntityLivingBase) entity).getHealth() - 4);
                        }
                }
            }
        }

    }
}
