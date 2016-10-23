package realtech.items.tools;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import realtech.init.Realtech;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WildWolf on 20/10/2016.
 */
public class ItemLumberAxe extends ItemAxe {

    public ItemLumberAxe(ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);
        this.setCreativeTab(Realtech.realtechtoolsandarmor);
        this.setUnlocalizedName(material.name() + "laxe");
        this.setMaxDamage(material.getMaxUses() * 3);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        Map<Integer, BlockPos> temp;
        Map<Integer, BlockPos> temp2 = new HashMap<Integer, BlockPos>();
        Map<Integer, BlockPos> temp3 = new HashMap<Integer, BlockPos>();
        int howMany = 0;
        boolean finished = false;
        boolean triggered = false;
        temp = getPosibleCoords(pos);
        for (int i = 0; i < temp.size(); i++) {
            if (worldIn.getBlockState(temp.get(i)).getBlock() == Blocks.LOG || worldIn.getBlockState(temp.get(i)).getBlock() == Blocks.LOG2)
                if (!temp2.containsValue(temp.get(i)) && !temp3.containsValue(temp.get(i)))
                    temp2 = getPosibleCoords(temp.get(i));
        }
        temp3 = getPosibleCoords(temp, temp2);
        while (!finished) {
            for (int i = 0; i < temp3.size(); i++) {
                if (worldIn.getBlockState(temp3.get(i)).getBlock() == Blocks.LOG || worldIn.getBlockState(temp3.get(i)).getBlock() == Blocks.LOG2) {
                    temp = getPosibleCoords(temp3.get(i));
                    for (int z = 0; z < temp.size(); z++) {
                        if (worldIn.getBlockState(temp.get(z)).getBlock() == Blocks.LOG || worldIn.getBlockState(temp.get(z)).getBlock() == Blocks.LOG2)
                            if (!temp2.containsValue(temp.get(z)) && !temp3.containsValue(temp.get(z))) {
                                temp2 = getPosibleCoords(temp.get(z));
                                triggered = true;
                            }
                    }
                    for (int j = 0; j < temp2.size(); j++) {
                        if(!temp3.containsValue(temp2.get(j))){
                            temp3.put(temp3.size(), temp2.get(j));
                        }
                    }
                }
            }
            if (!triggered) {
                finished = true;
            }
            triggered = false;
        }
        for (int i = 0; i < temp3.size(); i++) {
            if (worldIn.getBlockState(temp3.get(i)).getBlock() == Blocks.LOG || worldIn.getBlockState(temp3.get(i)).getBlock() == Blocks.LOG2) {
                worldIn.destroyBlock(temp3.get(i), true);
                howMany++;
            }
        }
        stack.damageItem(howMany, entityLiving);
        return false;
    }

    public static Map<Integer, BlockPos> getPosibleCoords(BlockPos pos) {
        Map<Integer, BlockPos> blockPoses = new HashMap<Integer, BlockPos>();
        blockPoses.clear();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    blockPoses.put(blockPoses.size(), new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z));
                }
            }
        }
        return blockPoses;
    }

    public static Map<Integer, BlockPos> getPosibleCoords
            (Map<Integer, BlockPos> blockPosMap1, Map<Integer, BlockPos> blockPosMap2) {
        Map<Integer, BlockPos> blockPoses = new HashMap<Integer, BlockPos>();
        for (int i = 0; i < blockPosMap1.size(); i++) {
            if (!blockPosMap2.containsValue(blockPosMap1.get(i)))
                blockPoses.put(blockPoses.size(), blockPosMap1.get(i));
        }
        for (int i = 0; i < blockPosMap2.size(); i++) {
            if (!blockPoses.containsValue(blockPosMap2.get(i)))
                blockPoses.put(blockPoses.size(), blockPosMap2.get(i));
        }
        return blockPoses;
    }

}
