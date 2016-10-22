package realtech.recipes;

import realtech.items.ItemList;

/**
 * Created by WildWolf on 19/10/2016.
 */
public class SmeltingRecipes extends Recipes {

    public static void register(){
        smelting(ItemList.chunks[ItemList.Chunks.LEAD.getMeta()], ItemList.ingots[ItemList.Ingots.LEAD.getMeta()], 0.7F);
        smelting(ItemList.chunks[ItemList.Chunks.CHROMIUM.getMeta()], ItemList.ingots[ItemList.Ingots.CHROMIUM.getMeta()], 0.7F);
        smelting(ItemList.chunks[ItemList.Chunks.BAUXITE.getMeta()], ItemList.ingots[ItemList.Ingots.ALUMINIUM.getMeta()], 0.7F);
        smelting(ItemList.chunks[ItemList.Chunks.COPPER.getMeta()], ItemList.ingots[ItemList.Ingots.COPPER.getMeta()], 0.7F);
        smelting(ItemList.chunks[ItemList.Chunks.TIN.getMeta()], ItemList.ingots[ItemList.Ingots.TIN.getMeta()], 0.7F);
        smelting(ItemList.chunks[ItemList.Chunks.SILVER.getMeta()], ItemList.ingots[ItemList.Ingots.SILVER.getMeta()], 0.7F);
        smelting(ItemList.chunks[ItemList.Chunks.NICKEL.getMeta()], ItemList.ingots[ItemList.Ingots.NICKEL.getMeta()], 0.7F);
        smelting(ItemList.chunks[ItemList.Chunks.ZINC.getMeta()], ItemList.ingots[ItemList.Ingots.ZINC.getMeta()], 0.7F);
        smelting(ItemList.chunks[ItemList.Chunks.TITANIUM.getMeta()], ItemList.ingots[ItemList.Ingots.TITANIUM.getMeta()], 0.7F);
    }
}
