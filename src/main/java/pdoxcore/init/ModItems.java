package pdoxcore.init;

import net.minecraft.item.Item;
import pdoxcore.stuff.BlockAndItemHelper;
import pdoxcore.items.Debugger;

/**
 * Created by WildWolf on 22/05/2016.
 */
public class ModItems {

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static Item debugger = new Debugger();

    public static void init(){
        helper.registerItem(debugger, "debugger");
    }

}
