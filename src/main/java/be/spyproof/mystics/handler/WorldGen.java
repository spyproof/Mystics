package be.spyproof.mystics.handler;

import be.spyproof.mystics.init.RegisterGodBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by Spyproof.
 */
public class WorldGen implements IWorldGenerator
{
    private WorldGenerator worldGeneratorLightningOre;
    private WorldGenerator worldGeneratorFireOre;
    private WorldGenerator worldGeneratorWaterOre;

    public WorldGen()
    {
        this.worldGeneratorLightningOre = new WorldGenMinable(RegisterGodBlocks.LIGHTNING_BLOCK, 1);
        this.worldGeneratorFireOre = new WorldGenMinable(RegisterGodBlocks.FIRE_BLOCK, 1);
        this.worldGeneratorWaterOre = new WorldGenMinable(RegisterGodBlocks.WATER_BLOCK, 1);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case 0: // Overworld
                break;
            case 1: // End
                break;
            case -1: // Nether
                break;
        }
    }

    //TODO
    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight)
    {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i ++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, x, y, z);
    }
}
}
