package pdoxcore.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import pdoxcore.blocks.Ores;
import pdoxcore.blocks.Ores1;
import pdoxcore.blocks.Ores2;
import pdoxcore.interfaces.BlockAndItemHelper;

/**
 * Created by magnus97 on 19/05/2016.
 */
public class ModBlocks {

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static Block ores1 = new Ores1(Material.ROCK, 3.0F, 5.0F);
    public static Block ores2 = new Ores2(Material.ROCK, 3.0F, 5.0F);
    public static Block ores = new Ores(Material.ROCK, 3.0F, 5.0F);

    public static void init(){
        helper.registerBlock(ores, "ores");
        helper.registerBlock(ores1, "ores1");
        helper.registerBlock(ores2, "ores2");

        ModItemBlocks.init();
    }

}
