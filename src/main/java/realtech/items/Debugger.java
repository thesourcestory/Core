package realtech.items;

import net.minecraft.block.*;
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
import realtech.util.ModLogger;
import realtech.util.References;

/**
 * Created by WildWolf on 16/08/2016.
 */
public class Debugger extends Item {

    private static ModLogger logger = new ModLogger(References.Mod.MODID);

    public Debugger(){

    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(!worldIn.isRemote) {
            logger.info("Server starting on setting blocks");
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
                        IBlockState stone = Blocks.STONE.getDefaultState();
                        IBlockState granite = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE);
                        IBlockState diorite = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE);
                        IBlockState andesite = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE);
                        IBlockState dirt = Blocks.DIRT.getDefaultState();
                        IBlockState grass = Blocks.GRASS.getDefaultState();
                        IBlockState gravel = Blocks.GRAVEL.getDefaultState();
                        IBlockState snow = Blocks.SNOW_LAYER.getDefaultState();
                        IBlockState iron = Blocks.IRON_ORE.getDefaultState();
                        IBlockState gold = Blocks.GOLD_ORE.getDefaultState();
                        IBlockState lapis = Blocks.LAPIS_ORE.getDefaultState();
                        IBlockState coal = Blocks.COAL_ORE.getDefaultState();
                        IBlockState diamond = Blocks.DIAMOND_ORE.getDefaultState();
                        IBlockState sand = Blocks.SAND.getDefaultState();
                        IBlockState clay = Blocks.CLAY.getDefaultState();
                        IBlockState sandstone = Blocks.SANDSTONE.getDefaultState();
                        IBlockState fern = Blocks.TALLGRASS.getStateFromMeta(2);
                        IBlockState tallgrass = Blocks.TALLGRASS.getStateFromMeta(1);
                        IBlockState deadbush = Blocks.TALLGRASS.getStateFromMeta(0);
                        for(int c = 0; c < BlockPlanks.EnumType.values().length -2; c++) {
                            IBlockState wood = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.byMetadata(c));
                            IBlockState leaves = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.byMetadata(c));
                            for(int v = 0; v < 16; v++) {
                                IBlockState water = Blocks.WATER.getStateFromMeta(v);
                                IBlockState lava = Blocks.LAVA.getStateFromMeta(v);
                                if ((worldIn.getBlockState(blockPos) == fern || worldIn.getBlockState(blockPos) == tallgrass || worldIn.getBlockState(blockPos) == deadbush || worldIn.getBlockState(blockPos) == sandstone || worldIn.getBlockState(blockPos) == sand || worldIn.getBlockState(blockPos) == clay || worldIn.getBlockState(blockPos) == iron || worldIn.getBlockState(blockPos) == gold || worldIn.getBlockState(blockPos) == lapis || worldIn.getBlockState(blockPos) == coal || worldIn.getBlockState(blockPos) == diamond || worldIn.getBlockState(blockPos) == stone || worldIn.getBlockState(blockPos) == leaves || worldIn.getBlockState(blockPos) == wood || worldIn.getBlockState(blockPos) == snow || worldIn.getBlockState(blockPos) == water || worldIn.getBlockState(blockPos) == lava || worldIn.getBlockState(blockPos) == granite || worldIn.getBlockState(blockPos) == diorite || worldIn.getBlockState(blockPos) == andesite || worldIn.getBlockState(blockPos) == dirt || worldIn.getBlockState(blockPos) == grass || worldIn.getBlockState(blockPos) == gravel) && worldIn.getBlockState(blockPos) != air) {
                                    worldIn.setBlockState(blockPos, air, 2);
                                    worldIn.notifyBlockUpdate(blockPos, old, air, 2);
                                }
                            }
                        }
                    }
                }
            }
            logger.info("Done setting blocks");
        }
        return EnumActionResult.PASS;
    }

}
