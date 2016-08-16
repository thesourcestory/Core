package pdoxcore.init;

import net.minecraft.item.ItemBlock;
import pdoxcore.init.ModBlocks;
import pdoxcore.items.Ores;
import pdoxcore.items.Ores1;
import pdoxcore.items.Ores2;

/**
 * Created by magnus97 on 30/06/2016.
 */
public class ModItemBlocks extends ModBlocks{

    public static ItemBlock ores1 = new Ores1(ModBlocks.ores1);
    public static ItemBlock ores2 = new Ores2(ModBlocks.ores2);
    public static ItemBlock ores = new Ores(ModBlocks.ores);

    public static void init(){
        helper.registerIBlock(ores, "ores");
        helper.registerIBlock(ores1, "ores1");
        helper.registerIBlock(ores2, "ores2");
    }

}
