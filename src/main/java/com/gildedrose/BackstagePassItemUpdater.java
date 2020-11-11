package com.gildedrose;

public class BackstagePassItemUpdater extends DefaultItemUpdater {

    @Override
    protected void updateQuality(Item item) {
        incrementQuality(item);

        if (item.sellIn < 11) {
            incrementQuality(item);
        }

        if (item.sellIn < 6) {
            incrementQuality(item);
        }
    }

    @Override
    protected void updateExpired(Item item) {
        item.quality = 0;
    }
}
