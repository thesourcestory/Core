package pdoxcore.init;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
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
        ConfigHandeler.initConfig(event);

        System.out.println(ConfigHandeler.getBoolean("ores.lead", "doSpawn", true));

        ModBlocks.init();
        ModItems.init();

        proxy.registerRenders();
}

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
        Recipes.register();
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
    }
}
