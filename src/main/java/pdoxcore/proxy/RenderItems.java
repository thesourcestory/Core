package pdoxcore.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import pdoxcore.init.ModItems;
import pdoxcore.items.EnumOreChunk;
import pdoxcore.items.ItemList;
import pdoxcore.util.BlockAndItemHelper;

/**
 * Created by WildWolf on 22/05/2016.
 */
public class RenderItems{

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static void render(){
        helper.renderItem(ModItems.debugger);
        for(int i = 0; i < EnumOreChunk.values().length; i++){
            helper.renderItem(ModItems.orechunk, i, new ModelResourceLocation("pdoxcore:chunks/" + EnumOreChunk.byMetadata(i).getName(), "inventory"));
        }
        for(int i = 0; i < ItemList.Ingots.values().length; i++){
            helper.renderItem(ModItems.ingots, i, new ModelResourceLocation("pdoxcore:ingots/" + ItemList.Ingots.byMetadata(i).getName(), "inventory"));
        }
    }
}
