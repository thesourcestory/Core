package pdoxcore.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import pdoxcore.init.PdoxCore;
import pdoxcore.test.IMetaBlockName;

import java.util.List;

/**
 * Created by magnus97 on 15/08/2016.
 */
public class Ores1 extends Block implements IMetaBlockName{

    public Ores1(Material blockMaterialIn, float hardness, float resistance) {
        super(blockMaterialIn);
        this.setResistance(resistance);
        this.setHardness(hardness);
        this.setCreativeTab(PdoxCore.pdoxcore);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, Ores.Ores1Types.ACANTHITE));
    }
    
    public static final PropertyEnum TYPE = PropertyEnum.create("type", Ores.Ores1Types.class);

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] { TYPE });
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        switch (meta){
            case 1:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.BARITE);
            case 2:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.BAUXITE);
            case 3:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.BERYL);
            case 4:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.BORNITE);
            case 5:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.CASSITERITE);
            case 6:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.CHALCOCITE);
            case 7:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.CHALCOPYRITE);
            case 8:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.CHROMITE);
            case 9:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.CINNABAR);
            case 10:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.COBALTITE);
            case 11:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.COLUMBITE);
            case 12:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.TANTALITE);
            case 13:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.DOLOMITE);
            case 14:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.GALENA);
            case 15:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.HEMATITE);
            default:
                return getDefaultState().withProperty(TYPE, Ores.Ores1Types.ACANTHITE);
        }
    }

    @Override
    public int getMetaFromState(IBlockState state){
        Ores.Ores1Types type = (Ores.Ores1Types) state.getValue(TYPE);
        return type.getID();
    }

    @Override
    public int damageDropped(IBlockState state){
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 0; i < 16; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        switch (stack.getItemDamage()){
            case 1:
                return Ores.Ores1Types.BARITE.getName();
            case 2:
                return Ores.Ores1Types.BAUXITE.getName();
            case 3:
                return Ores.Ores1Types.BERYL.getName();
            case 4:
                return Ores.Ores1Types.BORNITE.getName();
            case 5:
                return Ores.Ores1Types.CASSITERITE.getName();
            case 6:
                return Ores.Ores1Types.CHALCOCITE.getName();
            case 7:
                return Ores.Ores1Types.CHALCOPYRITE.getName();
            case 8:
                return Ores.Ores1Types.CHROMITE.getName();
            case 9:
                return Ores.Ores1Types.CINNABAR.getName();
            case 10:
                return Ores.Ores1Types.COBALTITE.getName();
            case 11:
                return Ores.Ores1Types.COLUMBITE.getName();
            case 12:
                return Ores.Ores1Types.TANTALITE.getName();
            case 13:
                return Ores.Ores1Types.DOLOMITE.getName();
            case 14:
                return Ores.Ores1Types.GALENA.getName();
            case 15:
                return Ores.Ores1Types.HEMATITE.getName();
            default:
                return Ores.Ores1Types.ACANTHITE.getName();
        }
    }
}
