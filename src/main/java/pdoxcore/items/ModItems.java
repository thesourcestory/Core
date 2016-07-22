package pdoxcore.items;

import net.minecraft.item.Item;
import pdoxcore.junk.BlockAndItemHelper;

/**
 * Created by magnus97 on 22/05/2016.
 */
public class ModItems {

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static Item test2 = new Test();
    
    public static void init(){
        helper.registerItem(test2, "test2");
    }

}
