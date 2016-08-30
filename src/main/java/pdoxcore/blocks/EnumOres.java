package pdoxcore.blocks;

import net.minecraft.util.IStringSerializable;

/**
 * Created by WildWolf on 30/08/2016.
 */
public enum EnumOres implements IStringSerializable {

    CHROMIUM(0,"chromium", 10, 5, 20),COPPER(1,"copper", 8, 5, 30, 55),LEAD(2,"lead", 6, 5, 5, 25),MANGANESE(3,"manganese", 10, 5, 20),NICKEL(4,"nickel", 7, 10, 5, 20),
    PLATINUM(5,"platinum", 2, 10, 5, 20),SILVER(6,"silver", 5, 5, 5, 20),TIN(7,"tin", 5, 5, 20, 40),TITANIUM(8,"titanium", 1, 10, 5, 20),ZINC(9,"zinc", 5, 10, 5, 20),
    ACANTHITE(10, "acanthite", 10, 5, 20),BARITE(11, "barite", 10, 5, 20),BAUXITE(12, "bauxite", 10, 10, 5, 20),BERYL(13, "beryl", 10, 5, 20),
    BORNITE(14, "bornite", 10, 5, 20),CASSITERITE(15, "cassiterite", 10, 5, 20),CHALCOCITE(16, "chalcocite", 10, 5, 20),
    CHALCOPYRITE(17, "chalcopyrite", 10, 5, 20),CHROMITE(18, "chromite", 10, 5, 20),CINNABAR(19, "cinnabar", 10, 5, 20),
    COBALTITE(20, "cobaltite", 10, 5, 20),COLUMBITE(21, "columbite", 10, 5, 20),TANTALITE(22, "tantalite", 10, 5, 20),
    DOLOMITE(23, "dolomite", 10, 5, 20),GALENA(24, "galena", 10, 5, 20),HEMATITE(25, "hematite", 10, 5, 20),
    ILMENITE(26, "ilmenite", 10, 5, 20),MAGNETITE(27, "magnetite", 10, 5, 20),MALACHITE(28, "malachite", 10, 5, 20),
    MOLYBDENITE(29, "molybdenite", 10, 5, 20),PENTALANDITE(30, "pentalandite", 10, 5, 20),PYROLUSITE(31, "pyrolusite", 10, 5, 20),
    SCHEELITE(32, "scheelite", 10, 5, 20),SPERRYLITE(33, "sperrylite", 10, 5, 20),PSHALERITE(34, "pshalerite", 10, 5, 20),
    URANINITE(35, "uraninite", 10, 5, 20),WOLFRAMITE(36, "wolframite", 10, 5, 20);

    private static final EnumOres[] META_LOOKUP = new EnumOres[values().length];
    private int meta;
    private String name;
    private int genCount;
    private int chance;
    private int[] level = new int[2];

    EnumOres(int meta, String name, int chance, int minY, int maxY){
        this.meta = meta;
        this.name = name;
        this.genCount = 4;
        this.chance = chance;
        this.level[0] = minY;
        this.level[1] = maxY;
    }

    EnumOres(int meta, String name, int genCount, int chance, int minY, int maxY) {
        this.meta = meta;
        this.name = name;
        this.genCount = genCount;
        this.chance = chance;
        this.level[0] = minY;
        this.level[1] = maxY;
    }

    public int getMeta(){
        return meta;
    }

    public int[] getLevel() {
        return level;
    }

    public int getGenCount() {
        return genCount;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public String getName() {
        return name;
    }

    public int getChance() {
        return chance;
    }

    public static EnumOres byMetadata(int meta){
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    static {
        for(EnumOres enumOreChunk : values()){
            META_LOOKUP[enumOreChunk.getMeta()] = enumOreChunk;
        }
    }
    
}
