package realtech.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import realtech.proxy.CommonProxy;
import realtech.recipes.Recipes;
import realtech.config.ConfigHandler;
import realtech.util.ModLogger;
import realtech.util.References;
import realtech.world.OreGen;

/**
 * Created by WildWolf on 19/05/2016.
 */
@Mod(modid = References.Mod.MODID, name = References.Mod.NAME, version = References.Mod.VER)
public class Realtech {

    @SidedProxy(clientSide = References.Mod.CPROXY, serverSide = References.Mod.SPROXY)
    public static CommonProxy proxy;
    private static ModLogger logger = new ModLogger();

    public static final CreativeTabs realtechores = ModTabs.realtechores;

    public static final CreativeTabs realtechelements = ModTabs.realtechelements;

    public static final CreativeTabs realtechtoolsandarmor = ModTabs.realtechtoolsandarmor;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        logger.warning("preInit of realtech might take a sec");
        ConfigHandler.initConfigs(event);

        ModBlocks.init();
        ModItems.init();

        proxy.registerRenders();
        ModOreDic.init();
        logger.info("preInit of realtech is done");//*/
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        logger.warning("init of realtech might take a sec");
        if (ConfigHandler.getBoolean("core", "core.oregen", "enabled", true))
            GameRegistry.registerWorldGenerator(new OreGen(), 0);
        Recipes.register();

        logger.info("init of realtech is done");//*/
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
    }
}
