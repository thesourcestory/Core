package pdoxcore.init;

import net.minecraft.item.Item;
import pdoxcore.interfaces.BlockAndItemHelper;
import pdoxcore.items.Debugger;

/**
 * Created by magnus97 on 22/05/2016.
 */
public class ModItems {

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static Item debugger = new Debugger();

    public static void init(){
        helper.registerItem(debugger, "debugger");
    }

}
