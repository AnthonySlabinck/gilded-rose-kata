package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void nameRemainsUnchanged() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);

        app.updateAtEndOfDay();

        assertEquals("foo", app.items[0].name);
    }

    @Test
    void sellInDecrementsAtEndOfDay() {
        Item[] items = new Item[]{new Item("foo", 5, 7)};
        GildedRose app = new GildedRose(items);

        app.updateAtEndOfDay();

        assertEquals(4, items[0].sellIn);
    }

    @Test
    void qualityDegradesAtEndOfDay() {
        Item[] items = new Item[]{new Item("foo", 5, 7)};
        GildedRose app = new GildedRose(items);

        app.updateAtEndOfDay();

        assertEquals(6, items[0].quality);
    }

    @Test
    void qualityDegradesTwiceAsFastOnceSellByDateHasPassed() {
        Item[] items = new Item[]{new Item("foo", 0, 7)};
        GildedRose app = new GildedRose(items);

        app.updateAtEndOfDay();

        assertEquals(5, items[0].quality);
    }

    @Test
    void qualityIsNeverNegative() {
        Item[] items = new Item[]{new Item("foo", 5, 0)};
        GildedRose app = new GildedRose(items);

        app.updateAtEndOfDay();

        assertEquals(0, items[0].quality);
    }

    @Test
    void agedBrieQualityIncreasesTheOlderItGets() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 7)};
        GildedRose app = new GildedRose(items);

        app.updateAtEndOfDay();

        assertEquals(8, items[0].quality);
    }

    @Test
    void qualityIsNeverMoreThan50() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
        GildedRose app = new GildedRose(items);

        app.updateAtEndOfDay();

        assertEquals(50, items[0].quality);
    }

    @Test
    void sulfurasNeverHasToBeSoldOrDegradesInQuality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 50)};
        GildedRose app = new GildedRose(items);

        app.updateAtEndOfDay();

        assertEquals(5, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreasesBy1WhenThereAreMoreThan10DaysFromTheConcert() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 7)};
        GildedRose app = new GildedRose(items);

        app.updateAtEndOfDay();

        assertEquals(8, items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreasesBy2WhenThereAre10DaysOrLessFromTheConcert() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 7)};
        GildedRose app = new GildedRose(items);

        app.updateAtEndOfDay();

        assertEquals(9, items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreasesBy3WhenThereAre5DaysOrLessFromTheConcert() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 7)};
        GildedRose app = new GildedRose(items);

        app.updateAtEndOfDay();

        assertEquals(10, items[0].quality);
    }

    @Test
    void backstagePassesQualityDropsToZeroAfterTheConcert() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 7)};
        GildedRose app = new GildedRose(items);

        app.updateAtEndOfDay();

        assertEquals(0, items[0].quality);
    }
}
