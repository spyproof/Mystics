package be.spyproof.mystics.blocks;

import be.spyproof.mystics.init.RegisterGodItems;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

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
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        //return super.getDrops(world, x, y, z, metadata, fortune);
        return new ArrayList<ItemStack>(){{add(new ItemStack(RegisterGodItems.crystals, 1, 0));}};
    }
}
