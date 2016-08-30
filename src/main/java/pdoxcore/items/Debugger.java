package pdoxcore.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pdoxcore.blocks.*;
import pdoxcore.blocks.Ores;
import pdoxcore.init.ModBlocks;

/**
 * Created by WildWolf on 16/08/2016.
 */
public class Debugger extends Item {

    public Debugger(){

    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(worldIn.isRemote) {
            System.out.println(pos);
        }
        if(!worldIn.isRemote) {
            System.out.println("Is server starting on setting blocks");
            for(int i = -75; i <= 75; i++){
                for(int j = 2; j <= 255; j++){
                    for (int k = -75; k <= 75; k++){
                        int x = pos.getX();
                        int y = j;
                        int z = pos.getZ();
                        z += k;
                        x += i;
                        BlockPos blockPos = new BlockPos(x,y,z);
                        IBlockState old = worldIn.getBlockState(blockPos);
                        IBlockState air = Blocks.AIR.getDefaultState();
                        IBlockState ore = ModBlocks.ores[7].getDefaultState();
                        if(worldIn.getBlockState(blockPos) != ore && worldIn.getBlockState(blockPos) != air) {
                            worldIn.setBlockState(blockPos, air, 2);
                            worldIn.notifyBlockUpdate(blockPos, old, air, 2);
                        }
                    }
                }
            }
            System.out.println("Done setting blocks");
        }
        return EnumActionResult.PASS;
    }

}
