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
        if (item.name.equals("Aged Brie")) {
            incrementQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            incrementQuality(item);

            if (item.sellIn < 11) {
                incrementQuality(item);
            }

            if (item.sellIn < 6) {
                incrementQuality(item);
            }
        } else {
            decrementQuality(item);
        }
    }

    protected void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected void updateExpired(Item item) {
        if (item.name.equals("Aged Brie")) {
            incrementQuality(item);
        } else {
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = 0;
            } else {
                decrementQuality(item);
            }
        }
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    private void incrementQuality(Item item) {
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
