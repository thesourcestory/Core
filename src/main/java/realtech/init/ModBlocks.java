package realtech.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import realtech.blocks.*;
import realtech.config.ConfigHandler;
import realtech.util.BlockAndItemHelper;
import realtech.util.OreConfigDefault;

/**
 * Created by WildWolf on 19/05/2016.
 */
public class ModBlocks {

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static Block[] ores = new Block[OreConfigDefault.values().length];

    private static void initBlock(){
        for (int i = 0; i < OreConfigDefault.values().length; i++) {
            ores[i] = new BlockOre(Material.ROCK,
                    ConfigHandler.getInteger("oregen", "ores." + OreConfigDefault.byNumber(i).getOre(), "chance", OreConfigDefault.byNumber(i).getChance()),
                    ConfigHandler.getInteger("oregen", "ores." + OreConfigDefault.byNumber(i).getOre(), "genCount", OreConfigDefault.byNumber(i).getGenCount()),
                    ConfigHandler.getInteger("oregen", "ores." + OreConfigDefault.byNumber(i).getOre(), "minY", OreConfigDefault.byNumber(i).getMiny()),
                    ConfigHandler.getInteger("oregen", "ores." + OreConfigDefault.byNumber(i).getOre(), "maxY", OreConfigDefault.byNumber(i).getMaxy()), i,
                    OreConfigDefault.byNumber(i).getOre().toLowerCase(),
                    ConfigHandler.getInteger("oregen", "ores." + OreConfigDefault.byNumber(i).getOre(), "mininglvl", OreConfigDefault.byNumber(i).getMiningLvl()),
                    ConfigHandler.getBoolean("oregen", "ores." + OreConfigDefault.byNumber(i).getOre(), "doSpawn", true));
        }
    }

    public static void init() {
        initBlock();
        for (int i = 0; i < ores.length; i++) {
            helper.registerBlock(ores[i]);
        }

        ModItemBlocks.init();
    }

}
