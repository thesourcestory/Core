package realtech.util;

/**
 * Created by WildWolf on 20/09/2016.
 */
public enum OreConfigDefault {
    CHROMIUM(0,"Chromium", 4, 10, 5, 20,2),
    COPPER(1,"Copper", 8, 5, 30, 55, 2),
    LEAD(2,"Lead", 6, 5, 5, 25, 2),
    MANGANESE(3,"Manganese", 4, 10, 5, 20, 2),
    NICKEL(4,"Nickel", 7, 10, 5, 20, 2),
    PLATINUM(5,"Platinum", 2, 10, 5, 20, 2),
    SILVER(6,"Silver", 5, 5, 5, 20, 2),
    TIN(7,"Tin", 5, 5, 20, 40, 2),
    TITANIUM(8,"Titanium", 1, 10, 5, 20, 2),
    ZINC(9,"Zinc", 5, 10, 5, 20, 2),
    ACANTHITE(10, "Acanthite", 4, 10, 5, 20, 2),
    BARITE(11, "Barite", 4, 10, 5, 20, 2),
    BAUXITE(12, "Bauxite", 10, 10, 5, 20, 2),
    BERYL(13, "Beryl", 4, 10, 5, 20, 2),
    BORNITE(14, "Bornite", 4, 10, 5, 20, 2),
    CASSITERITE(15, "Cassiterite", 4, 10, 5, 20, 2),
    CHALCOCITE(16, "Chalcocite", 4, 10, 5, 20, 2),
    CHALCOPYRITE(17, "Chalcopyrite", 4, 10, 5, 20, 2),
    CHROMITE(18, "Chromite", 4, 10, 5, 20, 2),
    CINNABAR(19, "Cinnabar", 4, 10, 5, 20, 2),
    COBALTITE(20, "Cobaltite", 4, 10, 5, 20, 2),
    COLUMBITE(21, "Columbite", 4, 10, 5, 20, 2),
    TANTALITE(22, "Tantalite", 4, 10, 5, 20, 2),
    DOLOMITE(23, "Dolomite", 4, 10, 5, 20, 2),
    GALENA(24, "Galena", 4, 10, 5, 20, 2),
    HEMATITE(25, "Hematite", 4, 10, 5, 20, 2),
    ILMENITE(26, "Ilmenite", 4, 10, 5, 20, 2),
    MAGNETITE(27, "Magnetite", 4, 10, 5, 20, 2),
    MALACHITE(28, "Malachite", 4, 10, 5, 20, 2),
    MOLYBDENITE(29, "Molybdenite", 4, 10, 5, 20, 2),
    PENTALANDITE(30, "Pentalandite", 4, 10, 5, 20, 2),
    PYROLUSITE(31, "Pyrolusite", 4, 10, 5, 20, 2),
    SCHEELITE(32, "Scheelite", 4, 10, 5, 20, 2),
    SPERRYLITE(33, "Sperrylite", 4, 10, 5, 20, 2),
    PSHALERITE(34, "Pshalerite", 4, 10, 5, 20, 2),
    URANINITE(35, "Uraninite", 4, 10, 5, 20, 2),
    WOLFRAMITE(36, "Wolframite", 4, 10, 5, 20, 2);

    private static OreConfigDefault[] NUMBER = new OreConfigDefault[values().length];
    private String ore;
    private int genCount;
    private int count;
    private int miny;
    private int maxy;
    private int number;
    private int lvl;

    OreConfigDefault(int number, String ore, int genCount, int chance, int miny, int maxy, int mininglvl){
        this.ore = ore;
        this.genCount = genCount;
        this.count = chance;
        this.maxy = maxy;
        this.miny = miny;
        this.number = number;
        this.lvl = mininglvl;
    }

    public int getNumber() {
        return number;
    }

    public int getChance() {
        return count;
    }

    public int getGenCount() {
        return genCount;
    }

    public int getMaxy() {
        return maxy;
    }

    public int getMiny() {
        return miny;
    }

    public int getMiningLvl(){
        return lvl;
    }

    public String getOre() {
        return ore;
    }

    public static OreConfigDefault byNumber(int n){
        if(n < 0 || n >= NUMBER.length){
            n = 0;
        }
        return NUMBER[n];
    }

    static {
        for (OreConfigDefault ores: values()) {
            NUMBER[ores.getNumber()] = ores;
        }
    }
}
