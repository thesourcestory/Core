package realtech.init;

import net.minecraft.item.Item;
import realtech.config.ConfigHandler;
import realtech.items.*;
import realtech.util.BlockAndItemHelper;

/**
 * Created by WildWolf on 22/05/2016.
 */
public class ModItems {

    public static BlockAndItemHelper helper = new BlockAndItemHelper();

    public static Item ingots = new Ingots();
    public static Item orechunk = new OreChunk();
    public static Item debugger = new Debugger();

    public static void init() {
        helper.registerItem(debugger, "debugger", "debugger");
        helper.registerItem(ingots, "ingots", "ingots");
        helper.registerItem(orechunk, "orechunk", "orechunk");
        if (ConfigHandler.getBoolean("core", "core.armor", "enabled", true))
        ModArmor.init();
        if (ConfigHandler.getBoolean("core", "core.tools", "enabled", true))
            ModTools.init();
    }
}
