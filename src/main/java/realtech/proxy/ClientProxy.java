package realtech.proxy;

/**
 * Created by WildWolf on 19/05/2016.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders() {
        RenderItems.render();
        RenderBlocks.render();
    }
}
