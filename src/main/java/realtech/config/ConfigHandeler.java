package realtech.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import realtech.util.ModLogger;
import realtech.util.References;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WildWolf on 20/09/2016.
 */
public class ConfigHandeler {

    private static Map<String, Configuration> configuration;
    private static File file = null;
    private static ModLogger logger = new ModLogger();

    public static void initConfigs(FMLPreInitializationEvent event) {
        OregenConfig.init(event);
        CoreConfig.init(event);
    }

    /***
     * 
     * @param event FMLPreInitializationEvent from preInit
     * @param string what the config file will be caled
     */
    public static void initConfig(FMLPreInitializationEvent event, String string) {
        file = new File(event.getModConfigurationDirectory().toString() + "/" + References.Mod.MODID + "/" + string + ".cfg");
        if (configuration == null) {
            configuration = new HashMap<String, Configuration>();
        }
        if (configuration.get(string) == null) {
            configuration.put(string, new Configuration(file));
        }
        configuration.get(string).save();
        if (file.exists())
            logger.devInfo(logger.getModid() + " has config file " + file.getName());

    }
    
    /***
     *
     * @param config what the config is called
     * @param category what category it is under
     * @param comment what shall it say
     */
    public static void setCustomComment(String config, String category, String comment) {
        configuration.get(config).setCategoryComment(category, comment);
    }

    /***
     *
     * @param config what the config is called 
     * @param category what category it is under
     * @param key what is the config you want to set/get called
     * @param defaultValue the default value to the key 
     */
    public static void setDouble(String config, String category, String key, double defaultValue) {
        configuration.get(config).get(category, key, defaultValue);
    }

    /***
     *
     * @param config what the config is called
     * @param category what category it is under
     * @param key what is the config you want to set/get called
     * @param defaultValue the default value to the key
     */
    public static void setInteger(String config, String category, String key, int defaultValue) {
        configuration.get(config).get(category, key, defaultValue);
    }

    /***
     *
     * @param config what the config is called
     * @param category what category it is under
     * @param key what is the config you want to set/get called
     * @param defaultValue the default value to the key
     */
    public static void setBoolean(String config, String category, String key, boolean defaultValue) {
        configuration.get(config).get(category, key, defaultValue);
    }

    /***
     *
     * @param config what the config is called
     * @param category what category it is under
     * @param key what is the config you want to set/get called
     * @param defaultValue the default value to the key
     */
    public static void setString(String config, String category, String key, String defaultValue) {
        configuration.get(config).get(category, key, defaultValue);
    }

    /***
     *
     * @param config what the config is called
     * @param category what category it is under
     * @param key what is the config you want to set/get called
     * @param defaultValue the default value to the key
     */
    public static double getDouble(String config, String category, String key, double defaultValue) {
        return configuration.get(config).get(category, key, defaultValue).getDouble();
    }

    /***
     *
     * @param config what the config is called
     * @param category what category it is under
     * @param key what is the config you want to set/get called
     * @param defaultValue the default value to the key
     */
    public static int getInteger(String config, String category, String key, int defaultValue) {
        return configuration.get(config).get(category, key, defaultValue).getInt();
    }

    /***
     *
     * @param config what the config is called
     * @param category what category it is under
     * @param key what is the config you want to set/get called
     * @param defaultValue the default value to the key
     */
    public static boolean getBoolean(String config, String category, String key, boolean defaultValue) {
        return configuration.get(config).get(category, key, defaultValue).getBoolean();
    }

    /***
     *
     * @param config what the config is called
     * @param category what category it is under
     * @param key what is the config you want to set/get called
     * @param defaultValue the default value to the key
     */
    public static String getString(String config, String category, String key, String defaultValue) {
        return configuration.get(config).get(category, key, defaultValue).getString();
    }

    public static void saveAllCfgs(){
        for (Configuration config : configuration.values()) {
            config.save();
        }
    }

    /***
     *
     * @param config what the config is called
     */
    public static void saveCfg(String config) {
        configuration.get(config).save();
    }

}
