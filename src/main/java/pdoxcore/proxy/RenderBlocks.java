package pdoxcore.proxy;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import pdoxcore.init.ModBlocks;
import pdoxcore.stuff.BlockAndItemHelper;

/**
 * Created by WildWolf on 22/05/2016.
 */
public class RenderBlocks{

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static void render() {

        ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.ores), new ModelResourceLocation("pdoxcore:ores", "inventory"), new ModelResourceLocation("pdoxcore:ores/copper", "inventory"));

        helper.renderBlock(ModBlocks.ores, 1, new ModelResourceLocation("pdoxcore:ores/copper", "inventory"));

        RenderItemBlocks.render();
    }
}
