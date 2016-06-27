package pdox.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import pdox.core.junk.BlockAndItemHelper;

/**
 * Created by magnus97 on 19/05/2016.
 */
public class ModBlocks {

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static Block test = new Test(Material.ROCK);

    public static void init(){
        helper.registerBlock(test, "test");
    }

}
