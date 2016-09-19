package pdoxcore.init;

import net.minecraft.item.ItemBlock;

/**
 * Created by WildWolf on 30/06/2016.
 */
public class ModItemBlocks extends ModBlocks {

    public static ItemBlock[] ores = new ItemBlock[ModBlocks.ores.length];

    static {
        for (int i = 0; i < ores.length; i++) {
            ores[i] = new ItemBlock(ModBlocks.ores[i]);
        }
    }

    public static void init() {
        for (int i = 0; i < ores.length; i++) {
            helper.registerIBlock(ores[i], ores[i].getUnlocalizedName().substring(5));
        }
    }

}
