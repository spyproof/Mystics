package be.spyproof.mystics.potions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.potion.Potion;

/**
 * Created by Spyproof.
 */
public abstract class PotionBase extends Potion implements IPotion
{
    /**
     * TODO make this decent
     * Potion icon
     * Render the cooldown above target
     * Once i know how rendering works, render player as stone
     */
    public PotionBase(int id, boolean isBadEffect, int liquidColor)
    {
        super(id, isBadEffect, liquidColor);
    }

    public PotionBase setIconIndex(int x, int y)
    {
        super.setIconIndex(x, y);
        return this;
    }

    public PotionBase setPotionName(String potionName)
    {
        super.setPotionName(potionName);
        return this;
    }

    public boolean isInstant()
    {
        return super.isInstant();
    }
}
