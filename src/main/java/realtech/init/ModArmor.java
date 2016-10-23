package realtech.init;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import static realtech.init.ModItems.helper;
import realtech.items.armor.EnumArmorSpecial;
import realtech.items.armor.ItemArmorSpecial;

/**
 * Created by WildWolf on 15/10/2016.
 */
public class ModArmor{

    public static Item[] chestplates = new Item[EnumArmorSpecial.values().length];
    public static Item[] legplates = new Item[EnumArmorSpecial.values().length];
    public static Item[] feetplates = new Item[EnumArmorSpecial.values().length];
    public static Item[] headplates = new Item[EnumArmorSpecial.values().length];

    public static void init(){
        for (int i = 0; i < chestplates.length; i++) {
            helper.registerItem(chestplates[i], chestplates[i].getUnlocalizedName().substring(5));
            helper.registerItem(legplates[i], legplates[i].getUnlocalizedName().substring(5));
            helper.registerItem(feetplates[i], feetplates[i].getUnlocalizedName().substring(5));
            helper.registerItem(headplates[i], headplates[i].getUnlocalizedName().substring(5));
        }
    }

    static {
        for (int i = 0; i < EnumArmorSpecial.values().length; i++){
            chestplates[i] = new ItemArmorSpecial(EnumArmorSpecial.byCount(i).getMaterial(), 2, EntityEquipmentSlot.CHEST);
            legplates[i] = new ItemArmorSpecial(EnumArmorSpecial.byCount(i).getMaterial(), 2, EntityEquipmentSlot.LEGS);
            feetplates[i] = new ItemArmorSpecial(EnumArmorSpecial.byCount(i).getMaterial(), 2, EntityEquipmentSlot.FEET);
            headplates[i] = new ItemArmorSpecial(EnumArmorSpecial.byCount(i).getMaterial(), 2, EntityEquipmentSlot.HEAD);
        }
    }

}
