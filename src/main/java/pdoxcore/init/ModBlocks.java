package pdoxcore.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import pdoxcore.blocks.*;
import pdoxcore.util.BlockAndItemHelper;

/**
 * Created by WildWolf on 19/05/2016.
 */
public class ModBlocks {

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static Block[] ores = new Block[EnumOres.values().length];

    static {
        for (int i = 0; i < EnumOres.values().length; i++) {
            ores[i] = new BlockOre(Material.ROCK, EnumOres.byMetadata(i).getChance(), EnumOres.byMetadata(i).getGenCount(), EnumOres.byMetadata(i).getLevel()[0], EnumOres.byMetadata(i).getLevel()[1], i, EnumOres.byMetadata(i).getName(), 2);
        }
    }

    private static void initBlock(){
        for (int i = 0; i < EnumOres.values().length; i++) {
            ores[i] = new BlockOre(Material.ROCK, EnumOres.byMetadata(i).getChance(), EnumOres.byMetadata(i).getGenCount(), EnumOres.byMetadata(i).getLevel()[0], EnumOres.byMetadata(i).getLevel()[1], i, EnumOres.byMetadata(i).getName(), 2);
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
