package realtech.items.tools;

import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WildWolf on 15/10/2016.
 */
public enum EnumToolSpecial {
    LEAD(0,ToolSpecialMaterial.lead, 8F, -3.3F, "Lead"),
    COPPER(1,ToolSpecialMaterial.copper, 7.8F, -2.9F, "Copper"),
    TIN(2,ToolSpecialMaterial.tin, 7.6F, -3.1F, "Tin");

    private static EnumToolSpecial[] COUNT_LOOKUP = new EnumToolSpecial[values().length];
    private static Map<String, EnumToolSpecial> lookup = new HashMap<String, EnumToolSpecial>();
    private Item.ToolMaterial material;
    private int count;
    private float axeDamage;
    private float axeSpeed;
    private String name;

    EnumToolSpecial(int count, Item.ToolMaterial material, float axeDamage, float axeSpeed, String name){
        this.material = material;
        this.count = count;
        this.axeDamage = axeDamage;
        this.axeSpeed = axeSpeed;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public float getAxeDamage() {
        return axeDamage;
    }

    public float getAxeSpeed() {
        return axeSpeed;
    }

    public String getName() {
        return name;
    }

    public Item.ToolMaterial getMaterial() {
        return material;
    }

    public static EnumToolSpecial byCount(int count){
        if (count < 0 || count >= COUNT_LOOKUP.length){
            count = 0;
        }

        return COUNT_LOOKUP[count];
    }

    public static EnumToolSpecial byName(String name){
        return lookup.get(name);
    }

    static {
        for(EnumToolSpecial armorSpecial : values()){
            COUNT_LOOKUP[armorSpecial.getCount()] = armorSpecial;
            lookup.put(armorSpecial.getName(), armorSpecial);
        }
    }

}
