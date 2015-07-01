package be.spyproof.mystics.handler;

import net.minecraft.util.DamageSource;

/**
 * Created by Spyproof.
 */
public class MysticDamageSource extends DamageSource
{
    public static MysticDamageSource acid = new MysticDamageSource("acid");
    public static MysticDamageSource electric = new MysticDamageSource("electric");

    public MysticDamageSource(String damageType)
    {
        super(damageType);
    }
}
