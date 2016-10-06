package pdoxcore.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

import pdoxcore.blocks.*;
import pdoxcore.util.BlockAndItemHelper;
import pdoxcore.util.ConfigHandeler;
import pdoxcore.util.OreConfigDefault;

/**
 * Created by WildWolf on 19/05/2016.
 */
public class ModBlocks {

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static Block[] ores = new Block[OreConfigDefault.values().length];

    private static void initBlock(){
        for (int i = 0; i < OreConfigDefault.values().length; i++) {
            ores[i] = new BlockOre(Material.ROCK,
                    ConfigHandeler.getInteger("ores." + OreConfigDefault.byNumber(i).getOre(), "chance", OreConfigDefault.byNumber(i).getChance()),
                    ConfigHandeler.getInteger("ores." + OreConfigDefault.byNumber(i).getOre(), "genCount", OreConfigDefault.byNumber(i).getGenCount()),
                    ConfigHandeler.getInteger("ores." + OreConfigDefault.byNumber(i).getOre(), "minY", OreConfigDefault.byNumber(i).getMiny()),
                    ConfigHandeler.getInteger("ores." + OreConfigDefault.byNumber(i).getOre(), "maxY", OreConfigDefault.byNumber(i).getMaxy()), i,
                    OreConfigDefault.byNumber(i).getOre().toLowerCase(),
                    ConfigHandeler.getInteger("ores." + OreConfigDefault.byNumber(i).getOre(), "mininglvl", OreConfigDefault.byNumber(i).getMiningLvl()),
                    ConfigHandeler.getBoolean("ores." + OreConfigDefault.byNumber(i).getOre(), "doSpawn", true));
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
