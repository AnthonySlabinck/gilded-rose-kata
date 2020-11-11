package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateAtEndOfDay() {
        for (Item item : items) {
            ItemUpdater itemUpdater = createItemUpdater(item);
            itemUpdater.update(item);
        }
    }

    private ItemUpdater createItemUpdater(Item item) {
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
