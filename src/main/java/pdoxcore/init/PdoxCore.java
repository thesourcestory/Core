package pdoxcore.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import pdoxcore.items.Ores;
import pdoxcore.proxy.CommonProxy;
import pdoxcore.world.OreGen;

/**
 * Created by WildWolf on 19/05/2016.
 */
@Mod(modid = "pdoxcore", name = "PardadoxCore", version = "0.0.1")
public class PdoxCore {

    @SidedProxy(clientSide = "pdoxcore.proxy.ClientProxy",serverSide = "pdoxcore.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static final CreativeTabs pdoxcoreores = new CreativeTabs("pdoxcoreores") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModBlocks.ores);
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
        System.out.println("Pre Init of PdoxCore");
        ModBlocks.init();
        ModItems.init();

        proxy.registerRenders();
        System.out.println("Pre Init Of PdoxCore is done");
}

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
    }
}
