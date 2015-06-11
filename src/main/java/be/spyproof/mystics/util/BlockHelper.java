package be.spyproof.mystics.util;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Spyproof.
 */
public class BlockHelper
{
    private static List<Block> vanillaMundaneBlocks;
    private static List<Block> vanillaAcidBlocks;

    public BlockHelper()
    {
        vanillaMundaneBlocks = new LinkedList<Block>();
        vanillaMundaneBlocks.add(Blocks.stone);
        vanillaMundaneBlocks.add(Blocks.stonebrick);
        vanillaMundaneBlocks.add(Blocks.stone_slab);
        vanillaMundaneBlocks.add(Blocks.dirt);
        vanillaMundaneBlocks.add(Blocks.grass);
        vanillaMundaneBlocks.add(Blocks.gravel);
        vanillaMundaneBlocks.add(Blocks.sapling);
        vanillaMundaneBlocks.add(Blocks.sand);
        vanillaMundaneBlocks.add(Blocks.leaves);
        vanillaMundaneBlocks.add(Blocks.leaves2);
        vanillaMundaneBlocks.add(Blocks.web);
        vanillaMundaneBlocks.add(Blocks.tallgrass);
        vanillaMundaneBlocks.add(Blocks.deadbush);
        vanillaMundaneBlocks.add(Blocks.red_flower);
        vanillaMundaneBlocks.add(Blocks.yellow_flower);
        vanillaMundaneBlocks.add(Blocks.farmland);
        vanillaMundaneBlocks.add(Blocks.water);

        vanillaAcidBlocks = new LinkedList<Block>();
        vanillaAcidBlocks.add(Blocks.netherrack);
        vanillaAcidBlocks.add(Blocks.soul_sand);
        vanillaAcidBlocks.add(Blocks.mossy_cobblestone);
        vanillaAcidBlocks.add(Blocks.wooden_slab);
        vanillaAcidBlocks.add(Blocks.double_wooden_slab);
        vanillaAcidBlocks.add(Blocks.sandstone);
        vanillaAcidBlocks.add(Blocks.clay);
        vanillaAcidBlocks.add(Blocks.log);
        vanillaAcidBlocks.add(Blocks.log2);
        vanillaAcidBlocks.add(Blocks.cobblestone);
        vanillaAcidBlocks.add(Blocks.planks);
        vanillaAcidBlocks.add(Blocks.lava);
    }

    public static boolean isMundane(Block block)
    {
        if (vanillaMundaneBlocks.contains(block))
            return true;

        return false;
    }

    public static boolean acidCanBreak(Block block)
    {
        if (isMundane(block))
            return true;
        if (vanillaAcidBlocks.contains(block))
            return true;
        else return false;
    }
}
