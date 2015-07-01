package be.spyproof.mystics.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Spyproof.
 */
public class PlayerHelper
{
    private static int range = 64;
    private static Map<String, String> format = new HashMap<String, String>();

    static {
        format.put("&0", "\u00A70");
        format.put("&1", "\u00A71");
        format.put("&2", "\u00A72");
        format.put("&3", "\u00A73");
        format.put("&4", "\u00A74");
        format.put("&5", "\u00A75");
        format.put("&6", "\u00A76");
        format.put("&7", "\u00A77");
        format.put("&8", "\u00A78");
        format.put("&9", "\u00A79");
        format.put("&a", "\u00A7a");
        format.put("&b", "\u00A7b");
        format.put("&c", "\u00A7c");
        format.put("&d", "\u00A7d");
        format.put("&e", "\u00A7e");
        format.put("&f", "\u00A7f");
        format.put("&k", "\u00A7k");
        format.put("&l", "\u00A7l");
        format.put("&m", "\u00A7m");
        format.put("&n", "\u00A7n");
        format.put("&o", "\u00A7o");
        format.put("&r", "\u00A7r");
    }

    public static MovingObjectPosition getLookPos(EntityLivingBase player)
    {
        Vec3 position = Vec3.createVectorHelper(player.posX, player.posY + player.getEyeHeight(), player.posZ);
        Vec3 lookVec = player.getLookVec();
        Vec3 target = position.addVector(lookVec.xCoord * range, lookVec.yCoord * range, lookVec.zCoord * range);

        return player.worldObj.func_147447_a(position, target, false, false, true);
    }

    /**
     * https://github.com/WayofTime/BloodMagic/blob/master/src/main/java/WayofTime/alchemicalWizardry/common/spell/complex/effect/SpellHelper.java
     */

    public static List<Entity> getEntitiesInRange(World world, double posX, double posY, double posZ, double horizontalRadius, double verticalRadius)
    {
        return world.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(posX - 0.5f, posY - 0.5f, posZ - 0.5f, posX + 0.5f, posY + 0.5f, posZ + 0.5f).expand(horizontalRadius, verticalRadius, horizontalRadius));
    }

    public static List<EntityLivingBase> getLivingEntitiesInRange(World world, double posX, double posY, double posZ, double horizontalRadius, double verticalRadius)
    {
        return world.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(posX - 0.5f, posY - 0.5f, posZ - 0.5f, posX + 0.5f, posY + 0.5f, posZ + 0.5f).expand(horizontalRadius, verticalRadius, horizontalRadius));
    }


    public static List<EntityPlayer> getPlayersInRange(World world, double posX, double posY, double posZ, double horizontalRadius, double verticalRadius)
    {
        return world.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(posX - 0.5f, posY - 0.5f, posZ - 0.5f, posX + 0.5f, posY + 0.5f, posZ + 0.5f).expand(horizontalRadius, verticalRadius, horizontalRadius));
    }

    public static void messagePlayer(EntityPlayer player, String message)
    {
        for (String r : format.keySet())
            message = message.replace(r, format.get(r));

        player.addChatMessage(new ChatComponentText(message));
    }
}
