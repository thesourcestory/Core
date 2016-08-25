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
public class Ores2 extends Block implements IMetaBlockName{

    public Ores2(Material blockMaterialIn, float hardness, float resistance) {
        super(blockMaterialIn);
        this.setResistance(resistance);
        this.setHardness(hardness);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(PdoxCore.pdoxcoreores);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, Ores.Ore2Types.ILMENITE));
    }

    public static final PropertyEnum TYPE = PropertyEnum.create("type", Ores.Ore2Types.class);

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] { TYPE });
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        switch (meta){
            case 1:
                return getDefaultState().withProperty(TYPE, Ores.Ore2Types.MAGNETITE);
            case 2:
                return getDefaultState().withProperty(TYPE, Ores.Ore2Types.MALACHITE);
            case 3:
                return getDefaultState().withProperty(TYPE, Ores.Ore2Types.MOLYBDENITE);
            case 4:
                return getDefaultState().withProperty(TYPE, Ores.Ore2Types.PENTALANDITE);
            case 5:
                return getDefaultState().withProperty(TYPE, Ores.Ore2Types.PYROLUSITE);
            case 6:
                return getDefaultState().withProperty(TYPE, Ores.Ore2Types.SCHEELITE);
            case 7:
                return getDefaultState().withProperty(TYPE, Ores.Ore2Types.SPERRYLITE);
            case 8:
                return getDefaultState().withProperty(TYPE, Ores.Ore2Types.PSHALERITE);
            case 9:
                return getDefaultState().withProperty(TYPE, Ores.Ore2Types.URANINITE);
            case 10:
                return getDefaultState().withProperty(TYPE, Ores.Ore2Types.WOLFRAMITE);
            default:
                return getDefaultState().withProperty(TYPE, Ores.Ore2Types.ILMENITE);
        }
    }

    @Override
    public int getMetaFromState(IBlockState state){
        Ores.Ore2Types type = (Ores.Ore2Types) state.getValue(TYPE);
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
        return EnumOreChunk.byMetadata(getMetaFromState(state) + Ores.OreTypes.values().length + Ores.Ore1Types.values().length).getMeta();
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
                return Ores.Ore2Types.MAGNETITE.getName();
            case 2:
                return Ores.Ore2Types.MALACHITE.getName();
            case 3:
                return Ores.Ore2Types.MOLYBDENITE.getName();
            case 4:
                return Ores.Ore2Types.PENTALANDITE.getName();
            case 5:
                return Ores.Ore2Types.PYROLUSITE.getName();
            case 6:
                return Ores.Ore2Types.SCHEELITE.getName();
            case 7:
                return Ores.Ore2Types.SPERRYLITE.getName();
            case 8:
                return Ores.Ore2Types.PSHALERITE.getName();
            case 9:
                return Ores.Ore2Types.URANINITE.getName();
            case 10:
                return Ores.Ore2Types.WOLFRAMITE.getName();
            default:
                return Ores.Ore2Types.ILMENITE.getName();
        }
    }
}
