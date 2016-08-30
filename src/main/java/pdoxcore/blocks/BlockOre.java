package pdoxcore.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import pdoxcore.init.ModItems;
import pdoxcore.items.EnumOreChunk;

import java.util.Random;

/**
 * Created by WildWolf on 30/08/2016.
 */
public class BlockOre extends Block {

    private static int[] chance = new int[EnumOres.values().length];
    private static int[] count = new int[EnumOres.values().length];
    private static int[][] lvl = new int[EnumOres.values().length][2];
    private static Block[] blocks = new Block[EnumOres.values().length];
    private static int[] metadrop = new int[EnumOres.values().length];

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
    public BlockOre(Material materialIn, int chance, int count, int miny, int maxy, int where, String name, int lvl) {
        super(materialIn);
        this.chance[where] = chance;
        this.count[where] = count;
        this.lvl[where][0] = miny;
        this.lvl[where][1] = maxy;
        this.setHarvestLevel("pickaxe", lvl);
        this.setUnlocalizedName("ores." + name);
        this.setRegistryName(name);
        this.blocks[where] = this;
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
        this.blocks[where] = this;
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

    public static Block[] getBlocks() {
        return blocks;
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
        for (int i = 0; i <= blocks.length; i++) {
            if (state.getBlock() == blocks[i]) {
                meta = metadrop[i];
            }
        }
        return EnumOreChunk.byMetadata(metadrop[meta]).getMeta();
    }
}
