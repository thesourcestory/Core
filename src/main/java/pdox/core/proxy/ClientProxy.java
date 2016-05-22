package pdox.core.proxy;

import pdox.core.blocks.RenderBlocks;
import pdox.core.items.RenderItems;

/**
 * Created by magnus97 on 19/05/2016.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders() {
        RenderItems.render();
        RenderBlocks.render();
    }
}
