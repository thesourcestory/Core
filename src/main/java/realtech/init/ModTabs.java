package realtech.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by WildWolf on 11/10/2016.
 */
public class ModTabs {

    public static final CreativeTabs pdoxcoreores = new CreativeTabs("pdoxcoreores") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModBlocks.ores[1]);
        }
    };

    public static final CreativeTabs pdoxcoreelements = new CreativeTabs("pdoxcoreelements") {
        @Override
        public Item getTabIconItem() {
            return ModItems.ingots;
        }
    };

    public static final CreativeTabs pdoxcoretoolsandarmor = new CreativeTabs("pdoxcoretoolsandarmor") {
        @Override
        public Item getTabIconItem() {
            return ModItems.debugger;
        }
    };

}
