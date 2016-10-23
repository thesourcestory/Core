package realtech.config;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by WildWolf on 20/10/2016.
 */
public class CoreConfig {

    public static void init(FMLPreInitializationEvent event){
        ConfigHandler.initConfig(event, "core");

        ConfigHandler.setCustomComment("core", "core", "This is for enabling and disabling modules in the mod");

        ConfigHandler.setBoolean("core", "core.oregen", "enabled", true);
        ConfigHandler.setBoolean("core", "core.tools", "enabled", true);
        ConfigHandler.setBoolean("core", "core.armor", "enabled", true);
        ConfigHandler.setBoolean("core", "core.lumberaxe", "enabled", false);

        ConfigHandler.saveCfg("core");
    }

}
