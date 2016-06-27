package pdox.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by magnus97 on 26/06/2016.
 */

public class Test extends Block {

    public Test(Material blockMaterialIn) {
        super(blockMaterialIn);
        this.setCreativeTab(CreativeTabs.MISC);
    }
}
