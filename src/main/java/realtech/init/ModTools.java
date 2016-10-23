package realtech.init;

import net.minecraft.item.Item;
import realtech.items.tools.*;

import static realtech.init.ModItems.helper;

/**
 * Created by WildWolf on 15/10/2016.
 */
public class ModTools {

    public static Item[] swords = new Item[EnumToolSpecial.values().length];
    public static Item[] axe = new Item[EnumToolSpecial.values().length];
    public static Item[] paxe = new Item[EnumToolSpecial.values().length];
    public static Item[] spade = new Item[EnumToolSpecial.values().length];
    public static Item[] hoe = new Item[EnumToolSpecial.values().length];
    public static Item[] laxe = new Item[EnumToolSpecial.values().length];

    public static void init(){
        for (int i = 0; i < EnumToolSpecial.values().length; i++) {
            helper.registerItem(swords[i], swords[i].getUnlocalizedName().substring(5));
            helper.registerItem(axe[i], axe[i].getUnlocalizedName().substring(5));
            helper.registerItem(paxe[i], paxe[i].getUnlocalizedName().substring(5));
            helper.registerItem(spade[i], spade[i].getUnlocalizedName().substring(5));
            helper.registerItem(hoe[i], hoe[i].getUnlocalizedName().substring(5));
            helper.registerItem(laxe[i], laxe[i].getUnlocalizedName().substring(5));
        }
    }

    static {
        for (int i = 0; i < EnumToolSpecial.values().length; i++) {
            swords[i] = new ItemSwordSpecial(EnumToolSpecial.byCount(i).getMaterial());
            axe[i] = new ItemAxeSpecial(EnumToolSpecial.byCount(i).getMaterial(), EnumToolSpecial.byCount(i).getAxeDamage() ,EnumToolSpecial.byCount(i).getAxeSpeed());
            paxe[i] = new ItemPickaxeSpecial(EnumToolSpecial.byCount(i).getMaterial());
            spade[i] = new ItemSpadeSpecial(EnumToolSpecial.byCount(i).getMaterial());
            hoe[i] = new ItemHoeSpecial(EnumToolSpecial.byCount(i).getMaterial());
            laxe[i] = new ItemLumberAxe(EnumToolSpecial.byCount(i).getMaterial(), EnumToolSpecial.byCount(i).getAxeDamage() ,EnumToolSpecial.byCount(i).getAxeSpeed());
        }
    }

}
