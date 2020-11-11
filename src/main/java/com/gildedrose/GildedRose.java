package com.gildedrose;

class GildedRose {

    Item[] items;

    private ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateAtEndOfDay() {
        for (Item item : items) {
            ItemUpdater itemUpdater = itemUpdaterFactory.createItemUpdater(item);
            itemUpdater.update(item);
        }
    }
}
