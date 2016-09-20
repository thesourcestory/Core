package pdoxcore.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import pdoxcore.init.ModItems;
import pdoxcore.util.BlockAndItemHelper;

/**
 * Created by WildWolf on 22/05/2016.
 */
public class RenderItems{

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static void render(){
        helper.renderItem(ModItems.ingots, 19, new ModelResourceLocation("pdoxcore:ingots/copper", "inventory"));
        helper.renderItem(ModItems.ingots, 50, new ModelResourceLocation("pdoxcore:ingots/lead", "inventory"));
        helper.renderItem(ModItems.debugger);
        helper.renderItem(ModItems.orechunk, 1, new ModelResourceLocation("pdoxcore:chunks/copper", "inventory"));
    }

}
