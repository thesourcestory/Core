package realtech.items.armor;

import net.minecraft.item.ItemArmor;

/**
 * Created by WildWolf on 11/10/2016.
 */
public enum EnumArmorSpecial {
    LEAD(0, ArmorSpecialMaterial.lead);

    private static EnumArmorSpecial[] COUNT_LOOKUP = new EnumArmorSpecial[values().length];
    private ItemArmor.ArmorMaterial material;
    private int count;

    EnumArmorSpecial(int count, ItemArmor.ArmorMaterial material){
        this.material = material;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public ItemArmor.ArmorMaterial getMaterial() {
        return material;
    }

    public static EnumArmorSpecial byCount(int count){
        if (count < 0 || count >= COUNT_LOOKUP.length){
            count = 0;
        }

        return COUNT_LOOKUP[count];
    }

    static {
        for(EnumArmorSpecial armorSpecial : values()){
            COUNT_LOOKUP[armorSpecial.getCount()] = armorSpecial;
        }
    }
}
