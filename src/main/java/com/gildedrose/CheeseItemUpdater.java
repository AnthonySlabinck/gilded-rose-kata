package com.gildedrose;

public class CheeseItemUpdater extends DefaultItemUpdater {

    @Override
    protected void updateQuality(Item item) {
        incrementQuality(item);
    }

    @Override
    protected void updateExpired(Item item) {
        incrementQuality(item);
    }
}
