package pdox.core.blocks;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import pdox.core.junk.BlockAndItemHelper;

/**
 * Created by magnus97 on 22/05/2016.
 */
public class RenderBlocks{

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static void render() {
        helper.renderBlock(ModBlocks.test, 0, new ModelResourceLocation("minecraft:stone", "inventory"));
    }
}
