package pdoxcore.init;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import pdoxcore.proxy.CommonProxy;
import pdoxcore.util.ConfigHandeler;
import pdoxcore.util.ModLogger;
import pdoxcore.util.References;
import pdoxcore.world.OreGen;

/**
 * Created by WildWolf on 19/05/2016.
 */
@Mod(modid = References.Mod.MODID, name = References.Mod.NAME, version = References.Mod.VER)
public class PdoxCore {

    @SidedProxy(clientSide = References.Mod.CPROXY,serverSide = References.Mod.SPROXY)
    public static CommonProxy proxy;
    private static ModLogger logger = new ModLogger();

    public static final CreativeTabs pdoxcoreores = new CreativeTabs("pdoxcoreores") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModBlocks.ores[1]);
        }
    };

    public static final CreativeTabs pdoxcoreelements = new CreativeTabs("pdoxcoreelements") {
        @Override
        public Item getTabIconItem() {
            return ModItems.ingots;
        }
    };

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        logger.warning("preInit of pdoxcore might take a sec");
        ConfigHandeler.initConfig(event);

        ModBlocks.init();
        ModItems.init();

        proxy.registerRenders();
        logger.info("preInit of pdoxcore is done");
}

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        logger.warning("init of pdoxcore might take a sec");
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
        Recipes.register();

        ModOreDic.init();
        logger.info("init of pdoxcore is done");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
    }
}
