package realtech.items.armor;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import realtech.init.Realtech;
import realtech.items.ModArmor;

import java.util.Random;

/**
 * Created by WildWolf on 11/10/2016.
 */
public class ItemArmorSpecial extends ItemArmor {

    public String armor;
    private Random random = new Random();

    public ItemArmorSpecial(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.armor = materialIn.getName();
        this.setUnlocalizedName(materialIn.getName() + equipmentSlotIn.getName());
        this.setCreativeTab(Realtech.pdoxcoretoolsandarmor);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (!event.getEntity().getEntityWorld().isRemote) {
            EntityLivingBase base = (EntityLivingBase) event.getEntity();
            if (getHowMany(1, base) || getHowMany(2, base) || getHowMany(3, base) || getHowMany(4, base)) {
                int rnxi = random.nextInt(100);
                if (rnxi > 60 && !base.isPotionActive(MobEffects.POISON) && !base.isPotionActive(MobEffects.BLINDNESS)) {
                    if (base instanceof EntityZombie) {
                        if (!base.isPotionActive(MobEffects.REGENERATION)) {
                            int armorpeaces = 0;
                            for (int i = 1; i < 5; i++) {
                                if (getHowMany(i, base)) {
                                    armorpeaces++;
                                }
                            }
                            rnxi = random.nextInt(10);
                            if (rnxi == 1) {
                                if (base instanceof EntitySkeleton || base instanceof EntityZombie)
                                    base.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, (100 + (random.nextInt(10) * 20)) * armorpeaces, 1));
                                else
                                    base.addPotionEffect(new PotionEffect(MobEffects.POISON, (100 + (random.nextInt(10) * 20)) * armorpeaces, 1));
                            } else if (rnxi == 2)
                                base.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (20 + (random.nextInt(5) * 20)) * armorpeaces, 0));
                        }
                    } else {
                        if (this.armor == "lead") {
                            int armorpeaces = 0;
                            for (int i = 1; i < 5; i++) {
                                if (getHowMany(i, base)) {
                                    armorpeaces++;
                                }
                            }
                            rnxi = random.nextInt(10);
                            if (rnxi == 1) {
                                if (base instanceof EntitySkeleton || base instanceof EntityZombie)
                                    base.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, (100 + (random.nextInt(10) * 20)) * armorpeaces, 1));
                                else
                                    base.addPotionEffect(new PotionEffect(MobEffects.POISON, (100 + (random.nextInt(10) * 20)) * armorpeaces, 1));
                            } else if (rnxi == 2)
                                base.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (20 + (random.nextInt(5) * 20)) * armorpeaces, 0));
                            else if (rnxi == 3 && armorpeaces == 4)
                                base.addPotionEffect(new PotionEffect(MobEffects.WITHER, (20 + (random.nextInt(5) * 20)) * armorpeaces, 0));
                        }
                    }
                }
            }
        }
    }

    private boolean getHowMany(int i, EntityLivingBase base) {
        if (i == 1)
            if (base.getItemStackFromSlot(EntityEquipmentSlot.HEAD) != null)
                if (base.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModArmor.headplates[0])
                    return true;
        if (i == 2)
            if (base.getItemStackFromSlot(EntityEquipmentSlot.FEET) != null)
                if (base.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModArmor.feetplates[0])
                    return true;
        if (i == 3)
            if (base.getItemStackFromSlot(EntityEquipmentSlot.CHEST) != null)
                if (base.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModArmor.chestplates[0])
                    return true;
        if (i == 4)
            if (base.getItemStackFromSlot(EntityEquipmentSlot.LEGS) != null)
                if (base.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModArmor.legplates[0])
                    return true;
        return false;
    }
}
