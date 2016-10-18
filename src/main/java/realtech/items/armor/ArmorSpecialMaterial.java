package realtech.items.armor;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by WildWolf on 12/10/2016.
 */
public class ArmorSpecialMaterial {

    public static ItemArmor.ArmorMaterial lead = ArmourSpecial("lead", "lead", 15, new int[]{2,5,6,2}, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F);

    public static ItemArmor.ArmorMaterial ArmourSpecial(String name, String textureName, int durability, int[] reductionAmounts, int enchantability, SoundEvent soundOnEquip, float toughness){
        return EnumHelper.addArmorMaterial(name, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness);
    }
}
