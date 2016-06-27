package pdox.core.junk;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import pdox.core.blocks.ModBlocks;

/**
 * Created by magnus97 on 28/06/2016.
 */
public class BlockAndItemHelper {

    public void renderBlock(Block block, int metadata, ModelResourceLocation location){
        Item item = Item.getItemFromBlock(Block.REGISTRY.getObject(new ResourceLocation("pdox", block.getUnlocalizedName())));
        ModelLoader.setCustomModelResourceLocation(item, metadata, location);
    }

    public void renderItem(Item item, int metadata, ModelResourceLocation location){
        Item ritem = Item.REGISTRY.getObject(new ResourceLocation("pdox", item.getUnlocalizedName()));
        ModelLoader.setCustomModelResourceLocation(ritem, metadata, location);
    }

    public void registerBlock(Block block, String name){
        block.setRegistryName(name);
        block.setUnlocalizedName(name);
        GameRegistry.register(block);
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setUnlocalizedName(block.getUnlocalizedName());
        itemBlock.setRegistryName(block.getRegistryName());
        GameRegistry.register(itemBlock);
    }

    public void registerItem(Item item, String name){
        item.setUnlocalizedName(name);
        item.setRegistryName(name);
        GameRegistry.register(item);
    }

}
