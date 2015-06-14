package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.PlayerHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by Spyproof.
 */
public class ItemTestSword extends BoundSword
{
    public ItemTestSword()
    {
        super();
        this.setUnlocalizedName(Names.Items.TEST_SWORD);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        MovingObjectPosition mop = PlayerHelper.getLookPos(player);

        //spawnWater(world, mop.blockX, mop.blockY, mop.blockZ, 1);
        world.setBlock(mop.blockX, mop.blockY, mop.blockZ, Blocks.water);

        return itemStack;
    }

    protected void spawnWater(World world, int x, int y, int z, int radius)
    {
        for (int i = -radius; i <= radius; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                for (int k = -radius; k <= radius; k++)
                {
                    if (world.isAirBlock(x + i, y + j, z + k))
                    {
                        world.setBlock(x + i, y + j, z + k, Blocks.water);
                    }
                }
            }
        }
    }
}
