package pdox.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by magnus97 on 19/05/2016.
 */
public class ModBlocks {

    public static Block test = new Test(Material.ROCK, MapColor.GRAY);

    public static void init(){
        reg(test, "test");
    }

    public static void reg(Block block, String unlocalizedName){
        block.setRegistryName(unlocalizedName);
        GameRegistry.register(block);
    }

}
