package pdoxcore.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by magnus97 on 16/08/2016.
 */
public class Debugger extends Item {

    public Debugger(){

    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(worldIn.isRemote) {
            Block block = worldIn.getBlockState(pos).getBlock();
            System.out.println(block.getUnlocalizedName());
            System.out.println(block);
        }
        return EnumActionResult.PASS;
    }

}
