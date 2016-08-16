package pdoxcore.stuff;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by magnus97 on 28/06/2016.
 */
public class BlockAndItemHelper {

    private static String modid = "pdoxcore";

    /**
     * for rendering blocks
     *
     * @param block the block that you want rendered
     * @param metadata metadata of the block if it has one else set 0
     * @param location the model you want
     */
    public void renderBlock(Block block, int metadata, ModelResourceLocation location){
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), metadata, location);
    }

    /**
     * for rendering items
     *
     * @param item the item that you want rendered
     * @param metadata metadata of the block if it has one else set 0
     * @param location the model you want
     */
    public void renderItem(Item item, int metadata, ModelResourceLocation location){
        ModelBakery.registerItemVariants(item, location);
        ModelLoader.setCustomModelResourceLocation(item, metadata, location);
    }

    /**
     * for registering blocks
     *
     * @param block the block that you want registered
     * @param name the unlocalized and registry name for the block
     */
    public void registerBlock(Block block, String name){
        block.setRegistryName(name);
        block.setUnlocalizedName(name);
        GameRegistry.register(block);
    }

    public void registerIBlock(ItemBlock itemBlock, String name){
        itemBlock.setRegistryName(name);
        itemBlock.setUnlocalizedName(name);
        GameRegistry.register(itemBlock);
    }

    /**
     * for registering items
     *
     * @param item the item that you want registered
     * @param name the unlocalized and registry name for the block
     */
    public void registerItem(Item item, String name){
        item.setUnlocalizedName(name);
        item.setRegistryName(name);
        GameRegistry.register(item);
    }

}
