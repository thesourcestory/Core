package realtech.config;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import realtech.util.OreConfigDefault;

/**
 * Created by WildWolf on 20/10/2016.
 */
public class OregenConfig {

    public static void init(FMLPreInitializationEvent event){
        ConfigHandeler.initConfig(event, "oregen");

        ConfigHandeler.setCustomComment("oregen", "Ores", "Change values based on what you want to happen");

        for (OreConfigDefault ore: OreConfigDefault.values()) {
            ConfigHandeler.setInteger("oregen", "ores." + ore.getOre(), "genCount", ore.getGenCount());
            ConfigHandeler.setInteger("oregen", "ores." + ore.getOre(), "chance", ore.getChance());
            ConfigHandeler.setInteger("oregen", "ores." + ore.getOre(), "minY", ore.getMiny());
            ConfigHandeler.setInteger("oregen", "ores." + ore.getOre(), "maxY", ore.getMaxy());
            ConfigHandeler.setInteger("oregen", "ores." + ore.getOre(), "mininglvl", ore.getMiningLvl());
            ConfigHandeler.setBoolean("oregen", "ores." + ore.getOre(), "doSpawn", true);
        }

        ConfigHandeler.saveCfg("oregen");
    }

}
