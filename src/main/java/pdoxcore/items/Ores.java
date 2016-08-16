package pdoxcore.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import pdoxcore.test.IMetaBlockName;

/**
 * Created by magnus97 on 16/08/2016.
 */
public class Ores extends ItemBlock {

    public Ores(Block block) {
        super(block);
        if(!(block instanceof IMetaBlockName)){
            throw new IllegalArgumentException(String.format("The given Block %s is not an instance of ISpecialBlockName!", block.getUnlocalizedName()));
        }
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getMetadata(int damage){
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + "." + ((IMetaBlockName)this.block).getSpecialName(stack);
    }
}
