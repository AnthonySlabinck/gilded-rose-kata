package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void nameRemainsUnchanged() {
        GildedRose app = createAppWithOneItem("foo", 0, 0);

        app.updateAtEndOfDay();

        assertThat("foo").isEqualTo(getFirstItem(app).name);
    }

    @Test
    void sellInDecrementsAtEndOfDay() {
        GildedRose app = createAppWithOneItem("foo", 5, 7);

        app.updateAtEndOfDay();

        assertThat(4).isEqualTo(getFirstItem(app).sellIn);
    }

    @Test
    void qualityDegradesAtEndOfDay() {
        GildedRose app = createAppWithOneItem("foo", 5, 7);

        app.updateAtEndOfDay();

        assertThat(6).isEqualTo(getFirstItem(app).quality);
    }

    @Test
    void qualityDegradesTwiceAsFastOnceSellByDateHasPassed() {
        GildedRose app = createAppWithOneItem("foo", 0, 7);

        app.updateAtEndOfDay();

        assertThat(5).isEqualTo(getFirstItem(app).quality);
    }

    @Test
    void qualityIsNeverNegative() {
        GildedRose app = createAppWithOneItem("foo", 5, 0);

        app.updateAtEndOfDay();

        assertThat(getFirstItem(app).quality).isZero();
    }

    @Test
    void agedBrieQualityIncreasesTheOlderItGets() {
        GildedRose app = createAppWithOneItem(AGED_BRIE, 5, 7);

        app.updateAtEndOfDay();

        assertThat(8).isEqualTo(getFirstItem(app).quality);
    }

    @Test
    void qualityIsNeverMoreThan50() {
        GildedRose app = createAppWithOneItem(AGED_BRIE, 5, 50);

        app.updateAtEndOfDay();

        assertThat(50).isEqualTo(getFirstItem(app).quality);
    }

    @Test
    void sulfurasNeverHasToBeSoldOrDegradesInQuality() {
        GildedRose app = createAppWithOneItem(SULFURAS, 5, 50);

        app.updateAtEndOfDay();

        Item item = getFirstItem(app);
        assertThat(5).isEqualTo(item.sellIn);
        assertThat(50).isEqualTo(item.quality);
    }

    @Test
    void backstagePassesQualityIncreasesBy1WhenThereAreMoreThan10DaysFromTheConcert() {
        GildedRose app = createAppWithOneItem(BACKSTAGE_PASS, 11, 7);

        app.updateAtEndOfDay();

        assertThat(8).isEqualTo(getFirstItem(app).quality);
    }

    @Test
    void backstagePassesQualityIncreasesBy2WhenThereAre10DaysOrLessFromTheConcert() {
        GildedRose app = createAppWithOneItem(BACKSTAGE_PASS, 10, 7);

        app.updateAtEndOfDay();

        assertThat(9).isEqualTo(getFirstItem(app).quality);
    }

    @Test
    void backstagePassesQualityIncreasesBy3WhenThereAre5DaysOrLessFromTheConcert() {
        GildedRose app = createAppWithOneItem(BACKSTAGE_PASS, 5, 7);

        app.updateAtEndOfDay();

        assertThat(10).isEqualTo(getFirstItem(app).quality);
    }

    @Test
    void backstagePassesQualityDropsToZeroAfterTheConcert() {
        GildedRose app = createAppWithOneItem(BACKSTAGE_PASS, 0, 7);

        app.updateAtEndOfDay();

        assertThat(getFirstItem(app).quality).isZero();
    }

    @Test
    public void conjuredQualityDegradesTwiceAsFast() {
        GildedRose app = createAppWithOneItem(CONJURED, 5, 7);

        app.updateAtEndOfDay();

        assertThat(5).isEqualTo(getFirstItem(app).quality);
    }

    @Test
    public void conjuredQualityDegradesBy4WhenExpired() {
        GildedRose app = createAppWithOneItem(CONJURED, 0, 7);

        app.updateAtEndOfDay();

        assertThat(3).isEqualTo(getFirstItem(app).quality);
    }

    private GildedRose createAppWithOneItem(String name, int sellIn, int quality) {
        return new GildedRose(new Item[]{new Item(name, sellIn, quality)});
    }

    private Item getFirstItem(GildedRose app) {
        return app.items[0];
    }
}
