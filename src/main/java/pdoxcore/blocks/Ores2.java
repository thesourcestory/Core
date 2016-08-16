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
import pdoxcore.interfaces.IMetaBlockName;

import java.util.List;

/**
 * Created by magnus97 on 15/08/2016.
 */
public class Ores2 extends Block implements IMetaBlockName{

    public Ores2(Material blockMaterialIn, float hardness, float resistance) {
        super(blockMaterialIn);
        this.setResistance(resistance);
        this.setHardness(hardness);
        this.setCreativeTab(PdoxCore.pdoxcore);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, Ores.Ores2Types.ILMENITE));
    }

    public static final PropertyEnum TYPE = PropertyEnum.create("type", Ores.Ores2Types.class);

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] { TYPE });
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        switch (meta){
            case 1:
                return getDefaultState().withProperty(TYPE, Ores.Ores2Types.MAGNETITE);
            case 2:
                return getDefaultState().withProperty(TYPE, Ores.Ores2Types.MALACHITE);
            case 3:
                return getDefaultState().withProperty(TYPE, Ores.Ores2Types.MOLYBDENITE);
            case 4:
                return getDefaultState().withProperty(TYPE, Ores.Ores2Types.PENTALANDITE);
            case 5:
                return getDefaultState().withProperty(TYPE, Ores.Ores2Types.PYROLUSITE);
            case 6:
                return getDefaultState().withProperty(TYPE, Ores.Ores2Types.SCHEELITE);
            case 7:
                return getDefaultState().withProperty(TYPE, Ores.Ores2Types.SPERRYLITE);
            case 8:
                return getDefaultState().withProperty(TYPE, Ores.Ores2Types.PSHALERITE);
            case 9:
                return getDefaultState().withProperty(TYPE, Ores.Ores2Types.URANINITE);
            case 10:
                return getDefaultState().withProperty(TYPE, Ores.Ores2Types.WOLFRAMITE);
            default:
                return getDefaultState().withProperty(TYPE, Ores.Ores2Types.ILMENITE);
        }
    }

    @Override
    public int getMetaFromState(IBlockState state){
        Ores.Ores2Types type = (Ores.Ores2Types) state.getValue(TYPE);
        return type.getID();
    }

    @Override
    public int damageDropped(IBlockState state){
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 0; i < 11; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        switch (stack.getItemDamage()){
            case 1:
                return Ores.Ores2Types.MAGNETITE.getName();
            case 2:
                return Ores.Ores2Types.MALACHITE.getName();
            case 3:
                return Ores.Ores2Types.MOLYBDENITE.getName();
            case 4:
                return Ores.Ores2Types.PENTALANDITE.getName();
            case 5:
                return Ores.Ores2Types.PYROLUSITE.getName();
            case 6:
                return Ores.Ores2Types.SCHEELITE.getName();
            case 7:
                return Ores.Ores2Types.SPERRYLITE.getName();
            case 8:
                return Ores.Ores2Types.PSHALERITE.getName();
            case 9:
                return Ores.Ores2Types.URANINITE.getName();
            case 10:
                return Ores.Ores2Types.WOLFRAMITE.getName();
            default:
                return Ores.Ores2Types.ILMENITE.getName();
        }
    }
}
