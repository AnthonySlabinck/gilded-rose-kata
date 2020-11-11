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
        if (item.name.equalsIgnoreCase("Sulfuras, Hand of Ragnaros")) {
            return new LegendaryItemUpdater();
        }
        return new DefaultItemUpdater();
    }
}
