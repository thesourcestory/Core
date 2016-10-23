package realtech.recipes;

/**
 * Created by WildWolf on 19/10/2016.
 */
public class ToolRecipes extends Recipes{

    private static final String[][] recipePatterns = new String[][] {{"pickaxe", "XXX", " # ", " # "}, {"spade", "X", "#", "#"}, {"axe", "XX", "X#", " #"}, {"hoe", "XX", " #", " #"}, {"sword", "X", "X", "#"}};

    public static void register(){
        for (String[] string : recipePatterns) {
            if(string[0] == "pickaxe"){
                //shaped(new ItemStack(ModTools.paxe[]));
            }
            if(string[0] == "spade"){

            }
            if(string[0] == "axe"){

            }
            if(string[0] == "hoe"){

            }
            if(string[0] == "sword"){

            }
        }
    }

}
