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
import net.minecraft.util.IStringSerializable;
import pdoxcore.init.PdoxCore;
import pdoxcore.test.IMetaBlockName;

import java.util.List;

/**
 * Created by magnus97 on 15/08/2016.
 */
public class Ores extends Block implements IMetaBlockName{

    public Ores(Material blockMaterialIn, float hardness, float resistance) {
        super(blockMaterialIn);
        this.setResistance(resistance);
        this.setHardness(hardness);
        this.setCreativeTab(PdoxCore.pdoxcore);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, OresTypes.CHROMIUM));
    }

    public static final PropertyEnum TYPE = PropertyEnum.create("type", OresTypes.class);

    public static PropertyEnum getType(){
        return TYPE;
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] { TYPE });
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        switch (meta){
            case 1:
                return getDefaultState().withProperty(TYPE, OresTypes.COPPER);
            case 2:
                return getDefaultState().withProperty(TYPE, OresTypes.LEAD);
            case 3:
                return getDefaultState().withProperty(TYPE, OresTypes.MANGANESE);
            case 4:
                return getDefaultState().withProperty(TYPE, OresTypes.NICKEL);
            case 5:
                return getDefaultState().withProperty(TYPE, OresTypes.PLATINUM);
            case 6:
                return getDefaultState().withProperty(TYPE, OresTypes.SILVER);
            case 7:
                return getDefaultState().withProperty(TYPE, OresTypes.TIN);
            case 8:
                return getDefaultState().withProperty(TYPE, OresTypes.TITANIUM);
            case 9:
                return getDefaultState().withProperty(TYPE, OresTypes.ZINC);
            default:
                return getDefaultState().withProperty(TYPE, OresTypes.CHROMIUM);
        }
    }

    @Override
    public int getMetaFromState(IBlockState state){
        OresTypes type = (OresTypes) state.getValue(TYPE);
        return type.getID();
    }

    @Override
    public int damageDropped(IBlockState state){
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 0; i < 10; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        switch (stack.getItemDamage()){
            case 1:
                return OresTypes.COPPER.getName();
            case 2:
                return OresTypes.LEAD.getName();
            case 3:
                return OresTypes.MANGANESE.getName();
            case 4:
                return OresTypes.NICKEL.getName();
            case 5:
                return OresTypes.PLATINUM.getName();
            case 6:
                return OresTypes.SILVER.getName();
            case 7:
                return OresTypes.TIN.getName();
            case 8:
                return OresTypes.TITANIUM.getName();
            case 9:
                return OresTypes.ZINC.getName();
            default:
                return OresTypes.CHROMIUM.getName();
        }
    }

    public enum OresTypes implements IStringSerializable{
        CHROMIUM(0,"chromium"),COPPER(1,"copper"),LEAD(2,"lead"),MANGANESE(3,"manganese"),NICKEL(4,"nickel"),
        PLATINUM(5,"platinum"), SILVER(6,"silver"),TIN(7,"tin"),TITANIUM(8,"titanium"),ZINC(9,"zinc");

        private int ID;
        private String name;

        OresTypes(int ID, String name){
            this.ID = ID;
            this.name = name;
        }

        @Override
        public String toString(){
            return getName();
        }

        @Override
        public String getName() {
            return name;
        }

        public int getID() {
            return ID;
        }
    }

    public enum Ores1Types implements IStringSerializable{
        ACANTHITE(0, "acanthite"), BARITE(1, "barite"), BAUXITE(2, "bauxite"), BERYL(3, "beryl"), BORNITE(4, "bornite"), CASSITERITE(5, "cassiterite"), CHALCOCITE(6, "chalcocite"),
        CHALCOPYRITE(7, "chalcopyrite"), CHROMITE(8, "chromite"), CINNABAR(9, "cinnabar"), COBALTITE(10, "cobaltite"), COLUMBITE(11, "columbite"), TANTALITE(12, "tantalite"),
        DOLOMITE(13, "dolomite"), GALENA(14, "galena"), HEMATITE(15, "hematite");

        private int ID;
        private String name;

        Ores1Types(int ID, String name){
            this.ID = ID;
            this.name = name;
        }

        @Override
        public String toString(){
            return getName();
        }

        @Override
        public String getName() {
            return name;
        }

        public int getID() {
            return ID;
        }
    }

    public enum Ores2Types implements IStringSerializable{
        ILMENITE(0, "ilmenite"), MAGNETITE(1, "magnetite"), MALACHITE(2, "malachite"), MOLYBDENITE(3, "molybdenite"), PENTALANDITE(4, "pentalandite"), PYROLUSITE(5, "pyrolusite"),
        SCHEELITE(6, "scheelite"), SPERRYLITE(7, "sperrylite"), PSHALERITE(8, "pshalerite"), URANINITE(9, "uraninite"), WOLFRAMITE(10, "wolframite");

        private int ID;
        private String name;

        Ores2Types(int ID, String name){
            this.ID = ID;
            this.name = name;
        }

        @Override
        public String toString(){
            return getName();
        }

        @Override
        public String getName() {
            return name;
        }

        public int getID() {
            return ID;
        }
    }
}
