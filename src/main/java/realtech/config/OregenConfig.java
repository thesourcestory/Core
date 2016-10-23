package realtech.config;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import realtech.util.OreConfigDefault;

/**
 * Created by WildWolf on 20/10/2016.
 */
public class OregenConfig {

    public static void init(FMLPreInitializationEvent event){
        ConfigHandler.initConfig(event, "oregen");

        ConfigHandler.setCustomComment("oregen", "Ores", "Change values based on what you want to happen");
        ConfigHandler.setCustomComment("oregen", "Oregen", "use the give command and give yourself the debugger item to see the oregen better");

        for (OreConfigDefault ore: OreConfigDefault.values()) {
            ConfigHandler.setInteger("oregen", "ores." + ore.getOre(), "genCount", ore.getGenCount());
            ConfigHandler.setInteger("oregen", "ores." + ore.getOre(), "chance", ore.getChance());
            ConfigHandler.setInteger("oregen", "ores." + ore.getOre(), "minY", ore.getMiny());
            ConfigHandler.setInteger("oregen", "ores." + ore.getOre(), "maxY", ore.getMaxy());
            ConfigHandler.setInteger("oregen", "ores." + ore.getOre(), "mininglvl", ore.getMiningLvl());
            ConfigHandler.setBoolean("oregen", "ores." + ore.getOre(), "doSpawn", true);
        }

        ConfigHandler.saveCfg("oregen");
    }

}
