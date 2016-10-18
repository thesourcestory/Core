package realtech.items.tools;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import realtech.init.Realtech;
import realtech.items.ModTools;

import java.util.Random;

/**
 * Created by WildWolf on 15/10/2016.
 */
public class ItemPickaxeSpecial extends ItemPickaxe{

    private Random random = new Random();

    public ItemPickaxeSpecial(ToolMaterial material) {
        super(material);
        this.setCreativeTab(Realtech.pdoxcoretoolsandarmor);
        this.setUnlocalizedName(material.name() + "paxe");
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        if (attacker.getHeldItemMainhand() != null)
            if (attacker.getHeldItemMainhand().getItem() == ModTools.paxe[0])
                if (target instanceof EntityPlayerSP || target instanceof EntityAgeable) {
                    int rnxi = random.nextInt(2);
                    if (rnxi == 1)
                        target.addPotionEffect(new PotionEffect(MobEffects.POISON, 100 + (random.nextInt(10) * 20), 1));
                    else if (rnxi == 1)
                        target.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 20 + (random.nextInt(5) * 20), 0));
                }
        return true;
    }

}
