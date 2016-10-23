package realtech.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by WildWolf on 11/10/2016.
 */
public class ModTabs {

    public static final CreativeTabs realtechores = new CreativeTabs("realtechores") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModBlocks.ores[1]);
        }
    };

    public static final CreativeTabs realtechelements = new CreativeTabs("realtechelements") {
        @Override
        public Item getTabIconItem() {
            return ModItems.ingots;
        }
    };

    public static final CreativeTabs realtechtoolsandarmor = new CreativeTabs("realtechtoolsandarmor") {
        @Override
        public Item getTabIconItem() {
            return ModItems.debugger;
        }
    };

}
