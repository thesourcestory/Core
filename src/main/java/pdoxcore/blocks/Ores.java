package pdoxcore.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
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
public class Ores extends Block implements IMetaBlockName{

    public Ores(Material blockMaterialIn, float hardness, float resistance) {
        super(blockMaterialIn);
        this.setResistance(resistance);
        this.setHardness(hardness);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(PdoxCore.pdoxcoreores);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, OreTypes.CHROMIUM));
    }

    public static final PropertyEnum TYPE = PropertyEnum.create("type", OreTypes.class);

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] { TYPE });
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        switch (meta){
            case 1:
                return getDefaultState().withProperty(TYPE, OreTypes.COPPER);
            case 2:
                return getDefaultState().withProperty(TYPE, OreTypes.LEAD);
            case 3:
                return getDefaultState().withProperty(TYPE, OreTypes.MANGANESE);
            case 4:
                return getDefaultState().withProperty(TYPE, OreTypes.NICKEL);
            case 5:
                return getDefaultState().withProperty(TYPE, OreTypes.PLATINUM);
            case 6:
                return getDefaultState().withProperty(TYPE, OreTypes.SILVER);
            case 7:
                return getDefaultState().withProperty(TYPE, OreTypes.TIN);
            case 8:
                return getDefaultState().withProperty(TYPE, OreTypes.TITANIUM);
            case 9:
                return getDefaultState().withProperty(TYPE, OreTypes.ZINC);
            default:
                return getDefaultState().withProperty(TYPE, OreTypes.CHROMIUM);
        }
    }

    @Override
    public int getMetaFromState(IBlockState state){
        OreTypes type = (OreTypes) state.getValue(TYPE);
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
        return EnumOreChunk.byMetadata(getMetaFromState(state)).getMeta();
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
                return OreTypes.COPPER.getName();
            case 2:
                return OreTypes.LEAD.getName();
            case 3:
                return OreTypes.MANGANESE.getName();
            case 4:
                return OreTypes.NICKEL.getName();
            case 5:
                return OreTypes.PLATINUM.getName();
            case 6:
                return OreTypes.SILVER.getName();
            case 7:
                return OreTypes.TIN.getName();
            case 8:
                return OreTypes.TITANIUM.getName();
            case 9:
                return OreTypes.ZINC.getName();
            default:
                return OreTypes.CHROMIUM.getName();
        }
    }

    public enum OreTypes implements IStringSerializable {
        CHROMIUM(0,"chromium"),COPPER(1,"copper"),LEAD(2,"lead"),MANGANESE(3,"manganese"),NICKEL(4,"nickel"),
        PLATINUM(5,"platinum"), SILVER(6,"silver"),TIN(7,"tin"),TITANIUM(8,"titanium"),ZINC(9,"zinc");

        private int ID;
        private String name;

        OreTypes(int ID, String name){
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

    public enum Ore1Types implements IStringSerializable{
        ACANTHITE(0, "acanthite"), BARITE(1, "barite"), BAUXITE(2, "bauxite"), BERYL(3, "beryl"), BORNITE(4, "bornite"), CASSITERITE(5, "cassiterite"), CHALCOCITE(6, "chalcocite"),
        CHALCOPYRITE(7, "chalcopyrite"), CHROMITE(8, "chromite"), CINNABAR(9, "cinnabar"), COBALTITE(10, "cobaltite"), COLUMBITE(11, "columbite"), TANTALITE(12, "tantalite"),
        DOLOMITE(13, "dolomite"), GALENA(14, "galena"), HEMATITE(15, "hematite");

        private int ID;
        private String name;

        Ore1Types(int ID, String name){
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

    public enum Ore2Types implements IStringSerializable{
        ILMENITE(0, "ilmenite"), MAGNETITE(1, "magnetite"), MALACHITE(2, "malachite"), MOLYBDENITE(3, "molybdenite"), PENTALANDITE(4, "pentalandite"), PYROLUSITE(5, "pyrolusite"),
        SCHEELITE(6, "scheelite"), SPERRYLITE(7, "sperrylite"), PSHALERITE(8, "pshalerite"), URANINITE(9, "uraninite"), WOLFRAMITE(10, "wolframite");

        private int ID;
        private String name;

        Ore2Types(int ID, String name){
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
