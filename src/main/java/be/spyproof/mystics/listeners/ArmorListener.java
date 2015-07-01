package be.spyproof.mystics.listeners;

import be.spyproof.mystics.handler.MysticDamageSource;
import be.spyproof.mystics.item.armor.AetherArmor;
import be.spyproof.mystics.item.armor.HadesArmor;
import be.spyproof.mystics.item.armor.MedusaArmor;
import be.spyproof.mystics.item.armor.ZeusArmor;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

/**
 * Created by Spyproof.
 */
public class ArmorListener
{
    @SubscribeEvent
    public void onPlayerHit(LivingHurtEvent event)
    {
        if (event.entity instanceof EntityPlayer)
        {
            String foundSet = null;
            int pieces = 0;

            for (int i = 0; i < 4; i++)
            {
                Item armor = null;
                try {
                    armor = ((EntityPlayer) event.entity).getCurrentArmor(i).getItem();
                    if (armor == null)
                        return;
                } catch (NullPointerException e) {
                    return;
                }
                if (armor instanceof AetherArmor && (foundSet == null || foundSet.equals("aether")))
                {
                    foundSet = "aether";
                    pieces++;
                }
                if (armor instanceof HadesArmor && (foundSet == null || foundSet.equals("hades")))
                {
                    foundSet = "hades";
                    pieces++;
                }
                if (armor instanceof MedusaArmor && (foundSet == null || foundSet.equals("medusa")))
                {
                    foundSet = "medusa";
                    pieces++;
                }
                if (armor instanceof ZeusArmor && (foundSet == null || foundSet.equals("zeus")))
                {
                    foundSet = "zeus";
                    pieces++;
                }
            }

            if (pieces != 4)
                return;

            if (foundSet.equals("aether"))
            {
                try {
                    if (event.source == DamageSource.fall)
                    {
                        event.setCanceled(true);
                    }
                } catch (NullPointerException ignored) {}
                return;
            }

            if (foundSet.equals("hades"))
            {
                try {
                    if (event.source == DamageSource.inFire || event.source == DamageSource.lava)
                    {
                        event.setCanceled(true);
                        event.entity.extinguish();
                    }
                } catch (NullPointerException ignored) {}
                return;
            }

            if (foundSet.equals("medusa"))
            {
                if (event.source == MysticDamageSource.acid)
                    event.setCanceled(true);
                return;
            }


            if (foundSet.equals("zeus"))
            {
                if (event.source == MysticDamageSource.electric)
                    event.setCanceled(true);
                try {
                    Vec3 vec = event.entityLiving.getLookVec();
                    event.source.getSourceOfDamage().motionX = vec.xCoord *2;
                    event.source.getSourceOfDamage().motionY = vec.yCoord *2;
                    event.source.getSourceOfDamage().motionZ = vec.zCoord *2;
                } catch (NullPointerException ignored) {}
                return;
            }
        }
    }

    @SubscribeEvent
    public void onLigtning(EntityStruckByLightningEvent event)
    {
        String foundSet = null;
        int pieces = 0;

        if (!(event.entity instanceof EntityPlayer))
            return;

        for (int i = 0; i < 4; i++)
        {
            Item armor = null;
            try {
                armor = ((EntityPlayer) event.entity).getCurrentArmor(i).getItem();
                if (armor == null)
                    return;
            } catch (NullPointerException e) {
                return;
            }
            if (armor instanceof AetherArmor && (foundSet == null || foundSet.equals("aether")))
            {
                foundSet = "aether";
                pieces++;
            }
            if (armor instanceof HadesArmor && (foundSet == null || foundSet.equals("hades")))
            {
                foundSet = "hades";
                pieces++;
            }
            if (armor instanceof MedusaArmor && (foundSet == null || foundSet.equals("medusa")))
            {
                foundSet = "medusa";
                pieces++;
            }
            if (armor instanceof ZeusArmor && (foundSet == null || foundSet.equals("zeus")))
            {
                foundSet = "zeus";
                pieces++;
            }
        }


        if (pieces != 4)
            return;

        if (foundSet.equals("zeus"))
        {
            event.lightning.setDead();
            event.setCanceled(true);
        }
    }
}
