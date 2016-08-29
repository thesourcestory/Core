package pdoxcore.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import pdoxcore.blocks.Ores;
import pdoxcore.init.ModBlocks;

import java.util.Random;

/**
 * Created by WildWolf on 25/08/2016.
 */
public class OreGen implements IWorldGenerator {

    private WorldGenerator[] ores = new WorldGenerator[Ores.OreTypes.values().length + Ores.Ore1Types.values().length + Ores.Ore2Types.values().length];
    private static int[] chance = new int[Ores.OreTypes.values().length + Ores.Ore1Types.values().length + Ores.Ore2Types.values().length];
    private static int[][] level = new int[Ores.OreTypes.values().length + Ores.Ore1Types.values().length + Ores.Ore2Types.values().length][2];

    public OreGen(){
        for(int i = 0; i < Ores.OreTypes.values().length; i++){
            this.ores[i] = new WorldGenMinable(ModBlocks.ores.getStateFromMeta(i), Ores.OreTypes.byMetadata(i).getGenCount());
            this.chance[i] = Ores.OreTypes.byMetadata(i).getChance();
            this.level[i] = Ores.OreTypes.byMetadata(i).getLevel();
        }
        for(int i = 0; i < Ores.Ore1Types.values().length; i++){
            this.ores[i + Ores.OreTypes.values().length] = new WorldGenMinable(ModBlocks.ores1.getStateFromMeta(i), Ores.Ore1Types.byMetadata(i).getGenCount());
            this.chance[i + Ores.OreTypes.values().length] = Ores.OreTypes.byMetadata(i).getChance();
            this.level[i + Ores.OreTypes.values().length] = Ores.OreTypes.byMetadata(i).getLevel();
        }
        for(int i = 0; i < Ores.Ore2Types.values().length; i++){
            this.ores[i + Ores.OreTypes.values().length + Ores.Ore1Types.values().length] = new WorldGenMinable(ModBlocks.ores2.getStateFromMeta(i), Ores.Ore2Types.byMetadata(i).getGenCount());
            this.chance[i + Ores.OreTypes.values().length + Ores.Ore1Types.values().length] = Ores.OreTypes.byMetadata(i).getChance();
            this.level[i + Ores.OreTypes.values().length + Ores.Ore1Types.values().length] = Ores.OreTypes.byMetadata(i).getLevel();
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()){
            case 0:
                for(int i = 0; i < ores.length; i++){
                    runGenerator(ores[i], world, random, chunkX, chunkZ, chance[i], level[i][0], level[i][1]);
                }
                break;
            case -1:

                break;
            case 1:

                break;
        }
    }

    /***
     *
     * @param generator What ore to gen
     * @param world what world is calling the gen
     * @param random yay randomness
     * @param chunkX the chunkX pos
     * @param chunkZ the chunkZ pos
     * @param chance yay more randomness
     * @param minY what minimum level to spawn it on
     * @param maxY what maximum level to spawn it on
     */
    private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, int minY, int maxY){
        if (minY < 0) minY = 0;
        if (maxY > 256) maxY = 0;
        int heightDiff = maxY - minY + 1;
        for(int i = 0; i < chance; i++){
            int x = chunkX * 16 + random.nextInt(16);
            int y = minY + random.nextInt(heightDiff);
            int z = chunkZ * 16 + random.nextInt(16);
            generator.generate(world, random, new BlockPos(x,y,z));
        }
    }
}
