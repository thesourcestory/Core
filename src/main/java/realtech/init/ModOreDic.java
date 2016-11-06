package realtech.init;

import realtech.items.ItemList;
import realtech.util.BlockAndItemHelper;
import realtech.util.OreConfigDefault;

import static realtech.init.ModBlocks.ores;

/**
 * Created by WildWolf on 27/09/2016.
 */
public class ModOreDic {

    private static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static void init(){

        for (int i = 0; i < ores.length; i++) {
            if(OreConfigDefault.byNumber(i).getOre() == "Bauxite") {
                helper.registerOreDic("oreAluminium", ores[i]);
                helper.registerOreDic("oreAluminum", ores[i]);
            }
            helper.registerOreDic("ore" + OreConfigDefault.byNumber(i).getOre(), ores[i]);
        }

        for (int i = 0; i < ItemList.ingots.length; i++){
            if (ItemList.Ingots.byMetadata(i).getName() == "Aluminium")
                helper.registerOreDic("ingotAluminum", ItemList.ingots[i]);
            helper.registerOreDic(ItemList.Ingots.byMetadata(i).getOredicName(), ItemList.ingots[i]);
        }

        for (int i = 0; i < ItemList.chunks.length; i++){
            if(ItemList.Chunks.byMetadata(i).getName() == "Bauxite") {
                helper.registerOreDic("oreAluminium", ItemList.chunks[i]);
                helper.registerOreDic("oreAluminum", ItemList.chunks[i]);
            }
            helper.registerOreDic(ItemList.Chunks.byMetadata(i).getOredicName(), ItemList.chunks[i]);
        }

    }

}
