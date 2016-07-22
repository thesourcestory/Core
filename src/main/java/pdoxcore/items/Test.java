package pdoxcore.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pdoxcore.blocks.ModBlocks;

/**
 * Created by magnus97 on 27/06/2016.
 */
public class Test extends Item {

    public Test(){
        this.setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            System.out.print(stack);
            System.out.print(", ");
            System.out.print(playerIn);
            System.out.print(", ");
            System.out.print(worldIn);
            System.out.print(", ");
            System.out.print(pos);
            System.out.print(", ");
            System.out.print(hand);
            System.out.print(", ");
            System.out.print(facing);
            System.out.print(", ");
            System.out.print(hitX);
            System.out.print(", ");
            System.out.print(hitY);
            System.out.print(", ");
            System.out.println(hitZ);
            if(worldIn.getBlockState(pos) == ModBlocks.test.getDefaultState()){
                BlockPos pos1 = new BlockPos(playerIn.getPosition().getX(), playerIn.getPosition().getY() + 20, playerIn.getPosition().getZ());
                worldIn.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState());
                worldIn.setBlockState(pos1, Blocks.ANVIL.getDefaultState());
            }
        }
        return super.onItemUse(stack, playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }
}
