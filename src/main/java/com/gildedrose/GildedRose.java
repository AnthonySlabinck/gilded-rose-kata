package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateAtEndOfDay() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        updateQuality(item);

        updateSellIn(item);

        if (hasExpired(item)) {
            updateExpired(item);
        }
    }

    private void updateQuality(Item item) {
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
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
        } else if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    private void updateExpired(Item item) {
        if (!item.name.equals("Aged Brie")) {
            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                item.quality = item.quality - item.quality;
            }
        } else {
            incrementQuality(item);
        }
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
