package pdoxcore.blocks;

import net.minecraft.item.ItemBlock;

/**
 * Created by magnus97 on 30/06/2016.
 */
public class ModItemBlocks extends ModBlocks{

    public static ItemBlock test = new ItemBlock(ModBlocks.test);

    public static void init(){
        helper.registerIBlock(test, "test");
    }

}
