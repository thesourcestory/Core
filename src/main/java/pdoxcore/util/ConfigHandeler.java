package pdoxcore.util;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import java.io.File;

/**
 * Created by WildWolf on 20/09/2016.
 */
public class ConfigHandeler {

    private static Configuration configuration = null;
    private static File file = null;
    private static ModLogger logger = new ModLogger();

    public static void initConfig(FMLPreInitializationEvent event) {
        file = new File(event.getModConfigurationDirectory().toString() + "/pdox/core.cfg");
        if (!file.exists()) {
            configuration = new Configuration(file);

            configuration.setCategoryComment("Ores","Change values based on what you want to happen");

            configuration.save();

            for (OreConfigDefault ore: OreConfigDefault.values()) {
                configuration.get("ores." + ore.getOre(), "genCount", ore.getGenCount());
                configuration.get("ores." + ore.getOre(), "chance", ore.getChance());
                configuration.get("ores." + ore.getOre(), "minY", ore.getMiny());
                configuration.get("ores." + ore.getOre(), "maxY", ore.getMaxy());
                configuration.get("ores." + ore.getOre(), "mininglvl", ore.getMiningLvl());
                configuration.get("ores." + ore.getOre(), "doSpawn", true);
            }

            configuration.save();
        } else if (file.exists()) {
            logger.warning(logger.getModid() + " has config file");
        } else {

        }
    }


    public static double getDouble(String category, String key, double defaultValue){
        return configuration.get(category, key, defaultValue).getDouble();
    }

    public static int getInteger(String category, String key, int defaultValue){
        return configuration.get(category, key, defaultValue).getInt();
    }

    public static boolean getBoolean(String category, String key, boolean defaultValue){
        return configuration.get(category, key, defaultValue).getBoolean();
    }

    public static String getString(String category, String key, String defaultValue){
        return configuration.get(category, key, defaultValue).getString();
    }

}
