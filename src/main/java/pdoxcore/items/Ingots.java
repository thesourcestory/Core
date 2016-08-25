package pdoxcore.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import pdoxcore.init.PdoxCore;

import java.util.List;

/**
 * Created by WildWolf on 16/08/2016.
 */
public class Ingots extends Item{

    public Ingots(){
        super();
        this.setHasSubtypes(true);
        this.setCreativeTab(PdoxCore.pdoxcoreelements);
    }

    public String getUnlocalizedName(ItemStack stack){
        String out = getDefaultName(stack);
        return out;
    }

    private String getDefaultName(ItemStack stack){
        return super.getUnlocalizedName() + "." + stack.getItemDamage();
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list){
        for(int i = 0; i < 88; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

}
