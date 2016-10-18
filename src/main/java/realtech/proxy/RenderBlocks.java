package realtech.proxy;

import realtech.init.ModBlocks;
import realtech.util.BlockAndItemHelper;

/**
 * Created by WildWolf on 22/05/2016.
 */
public class RenderBlocks {

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static void render() {

        for(int i = 0; i < ModBlocks.ores.length; i++) {
            helper.renderBlock(ModBlocks.ores[i]);
        }

        RenderItemBlocks.render();
    }
}
