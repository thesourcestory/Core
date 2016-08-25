package pdoxcore.items;

import net.minecraft.util.IStringSerializable;

/**
 * Created by WildWolf on 25/08/2016.
 */
public enum EnumOreChunk implements IStringSerializable{
    CHROMIUM(0,"chromium"),COPPER(1,"copper"),LEAD(2,"lead"),MANGANESE(3,"manganese"),NICKEL(4,"nickel"),
    PLATINUM(5,"platinum"),SILVER(6,"silver"),TIN(7,"tin"),TITANIUM(8,"titanium"),ZINC(9,"zinc"),
    ACANTHITE(10, "acanthite"),BARITE(11, "barite"),BAUXITE(12, "bauxite"),BERYL(13, "beryl"),
    BORNITE(14, "bornite"),CASSITERITE(15, "cassiterite"),CHALCOCITE(16, "chalcocite"),
    CHALCOPYRITE(17, "chalcopyrite"),CHROMITE(18, "chromite"),CINNABAR(19, "cinnabar"),
    COBALTITE(20, "cobaltite"),COLUMBITE(21, "columbite"),TANTALITE(22, "tantalite"),
    DOLOMITE(23, "dolomite"),GALENA(24, "galena"),HEMATITE(25, "hematite"),
    ILMENITE(26, "ilmenite"),MAGNETITE(27, "magnetite"),MALACHITE(28, "malachite"),
    MOLYBDENITE(29, "molybdenite"),PENTALANDITE(30, "pentalandite"),PYROLUSITE(31, "pyrolusite"),
    SCHEELITE(32, "scheelite"),SPERRYLITE(33, "sperrylite"),PSHALERITE(34, "pshalerite"),
    URANINITE(35, "uraninite"),WOLFRAMITE(36, "wolframite");

    private static final EnumOreChunk[] META_LOOKUP = new EnumOreChunk[values().length];
    private int meta;
    private String name;

    EnumOreChunk(int meta, String unlocalizedName){
        this.meta = meta;
        this.name = unlocalizedName;
    }

    public int getMeta(){
        return meta;
    }

    @Override
    public String getName() {
        return name;
    }

    public static EnumOreChunk byMetadata(int meta){
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    static {
        for(EnumOreChunk enumOreChunk : values()){
            META_LOOKUP[enumOreChunk.getMeta()] = enumOreChunk;
        }
    }
}
