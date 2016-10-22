package realtech.items.tools;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import realtech.init.Realtech;
import realtech.items.ModTools;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 * Created by WildWolf on 15/10/2016.
 */
public class ItemAxeSpecial extends ItemAxe {

    private Random random = new Random();

    public ItemAxeSpecial(ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);
        this.setCreativeTab(Realtech.pdoxcoretoolsandarmor);
        this.setUnlocalizedName(material.name() + "axe");
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        if (attacker.getHeldItemMainhand() != null)
            if (attacker.getHeldItemMainhand().getItem() == ModTools.axe[0])
                if (target instanceof EntityPlayerSP || target instanceof EntityAgeable) {
                    int rnxi = random.nextInt(2);
                    if (rnxi == 1)
                        target.addPotionEffect(new PotionEffect(MobEffects.POISON, 100 + (random.nextInt(10) * 20), 1));
                    else if (rnxi == 1)
                        target.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 20 + (random.nextInt(5) * 20), 0));
                }
        return true;
    }

/*    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        Map<Integer, BlockPos> temp;
        Map<Integer, BlockPos> temp2 = new HashMap<Integer, BlockPos>();
        Map<Integer, BlockPos> temp3 = new HashMap<Integer, BlockPos>();
        Map<Integer, BlockPos> temp4;
        int howMany = 0;
        boolean finished = false;
        boolean triggered = false;
        temp = getPosibleCoords(pos);
        for(int i = 0; i < temp.size(); i++){
            if(worldIn.getBlockState(temp.get(i)).getBlock() == Blocks.LOG || worldIn.getBlockState(temp.get(i)).getBlock() == Blocks.LOG2)
                if(!temp2.containsValue(temp.get(i)) && !temp3.containsValue(temp.get(i)))
                    temp2 = getPosibleCoords(temp.get(i));
        }
        temp3 = getPosibleCoords(temp, temp2);
        while (!finished) {
            for (int i = 0; i < temp.size(); i++) {
                if (worldIn.getBlockState(temp.get(i)).getBlock() == Blocks.LOG || worldIn.getBlockState(temp.get(i)).getBlock() == Blocks.LOG2)
                    if (!temp2.containsValue(temp.get(i)) && !temp3.containsValue(temp.get(i))) {
                        temp2 = getPosibleCoords(temp.get(i));
                        triggered = true;
                    }
            }
            temp4 = temp3;
            temp3 = getPosibleCoords(temp, temp2);
            temp3 = getPosibleCoords(temp3, temp4);
            if (!triggered) {
                finished = true;
            }
            triggered = false;
        }
        for(int i = 0; i < temp3.size(); i++){
            if(worldIn.getBlockState(temp3.get(i)).getBlock() == Blocks.LOG || worldIn.getBlockState(temp3.get(i)).getBlock() == Blocks.LOG2){
                worldIn.destroyBlock(temp3.get(i), true);
                howMany++;
            }
        }
        stack.damageItem(howMany, entityLiving);
        return false;
    }

    public static Map<Integer, BlockPos> getPosibleCoords(BlockPos pos){
        Map<Integer, BlockPos> blockPoses = new HashMap<Integer, BlockPos>();
        blockPoses.clear();
        for(int x = -1; x <= 1; x++){
            for (int y = -1; y <= 1; y++){
                for (int z = -1; z <= 1; z++){
                    blockPoses.put(blockPoses.size(), new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z));
                }
            }
        }
        return blockPoses;
    }

    public static Map<Integer, BlockPos> getPosibleCoords(Map<Integer, BlockPos> blockPosMap1, Map<Integer, BlockPos> blockPosMap2){
        Map<Integer,BlockPos> blockPoses = new HashMap<Integer, BlockPos>();
        for (int i = 0; i < blockPosMap1.size(); i++) {
            if(!blockPosMap2.containsValue(blockPosMap1.get(i)))
                blockPoses.put(blockPoses.size(), blockPosMap1.get(i));
        }
        for (int i = 0; i < blockPosMap2.size(); i++){
            if(!blockPoses.containsValue(blockPosMap2.get(i)))
                blockPoses.put(blockPoses.size(), blockPosMap2.get(i));
        }
        return blockPoses;
    }//*/
}
