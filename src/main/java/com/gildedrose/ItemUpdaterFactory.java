package com.gildedrose;

public class ItemUpdaterFactory {

    public ItemUpdater createItemUpdater(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new LegendaryItemUpdater();
        } else if (item.name.equals("Aged Brie")) {
            return new CheeseItemUpdater();
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePassItemUpdater();
        }
        return new DefaultItemUpdater();
    }
}
