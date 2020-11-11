package com.gildedrose;

public class ConjuredItemUpdater extends DefaultItemUpdater {

    @Override
    protected void updateQuality(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }

    @Override
    protected void updateExpired(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }
}
