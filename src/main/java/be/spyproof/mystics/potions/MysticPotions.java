package be.spyproof.mystics.potions;

import net.minecraft.potion.Potion;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Spyproof.
 */
public class MysticPotions
{
    public static PotionBase freeze;
    public static PotionBase freezeResist;
    public static PotionBase fly;

    public static void init()
    {
        Potion[] potionTypes = null;

        for (Field f : Potion.class.getDeclaredFields())
        {
            f.setAccessible(true);
            try
            {
                if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a"))
                {
                    Field modfield = Field.class.getDeclaredField("modifiers");
                    modfield.setAccessible(true);
                    modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

                    potionTypes = (Potion[]) f.get(null);
                    final Potion[] newPotionTypes = new Potion[256];
                    System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
                    f.set(null, newPotionTypes);
                }
            } catch (Exception e)
            {
                System.err.println("Severe error, please report this to the mod author:");
                System.err.println(e);
            }
        }
    }

    public static void load()
    {
        //TODO config option & propper name
        freeze = (new PotionFreeze(32, true, 0)).setIconIndex(1, 0).setPotionName("Freeze");
        freezeResist = (new PotionSimple(33, false, 0)).setIconIndex(1, 0).setPotionName("Freeze Resist");
        fly = (new PotionFly(34, false, 0)).setIconIndex(2, 1).setPotionName("Fly");
    }

    public static PotionBase[] getAllPotions()
    {
        return new PotionBase[]{freeze, freezeResist};
    }
}
