package pdox.core.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by magnus97 on 19/05/2016.
 */
public class ModBlocks {

    public static void init(){

    }

    public static void reg(Block block, String unlocalizedName){
        block.setUnlocalizedName(unlocalizedName);
        GameRegistry.registerBlock(block, unlocalizedName);
    }

}
