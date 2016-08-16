package pdoxcore.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import pdoxcore.proxy.CommonProxy;

/**
 * Created by magnus97 on 19/05/2016.
 */
@Mod(modid = "pdoxcore", name = "PardadoxCore", version = "0.0.1")
public class PdoxCore {

    @SidedProxy(clientSide = "pdoxcore.proxy.ClientProxy",serverSide = "pdoxcore.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static final CreativeTabs pdoxcore = new CreativeTabs("pdoxcore") {
        @Override
        public Item getTabIconItem() {
            return Items.IRON_INGOT;
        }
    };

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        ModBlocks.init();
        ModItems.init();

        proxy.registerRenders();
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){

    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
    }
}
