package pdoxcore.init;

import pdoxcore.items.ItemList;
import pdoxcore.util.BlockAndItemHelper;
import pdoxcore.util.OreConfigDefault;

import static pdoxcore.init.ModBlocks.helper;
import static pdoxcore.init.ModBlocks.ores;

/**
 * Created by WildWolf on 27/09/2016.
 */
public class ModOreDic {

    private static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static void init(){

        for (int i = 0; i < ores.length; i++) {
            helper.registerOreDic("ore" + OreConfigDefault.byNumber(i).getOre(), ores[i]);
        }

        for (int i = 0; i < ItemList.ingots.length; i++){
            helper.registerOreDic(ItemList.Ingots.byMetadata(i).getName(), ItemList.ingots[i]);
        }

        for (int i = 0; i < ItemList.chunks.length; i++){
            helper.registerOreDic(ItemList.Chunks.byMetadata(i).getName(), ItemList.chunks[i]);
        }

    }

}
