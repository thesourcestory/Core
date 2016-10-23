package realtech.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import realtech.init.ModTools;
import realtech.items.ItemList;
import realtech.items.tools.EnumToolSpecial;

/**
 * Created by WildWolf on 19/10/2016.
 */
public class ToolRecipes extends Recipes{

    private static final String[][] recipePatterns = new String[][] {{"laxe", "XXX", "X# ", " # "},{"pickaxe", "XXX", " # ", " # "}, {"spade", "X", "#", "#"}, {"axe", "XX", "X#", " #"}, {"hoe", "XX", " #", " #"}, {"sword", "X", "X", "#"}};

    public static void register(){
        for (String[] string : recipePatterns) {
            String[] recipe = {string[1], string[2], string[3]};
            if(string[0] == "pickaxe"){
                for (int i = 0; i < EnumToolSpecial.values().length; i++) {
                    shaped(new ItemStack(ModTools.paxe[i]), recipe, 'X', ItemList.ingots[ItemList.Ingots.byName(EnumToolSpecial.byCount(i).getName()).getMeta()], '#', Items.STICK);
                }
            }
            if(string[0] == "spade"){
                for (int i = 0; i < EnumToolSpecial.values().length; i++) {
                    shaped(new ItemStack(ModTools.spade[i]), recipe, 'X', ItemList.ingots[ItemList.Ingots.byName(EnumToolSpecial.byCount(i).getName()).getMeta()], '#', Items.STICK);
                }
            }
            if(string[0] == "axe"){
                for (int i = 0; i < EnumToolSpecial.values().length; i++) {
                    shaped(new ItemStack(ModTools.axe[i]), recipe, 'X', ItemList.ingots[ItemList.Ingots.byName(EnumToolSpecial.byCount(i).getName()).getMeta()], '#', Items.STICK);
                }
            }
            if(string[0] == "hoe"){
                for (int i = 0; i < EnumToolSpecial.values().length; i++) {
                    shaped(new ItemStack(ModTools.hoe[i]), recipe, 'X', ItemList.ingots[ItemList.Ingots.byName(EnumToolSpecial.byCount(i).getName()).getMeta()], '#', Items.STICK);
                }
            }
            if(string[0] == "sword"){
                for (int i = 0; i < EnumToolSpecial.values().length; i++) {
                    shaped(new ItemStack(ModTools.swords[i]), recipe, 'X', ItemList.ingots[ItemList.Ingots.byName(EnumToolSpecial.byCount(i).getName()).getMeta()], '#', Items.STICK);
                }
            }
            if(string[0] == "laxe"){
                for (int i = 0; i < EnumToolSpecial.values().length; i++) {
                    shaped(new ItemStack(ModTools.laxe[i]), recipe, 'X', ItemList.ingots[ItemList.Ingots.byName(EnumToolSpecial.byCount(i).getName()).getMeta()], '#', Items.STICK);
                }
            }
        }
    }

}
