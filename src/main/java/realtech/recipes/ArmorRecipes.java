package realtech.recipes;

import net.minecraft.item.ItemStack;
import realtech.init.ModItems;
import realtech.items.ModArmor;

/**
 * Created by WildWolf on 19/10/2016.
 */
public class ArmorRecipes extends Recipes {

    public static void register(){
        shaped(new ItemStack(ModArmor.chestplates[0]), "x x", "xxx", "xxx", 'x', new ItemStack(ModItems.ingots, 1, 50));
        shaped(new ItemStack(ModArmor.legplates[0]), "xxx", "x x", "x x", 'x', new ItemStack(ModItems.ingots, 1, 50));
        shaped(new ItemStack(ModArmor.headplates[0]), "xxx", "x x", 'x', new ItemStack(ModItems.ingots, 1, 50));
        shaped(new ItemStack(ModArmor.feetplates[0]), "x x", "x x", 'x', new ItemStack(ModItems.ingots, 1, 50));
    }

}
