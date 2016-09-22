package pdoxcore.util;

/**
 * Created by WildWolf on 20/09/2016.
 */
public enum OreConfigDefault {
    CHROMIUM(0,"chromium", 4, 10, 5, 20,2),
    COPPER(1,"copper", 8, 5, 30, 55, 2),
    LEAD(2,"lead", 6, 5, 5, 25, 2),
    MANGANESE(3,"manganese", 4, 10, 5, 20, 2),
    NICKEL(4,"nickel", 7, 10, 5, 20, 2),
    PLATINUM(5,"platinum", 2, 10, 5, 20, 2),
    SILVER(6,"silver", 5, 5, 5, 20, 2),
    TIN(7,"tin", 5, 5, 20, 40, 2),
    TITANIUM(8,"titanium", 1, 10, 5, 20, 2),
    ZINC(9,"zinc", 5, 10, 5, 20, 2),
    ACANTHITE(10, "acanthite", 4, 10, 5, 20, 2),
    BARITE(11, "barite", 4, 10, 5, 20, 2),
    BAUXITE(12, "bauxite", 10, 10, 5, 20, 2),
    BERYL(13, "beryl", 4, 10, 5, 20, 2),
    BORNITE(14, "bornite", 4, 10, 5, 20, 2),
    CASSITERITE(15, "cassiterite", 4, 10, 5, 20, 2),
    CHALCOCITE(16, "chalcocite", 4, 10, 5, 20, 2),
    CHALCOPYRITE(17, "chalcopyrite", 4, 10, 5, 20, 2),
    CHROMITE(18, "chromite", 4, 10, 5, 20, 2),
    CINNABAR(19, "cinnabar", 4, 10, 5, 20, 2),
    COBALTITE(20, "cobaltite", 4, 10, 5, 20, 2),
    COLUMBITE(21, "columbite", 4, 10, 5, 20, 2),
    TANTALITE(22, "tantalite", 4, 10, 5, 20, 2),
    DOLOMITE(23, "dolomite", 4, 10, 5, 20, 2),
    GALENA(24, "galena", 4, 10, 5, 20, 2),
    HEMATITE(25, "hematite", 4, 10, 5, 20, 2),
    ILMENITE(26, "ilmenite", 4, 10, 5, 20, 2),
    MAGNETITE(27, "magnetite", 4, 10, 5, 20, 2),
    MALACHITE(28, "malachite", 4, 10, 5, 20, 2),
    MOLYBDENITE(29, "molybdenite", 4, 10, 5, 20, 2),
    PENTALANDITE(30, "pentalandite", 4, 10, 5, 20, 2),
    PYROLUSITE(31, "pyrolusite", 4, 10, 5, 20, 2),
    SCHEELITE(32, "scheelite", 4, 10, 5, 20, 2),
    SPERRYLITE(33, "sperrylite", 4, 10, 5, 20, 2),
    PSHALERITE(34, "pshalerite", 4, 10, 5, 20, 2),
    URANINITE(35, "uraninite", 4, 10, 5, 20, 2),
    WOLFRAMITE(36, "wolframite", 4, 10, 5, 20, 2);

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
