package realtech.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import realtech.init.Realtech;

import java.util.List;

/**
 * Created by WildWolf on 25/08/2016.
 */
public class OreChunk extends Item {

    public OreChunk() {
        super();
        this.setHasSubtypes(true);
        this.setCreativeTab(Realtech.realtechores);
    }

    public String getUnlocalizedName(ItemStack stack) {
        String out = super.getUnlocalizedName() + "." + EnumOreChunk.byMetadata(stack.getItemDamage()).getName();
        return out;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list){
        for(int i = 0; i < EnumOreChunk.values().length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

}
