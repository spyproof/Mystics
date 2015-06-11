package be.spyproof.mystics.blocks;

import be.spyproof.mystics.init.RegisterGodItems;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Spyproof.
 */
public class ChargedBlock extends GodOre
{
    public ChargedBlock()
    {
        super();
        this.setBlockName("ChargedBlock");
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return RegisterGodItems.crystallisedLightning;
    }
}
