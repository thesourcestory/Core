package realtech.config;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by WildWolf on 20/10/2016.
 */
public class CoreConfig {

    public static void init(FMLPreInitializationEvent event){
        ConfigHandeler.initConfig(event, "core");

        ConfigHandeler.setCustomComment("core", "core", "This is for enabling and disabling modules in the mod");

        ConfigHandeler.setBoolean("core", "core.oregen", "enabled", true);
        ConfigHandeler.setBoolean("core", "core.tools", "enabled", true);
        ConfigHandeler.setBoolean("core", "core.armor", "enabled", true);

        ConfigHandeler.saveCfg("core");
    }

}
