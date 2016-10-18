package realtech.items.tools;

import net.minecraft.item.Item;

/**
 * Created by WildWolf on 15/10/2016.
 */
public enum EnumToolSpecial {
    LEAD(0,ToolSpecialMaterial.lead, 8F, -3.1F);

    private static EnumToolSpecial[] COUNT_LOOKUP = new EnumToolSpecial[values().length];
    private Item.ToolMaterial material;
    private int count;
    private float axeDamage;
    private float axeSpeed;

    EnumToolSpecial(int count, Item.ToolMaterial material, float axeDamage, float axeSpeed){
        this.material = material;
        this.count = count;
        this.axeDamage = axeDamage;
        this.axeSpeed = axeSpeed;
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

    public Item.ToolMaterial getMaterial() {
        return material;
    }

    public static EnumToolSpecial byCount(int count){
        if (count < 0 || count >= COUNT_LOOKUP.length){
            count = 0;
        }

        return COUNT_LOOKUP[count];
    }

    static {
        for(EnumToolSpecial armorSpecial : values()){
            COUNT_LOOKUP[armorSpecial.getCount()] = armorSpecial;
        }
    }

}
