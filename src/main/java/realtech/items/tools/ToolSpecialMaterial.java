package realtech.items.tools;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by WildWolf on 15/10/2016.
 */
public class ToolSpecialMaterial {

    public static Item.ToolMaterial lead = ToolSpecialMaterial("lead", 2, 290, 3.0F, 2.0F, 5);
    public static Item.ToolMaterial copper = ToolSpecialMaterial("copper", 2, 350, 4.0F, 2.5F, 10);
    public static Item.ToolMaterial tin = ToolSpecialMaterial("tin", 2, 250, 4.0F, 2.5F, 10);

    public static Item.ToolMaterial ToolSpecialMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability){
        return EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability);
    }

}
