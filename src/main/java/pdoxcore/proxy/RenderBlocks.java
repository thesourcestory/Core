package pdoxcore.proxy;

import pdoxcore.stuff.BlockAndItemHelper;

/**
 * Created by magnus97 on 22/05/2016.
 */
public class RenderBlocks{

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static void render() {

        RenderItemBlocks.render();
    }
}
