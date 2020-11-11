package com.gildedrose;

public class DefaultItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        updateQuality(item);

        updateSellIn(item);

        if (hasExpired(item)) {
            updateExpired(item);
        }
    }

    protected void updateQuality(Item item) {
        decrementQuality(item);
    }

    protected void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected void updateExpired(Item item) {
        decrementQuality(item);
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    protected void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
