package pdoxcore.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import pdoxcore.junk.BlockAndItemHelper;

/**
 * Created by magnus97 on 22/05/2016.
 */
public class RenderItems {

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static void render(){
        helper.renderItem(ModItems.test2, 0, new ModelResourceLocation("minecraf:iron_ingot", "inventory"));
    }

}
