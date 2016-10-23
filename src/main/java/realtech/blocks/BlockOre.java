package realtech.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import realtech.init.ModBlocks;
import realtech.init.ModItems;
import realtech.init.Realtech;
import realtech.items.EnumOreChunk;
import realtech.util.OreConfigDefault;

import java.util.Random;

/**
 * Created by WildWolf on 30/08/2016.
 */
public class BlockOre extends Block {

    private static int[] chance = new int[OreConfigDefault.values().length];
    private static int[] count = new int[OreConfigDefault.values().length];
    private static int[][] lvl = new int[OreConfigDefault.values().length][2];
    private static int[] metadrop = new int[OreConfigDefault.values().length];
    private static boolean[] cangen = new boolean[OreConfigDefault.values().length];

    /***
     * @param materialIn material
     * @param chance how many times it can spawn
     * @param count how much can spawn
     * @param miny where above this y level it can spawn
     * @param maxy where below this y level it can spawn
     * @param where where it is in the array
     * @param name name of ore
     * @param lvl what tool level
     */
    public BlockOre(Material materialIn, int chance, int count, int miny, int maxy, int where, String name, int lvl, boolean cangen) {
        super(materialIn);
        this.chance[where] = chance;
        this.count[where] = count;
        this.lvl[where][0] = miny;
        this.lvl[where][1] = maxy;
        this.cangen[where] = cangen;
        this.setHarvestLevel("pickaxe", lvl);
        this.setUnlocalizedName("ores." + name);
        this.setRegistryName(name);
        this.setCreativeTab(Realtech.realtechores);
    }

    /***
     *
     * @param materialIn material
     * @param chance how many times it can spawn
     * @param miny where above this y level it can spawn
     * @param maxy where below this y level it can spawn
     * @param where where it is in the array
     * @param name name of ore
     * @param lvl what tool level
     */
    public BlockOre(Material materialIn, int chance, int miny, int maxy, int where, String name, int lvl){
        super(materialIn);
        this.chance[where] = chance;
        this.count[where] = 4;
        this.lvl[where][0] = miny;
        this.lvl[where][1] = maxy;
        this.setHarvestLevel("pickaxe", lvl);
        this.setUnlocalizedName("ores." + name);
        this.setRegistryName(name);
        this.setCreativeTab(Realtech.realtechores);
    }

    public static int[] getChance() {
        return chance;
    }

    public static int[] getCount() {
        return count;
    }

    public static int[][] getLevel() {
        return lvl;
    }

    public static boolean[] getCangen(){
        return cangen;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        return ModItems.orechunk;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1 + random.nextInt(4);
    }

    @Override
    public int damageDropped(IBlockState state) {
        int meta = 0;
        for (int i = 0; i < ModBlocks.ores.length; i++) {
            if (state.getBlock() == ModBlocks.ores[i]) {
                meta = metadrop[i];
            }
        }
        return EnumOreChunk.byMetadata(metadrop[meta]).getMeta();
    }
}
