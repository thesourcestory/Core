package pdox.core.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by magnus97 on 22/05/2016.
 */
public class ModItems {
    
    public static void init(){

    }

    public static void reg(Item item, String unlocalizedName){
        item.setUnlocalizedName(unlocalizedName);
        GameRegistry.registerItem(item, unlocalizedName);
    }

}
