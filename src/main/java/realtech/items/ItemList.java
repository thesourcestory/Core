package realtech.items;

import net.minecraft.item.ItemStack;
import realtech.init.ModItems;
import realtech.init.ModTools;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WildWolf on 29/08/2016.
 */
public class ItemList {

    public static final ItemStack copperchunk = new ItemStack(ModItems.orechunk, 1, 1);
    public static final ItemStack copperingot = new ItemStack(ModItems.ingots, 1, 19);
    public static ItemStack[] ingots = new ItemStack[Ingots.values().length];
    public static ItemStack[] chunks = new ItemStack[Chunks.values().length];
    public static ItemStack[] axes = new ItemStack[ModTools.axe.length];
    public static ItemStack[] paxes = new ItemStack[ModTools.paxe.length];
    public static ItemStack[] spades = new ItemStack[ModTools.spade.length];
    public static ItemStack[] swords = new ItemStack[ModTools.swords.length];
    public static ItemStack[] hoes = new ItemStack[ModTools.hoe.length];

    public static ItemStack getStackFromMeta(int meta, ItemStack[] itemStacks){
        return itemStacks[Ingots.byMetadata(meta).getMeta()];
    }

    public static String getNameFromStack(ItemStack stack){
        if(stack == ingots[stack.getItemDamage()])
            return Ingots.byMetadata(stack.getItemDamage()).getName();
        else if(stack == axes[stack.getItemDamage()])
            return Axes.byMetadata(stack.getItemDamage()).getName();
        else if(stack == paxes[stack.getItemDamage()])
            return Paxes.byMetadata(stack.getItemDamage()).getName();
        else if(stack == spades[stack.getItemDamage()])
            return Spades.byMetadata(stack.getItemDamage()).getName();
        else if(stack == swords[stack.getItemDamage()])
            return Swords.byMetadata(stack.getItemDamage()).getName();
        else if(stack == hoes[stack.getItemDamage()])
            return Hoes.byMetadata(stack.getItemDamage()).getName();
        else
            return Chunks.byMetadata(stack.getItemDamage()).getName();
    }

    public enum Swords{
        ;

        private static final Swords[] META_LOOKUP = new Swords[values().length];

        private String name;
        private int meta;

        Swords(int meta, String name){
            this.name = name;
            this.meta = meta;
        }

        public int getMeta() {
            return meta;
        }

        public String getName() {
            return name;
        }

        public String getOredicName() {
            return "ingot" + name;
        }

