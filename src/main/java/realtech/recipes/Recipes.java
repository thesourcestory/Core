package realtech.recipes;

import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import realtech.init.ModItems;
import realtech.items.ItemList;
import realtech.items.ModArmor;

/**
 * Created by WildWolf on 29/08/2016.
 */
public class Recipes {

    public static void smelting(ItemStack in, ItemStack out, float xp){
        GameRegistry.addSmelting(in, out, xp);
    }

    public static void shapeless(ItemStack out, Object... in){
        GameRegistry.addShapelessRecipe(out, in);
    }

    public static void shaped(ItemStack out, Object... in){
        GameRegistry.addRecipe(out, in);
    }

    public static void register(){
        ArmorRecipes.register();
        SmeltingRecipes.register();
        ToolRecipes.register();
    }

}
