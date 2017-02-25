package realtech.items.components;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import realtech.init.Realtech;

/**
 * Created by magnu on 23/02/2017.
 */
public class Resistor extends Item{

    public Resistor(){
        super();
        this.setHasSubtypes(true);
        this.setCreativeTab(Realtech.realtechelements);
    }

    public String getUnlocalizedName(ItemStack stack){
        String out = getDefaultName(stack);
        return out;
    }

    private String getDefaultName(ItemStack stack){
        return super.getUnlocalizedName() + "." + stack.getItemDamage();
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tabs, NonNullList<ItemStack> list){
        for(int i = 0; i < 72; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

}