        public static Swords byMetadata(int meta){
            if(meta < 0 || meta >= META_LOOKUP.length){
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        static {
            for (Swords ingots : values()) {
                META_LOOKUP[ingots.getMeta()] = ingots;
            }
        }
    }

    public enum Axes{
        ;

        private static final Axes[] META_LOOKUP = new Axes[values().length];

        private String name;
        private int meta;

        Axes(int meta, String name){
            this.name = name;
            this.meta = meta;
        }

        public int getMeta() {
            return meta;
        }

        public String getName() {
            return name;
        }

        public String getOredicName() {
            return "ingot" + name;
        }

        public static Axes byMetadata(int meta){
            if(meta < 0 || meta >= META_LOOKUP.length){
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        static {
            for (Axes ingots : values()) {
                META_LOOKUP[ingots.getMeta()] = ingots;
            }
        }
    }

    public enum Paxes{
        ;

        private static final Paxes[] META_LOOKUP = new Paxes[values().length];

        private String name;
        private int meta;

        Paxes(int meta, String name){
            this.name = name;
            this.meta = meta;
        }

        public int getMeta() {
            return meta;
        }

        public String getName() {
            return name;
        }

        public String getOredicName() {
            return "ingot" + name;
        }

        public static Paxes byMetadata(int meta){
            if(meta < 0 || meta >= META_LOOKUP.length){
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        static {
            for (Paxes ingots : values()) {
                META_LOOKUP[ingots.getMeta()] = ingots;
            }
        }
    }

    public enum Spades{
        ;

        private static final Spades[] META_LOOKUP = new Spades[values().length];

        private String name;
        private int meta;

        Spades(int meta, String name){
            this.name = name;
            this.meta = meta;
        }

        public int getMeta() {
            return meta;
        }

        public String getName() {
            return name;
        }

        public String getOredicName() {
            return "ingot" + name;
        }

        public static Spades byMetadata(int meta){
            if(meta < 0 || meta >= META_LOOKUP.length){
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        static {
            for (Spades ingots : values()) {
                META_LOOKUP[ingots.getMeta()] = ingots;
            }
        }
    }

    public enum Hoes{
        ;

        private static final Hoes[] META_LOOKUP = new Hoes[values().length];

        private String name;
        private int meta;

        Hoes(int meta, String name){
            this.name = name;
            this.meta = meta;
        }

        public int getMeta() {
            return meta;
        }

        public String getName() {
            return name;
        }

        public String getOredicName() {
            return "ingot" + name;
        }

        public static Hoes byMetadata(int meta){
            if(meta < 0 || meta >= META_LOOKUP.length){
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        static {
            for (Hoes ingots : values()) {
                META_LOOKUP[ingots.getMeta()] = ingots;
            }
        }
    }

    public enum Ingots{
        LITHIUM(0,"Lithium"),
        SODIUM(1,"Sodium"),
        POTASSIUM(2,"Potassium"),
        RUBIDIUM(3,"Rubidium"),
        CAESIUM(4,"Caesium"),
        FRANCIUM(5,"Francium"),
        BERYLLIUM(6,"Beryllium"),
        MAGNESIUM(7,"Magnesium"),
        CALSIUM(8,"Calcium"),
        STRONTIUM(9,"Strontium"),
        BARIUM(10,"Barium"),
        RADIUM(11,"Radium"),
        SCANDIUM(12,"Scandium"),
        TITANIUM(13,"Titanium"),
        VANADIUM(14,"Vanadium"),
        CHROMIUM(15,"Chromium"),
        MANGANESE(16,"Manganese"),
        COBALT(17,"Cobalt"),
        NICKEL(18,"Nickel"),
        COPPER(19,"Copper"),
        ZINC(20,"Zinc"),
        YTTRIUM(21,"Yttrium"),
        ZIRCONIUM(22,"Zirconium"),
        NIOBIUM(23,"Niobium"),
        MOLYBDENUM(24,"Molybdenum"),
        TECHNETIUM(25,"Technetium"),
        RUTHENIUM(26,"Ruthenium"),
        RHODIUM(27,"Rhodium"),
        PALLADIUM(28,"Palladium"),
        SILVER(29,"Silver"),
        CADMIUM(30,"Cadmium"),
        HAFNIUM(31,"Hafnium"),
        TANTALUM(32,"Tantalum"),
        TUNGSTEN(33,"Tungsten"),
        RHENIUM(34,"Rhenium"),
        OSMIUM(35,"Osmium"),
        IRIDIUM(36,"Iridium"),
        PLATINUM(37,"Platinum"),
        MERCURY(38,"Mercury"),
        RUTHERFORDIUM(39,"Rutherfordium"),
        DUBNIUM(40,"Dubnium"),
        SEABORGIUM(41,"Seaborgium"),
        BOHRIUM(42,"Bohrium"),
        HASSIUM(43,"Hassium"),
        COPERNICIUM(44,"Copernicium"),
        ALUMINIUM(45,"Aluminium"),
        GALLIUM(46,"Gallium"),
        INDIUM(47,"Indium"),
        TIN(48,"Tin"),
        THALLIUM(49,"Thallium"),
        LEAD(50,"Lead"),
        BISMUTH(51,"Bismuth"),
        POLONIUM(52,"Polonium"),
        FLEROVIUM(53,"Flerovium"),
        LANTHANUM(54,"Lanthanum"),
        CERIUM(55,"Cerium"),
        PRASEODYMIUM(56,"Praseodymium"),
        NEODYMIUM(57,"Neodymium"),
        PROMETHIUM(58,"Promethium"),
        SAMARIUM(59,"Samarium"),
        EUROPIUM(60,"Europium"),
        GADOLINIUM(61,"Gadolinium"),
        TERBIUM(62,"Terbium"),
        DYSPROSIUM(63,"Dysprosium"),
        HOLMIUM(64,"Holmium"),
        ERBIUM(65,"Erbium"),
        THULIUM(66,"Thulium"),
        YTTERBIUM(67,"Ytterbium"),
        LUTETIUM(68,"Lutetium"),
        ACTINIUM(69,"Actinium"),
        THORIUM(70,"Thorium"),
        PROTACTINIUM(71,"Protactinium"),
        URANIUM(72,"Uranium"),
        NEPTUNIUM(73,"Neptunium"),
        PLUTONIUM(74,"Plutonium"),
        AMERICIUM(75,"Americium"),
        CURIUM(76,"Curium"),
        BERKELIUM(77,"Berkelium"),
        CALIFORNIUM(78,"Californium"),
        EINSTEINIUM(79,"Einsteinium"),
        FERMIUM(80,"Fermium"),
        MENDELEVIUM(81,"Mendelevium"),
        NOBELIUM(82,"Nobelium"),
        LAWRENCIUM(83,"Lawrencium"),
        GERMANIUM(84,"Germanium"),
        ARSENIC(85,"Arsenic"),
        ANTIMONY(86,"Antimony"),
        ASTATINE(87,"Astatine");

        private static final Ingots[] META_LOOKUP = new Ingots[values().length];
        private static Map<String, Ingots> map = new HashMap<String, Ingots>();

        private String name;
        private int meta;

        Ingots(int meta, String name){
            this.name = name;
            this.meta = meta;
        }

        public int getMeta() {
            return meta;
        }

        public String getName() {
            return name;
        }

        public String getOredicName() {
            return "ingot" + name;
        }

        public static Ingots byMetadata(int meta){
            if(meta < 0 || meta >= META_LOOKUP.length){
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public static Ingots byName(String name){
            return map.get(name);
        }

        static {
            for (Ingots ingots : values()) {
                META_LOOKUP[ingots.getMeta()] = ingots;
                map.put(ingots.getName(), ingots);
            }
        }
    }

    public enum Chunks{
        CHROMIUM(0,"Chromium"),
        COPPER(1,"Copper"),
        LEAD(2,"Lead"),
        MANGANESE(3,"Manganese"),
        NICKEL(4,"Nickel"),
        PLATINUM(5,"Platinum"),
        SILVER(6,"Silver"),
        TIN(7,"Tin"),
        TITANIUM(8,"Titanium"),
        ZINC(9,"Zinc"),
        ACANTHITE(10, "Acanthite"),
        BARITE(11, "Barite"),
        BAUXITE(12, "Bauxite"),
        BERYL(13, "Beryl"),
        BORNITE(14, "Bornite"),
        CASSITERITE(15, "Cassiterite"),
        CHALCOCITE(16, "Chalcocite"),
        CHALCOPYRITE(17, "Chalcopyrite"),
        CHROMITE(18, "Chromite"),
        CINNABAR(19, "Cinnabar"),
        COBALTITE(20, "Cobaltite"),
        COLUMBITE(21, "Columbite"),
        TANTALITE(22, "Tantalite"),
        DOLOMITE(23, "Dolomite"),
        GALENA(24, "Galena"),
        HEMATITE(25, "Hematite"),
        ILMENITE(26, "Ilmenite"),
        MAGNETITE(27, "Magnetite"),
        MALACHITE(28, "Malachite"),
        MOLYBDENITE(29, "Molybdenite"),
        PENTALANDITE(30, "Pentalandite"),
        PYROLUSITE(31, "Pyrolusite"),
        SCHEELITE(32, "Scheelite"),
        SPERRYLITE(33, "Sperrylite"),
        PSHALERITE(34, "Pshalerite"),
        URANINITE(35, "Uraninite"),
        WOLFRAMITE(36, "Wolframite");

        private static final Chunks[] META_LOOKUP = new Chunks[values().length];

        private String name;
        private int meta;

        Chunks(int meta, String name){
            this.name = name;
            this.meta = meta;
        }

        public int getMeta() {
            return meta;
        }

        public String getName() {
            return name;
        }

        public String getOredicName() {
            return "chunk" + name;
        }

        public static Chunks byMetadata(int meta){
            if(meta < 0 || meta >= META_LOOKUP.length){
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        static {
            for (Chunks ingots : values()) {
                META_LOOKUP[ingots.getMeta()] = ingots;
            }
        }
    }

    static {
        for(int i = 0; i < ingots.length; i++){
            ingots[i] = new ItemStack(ModItems.ingots, 1, i);
        }
        for(int i = 0; i < chunks.length; i++){
            chunks[i] = new ItemStack(ModItems.orechunk, 1, i);
        }
    }

}
