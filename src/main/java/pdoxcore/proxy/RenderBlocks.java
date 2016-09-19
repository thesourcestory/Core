package pdoxcore.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import pdoxcore.init.ModBlocks;
import pdoxcore.stuff.BlockAndItemHelper;

/**
 * Created by WildWolf on 22/05/2016.
 */
public class RenderBlocks {

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static void render() {

        helper.renderBlock(ModBlocks.ores[1], 0, new ModelResourceLocation("pdoxcore:copper", "inventory"));

        RenderItemBlocks.render();
    }
}
