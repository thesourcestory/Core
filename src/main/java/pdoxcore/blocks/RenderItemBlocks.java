package pdoxcore.blocks;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

/**
 * Created by magnus97 on 30/06/2016.
 */
public class RenderItemBlocks extends RenderBlocks{

    public static void render(){
        helper.renderItem(ModItemBlocks.test, 0, new ModelResourceLocation("minecraft:stone", "inventory"));
    }

}
