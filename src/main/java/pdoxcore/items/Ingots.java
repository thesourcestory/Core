package pdoxcore.items;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import pdoxcore.blocks.*;
import pdoxcore.blocks.Ores;
import pdoxcore.init.PdoxCore;

import java.util.List;

/**
 * Created by WildWolf on 16/08/2016.
 */
public class Ingots extends Item{

    public Ingots(){
        super();
        this.setHasSubtypes(true);
        this.setCreativeTab(PdoxCore.pdoxcore);
    }

    public String getUnlocalizedName(ItemStack stack){
        String out = super.getUnlocalizedName() + ".";
        switch(stack.getItemDamage()){
            case 1:
                out = out + "copper";
            case 2:
                out = out + "tin";
            case 3:
                out = out + "lead";
            case 4:
                out = out + "silver";
            case 5:
                out = out + "platinum";
            default:
                out = out + "zinc";
        }
        return out;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list){
        for(int i = 0; i < 5; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

}
