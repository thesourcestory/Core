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

    @Override
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
        CHROMIUM(0,"chromium", 10, 5, 20),
        COPPER(1,"copper", 8, 5, 30, 55),
        LEAD(2,"lead", 6, 5, 5, 25),
        MANGANESE(3,"manganese", 10, 5, 20),
        NICKEL(4,"nickel", 7, 10, 5, 20),
        PLATINUM(5,"platinum", 2, 10, 5, 20),
        SILVER(6,"silver", 5, 5, 5, 20),
        TIN(7,"tin", 5, 5, 20, 40),
        TITANIUM(8,"titanium", 1, 10, 5, 20),
        ZINC(9,"zinc", 5, 10, 5, 20);

        private static final OreTypes[] META_LOOKUP = new OreTypes[values().length];
        private int ID;
        private String name;
        private int genCount;
        private int chance;
        private int[] level = new int[2];

        OreTypes(int id, String name, int chance, int minY, int maxY){
            this.ID = id;
            this.name = name;
            this.genCount = 4;
            this.chance = chance;
            this.level[0] = minY;
            this.level[1] = maxY;
        }

        OreTypes(int ID, String name, int genCount, int chance, int minY, int maxY){
            this.ID = ID;
            this.name = name;
            this.genCount = genCount;
            this.chance = chance;
            this.level[0] = minY;
            this.level[1] = maxY;
        }

        public int[] getLevel(){
            return level;
        }

        public int getGenCount(){
            return genCount;
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

        public static OreTypes byMetadata(int meta){
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        static {
            for(OreTypes enumOreChunk : values()){
                META_LOOKUP[enumOreChunk.getID()] = enumOreChunk;
            }
        }

        public int getChance() {
            return chance;
        }
    }

    public enum Ore1Types implements IStringSerializable{
        ACANTHITE(0, "acanthite", 10, 5, 20),
        BARITE(1, "barite", 10, 5, 20),
        BAUXITE(2, "bauxite", 10, 10, 5, 20),
        BERYL(3, "beryl", 10, 5, 20),
        BORNITE(4, "bornite", 10, 5, 20),
        CASSITERITE(5, "cassiterite", 10, 5, 20),
        CHALCOCITE(6, "chalcocite", 10, 5, 20),
        CHALCOPYRITE(7, "chalcopyrite", 10, 5, 20),
        CHROMITE(8, "chromite", 10, 5, 20),
        CINNABAR(9, "cinnabar", 10, 5, 20),
        COBALTITE(10, "cobaltite", 10, 5, 20),
        COLUMBITE(11, "columbite", 10, 5, 20),
        TANTALITE(12, "tantalite", 10, 5, 20),
        DOLOMITE(13, "dolomite", 10, 5, 20),
        GALENA(14, "galena", 10, 5, 20),
        HEMATITE(15, "hematite", 10, 5, 20);

        private static final Ore1Types[] META_LOOKUP = new Ore1Types[values().length];
        private int ID;
        private String name;
        private int genCount;
        private int chance;
        private int[] level = new int[2];

        Ore1Types(int id, String name, int chance, int minY, int maxY){
            this.ID = id;
            this.name = name;
            this.genCount = 4;
            this.chance = chance;
            this.level[0] = minY;
            this.level[1] = maxY;
        }

        Ore1Types(int ID, String name, int genCount, int chance, int minY, int maxY){
            this.ID = ID;
            this.name = name;
            this.genCount = genCount;
            this.chance = chance;
            this.level[0] = minY;
            this.level[1] = maxY;
        }

        public int[] getLevel(){
            return level;
        }

        public int getGenCount(){
            return genCount;
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

        public static Ore1Types byMetadata(int meta){
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        static {
            for(Ore1Types enumOreChunk : values()){
                META_LOOKUP[enumOreChunk.getID()] = enumOreChunk;
            }
        }
    }

    public enum Ore2Types implements IStringSerializable{
        ILMENITE(0, "ilmenite", 10, 5, 20),
        MAGNETITE(1, "magnetite", 10, 5, 20),
        MALACHITE(2, "malachite", 10, 5, 20),
        MOLYBDENITE(3, "molybdenite", 10, 5, 20),
        PENTALANDITE(4, "pentalandite", 10, 5, 20),
        PYROLUSITE(5, "pyrolusite", 10, 5, 20),
        SCHEELITE(6, "scheelite", 10, 5, 20),
        SPERRYLITE(7, "sperrylite", 10, 5, 20),
        PSHALERITE(8, "pshalerite", 10, 5, 20),
        URANINITE(9, "uraninite", 10, 5, 20),
        WOLFRAMITE(10, "wolframite", 10, 5, 20);

        private static final Ore2Types[] META_LOOKUP = new Ore2Types[values().length];
        private int ID;
        private String name;
        private int genCount;
        private int chance;
        private int[] level = new int[2];

        Ore2Types(int id, String name, int chance, int minY, int maxY){
            this.ID = id;
            this.name = name;
            this.genCount = 4;
            this.chance = chance;
            this.level[0] = minY;
            this.level[1] = maxY;
        }

        Ore2Types(int ID, String name, int genCount, int chance, int minY, int maxY){
            this.ID = ID;
            this.name = name;
            this.genCount = genCount;
            this.chance = chance;
            this.level[0] = minY;
            this.level[1] = maxY;
        }

        public int[] getLevel(){
            return level;
        }

        public int getGenCount(){
            return genCount;
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

        public static Ore2Types byMetadata(int meta){
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        static {
            for(Ore2Types enumOreChunk : values()){
                META_LOOKUP[enumOreChunk.getID()] = enumOreChunk;
            }
        }
    }
}
