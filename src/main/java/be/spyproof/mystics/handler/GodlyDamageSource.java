package be.spyproof.mystics.handler;

import net.minecraft.util.DamageSource;

/**
 * Created by Spyproof.
 */
public class GodlyDamageSource extends DamageSource
{
    public static GodlyDamageSource acid = new GodlyDamageSource("acid");
    public static GodlyDamageSource electric = new GodlyDamageSource("electric");

    public GodlyDamageSource(String damageType)
    {
        super(damageType);
    }
}
