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
import pdoxcore.init.ModItems;
import pdoxcore.init.PdoxCore;
import pdoxcore.items.EnumOreChunk;
import pdoxcore.stuff.IMetaBlockName;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * Created by WildWolf on 15/08/2016.
 */
public class Ores1 extends Block implements IMetaBlockName{

    public Ores1(Material blockMaterialIn, float hardness, float resistance) {
        super(blockMaterialIn);
        this.setResistance(resistance);
        this.setHardness(hardness);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(PdoxCore.pdoxcoreores);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, Ores.Ore1Types.ACANTHITE));
    }
    
    public static final PropertyEnum TYPE = PropertyEnum.create("type", Ores.Ore1Types.class);

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] { TYPE });
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        switch (meta){
            case 1:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.BARITE);
            case 2:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.BAUXITE);
            case 3:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.BERYL);
            case 4:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.BORNITE);
            case 5:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.CASSITERITE);
            case 6:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.CHALCOCITE);
            case 7:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.CHALCOPYRITE);
            case 8:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.CHROMITE);
            case 9:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.CINNABAR);
            case 10:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.COBALTITE);
            case 11:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.COLUMBITE);
            case 12:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.TANTALITE);
            case 13:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.DOLOMITE);
            case 14:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.GALENA);
            case 15:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.HEMATITE);
            default:
                return getDefaultState().withProperty(TYPE, Ores.Ore1Types.ACANTHITE);
        }
    }

    @Override
    public int getMetaFromState(IBlockState state){
        Ores.Ore1Types type = (Ores.Ore1Types) state.getValue(TYPE);
        return type.getID();
    }

    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.orechunk;
    }

    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(4);
    }

    @Override
    public int damageDropped(IBlockState state){
        return EnumOreChunk.byMetadata(getMetaFromState(state) + Ores.OreTypes.values().length).getMeta();
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 0; i < TYPE.getAllowedValues().toArray().length; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        switch (stack.getItemDamage()){
            case 1:
                return Ores.Ore1Types.BARITE.getName();
            case 2:
                return Ores.Ore1Types.BAUXITE.getName();
            case 3:
                return Ores.Ore1Types.BERYL.getName();
            case 4:
                return Ores.Ore1Types.BORNITE.getName();
            case 5:
                return Ores.Ore1Types.CASSITERITE.getName();
            case 6:
                return Ores.Ore1Types.CHALCOCITE.getName();
            case 7:
                return Ores.Ore1Types.CHALCOPYRITE.getName();
            case 8:
                return Ores.Ore1Types.CHROMITE.getName();
            case 9:
                return Ores.Ore1Types.CINNABAR.getName();
            case 10:
                return Ores.Ore1Types.COBALTITE.getName();
            case 11:
                return Ores.Ore1Types.COLUMBITE.getName();
            case 12:
                return Ores.Ore1Types.TANTALITE.getName();
            case 13:
                return Ores.Ore1Types.DOLOMITE.getName();
            case 14:
                return Ores.Ore1Types.GALENA.getName();
            case 15:
                return Ores.Ore1Types.HEMATITE.getName();
            default:
                return Ores.Ore1Types.ACANTHITE.getName();
        }
    }
}
