package pdoxcore.proxy;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import pdoxcore.init.ModItemBlocks;

import static pdoxcore.init.ModBlocks.helper;

/**
 * Created by WildWolf on 30/06/2016.
 */
public class RenderItemBlocks{

    public static void render(){

        helper.renderItem(ModItemBlocks.ores[1], 0, new ModelResourceLocation("pdoxcore:ores/copper", "inventory"));

    }

}
