package pdoxcore.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import pdoxcore.junk.BlockAndItemHelper;

/**
 * Created by magnus97 on 19/05/2016.
 */
public class ModBlocks {

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static Block test = new Test(Material.ROCK);

    public static void init(){
        helper.registerBlock(test, "test");

        ModItemBlocks.init();
    }

}
