package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemUpdaterFactoryTest {

    private ItemUpdaterFactory itemUpdaterFactory;

    @BeforeEach
    public void init() {
        itemUpdaterFactory = new ItemUpdaterFactory();
    }

    @Test
    public void createsDefaultItemUpdater() {
        assertThat(itemUpdaterFactory.createItemUpdater(createItemWithName("foo")))
                .isInstanceOf(DefaultItemUpdater.class);
    }

    @Test
    public void createLegendaryItemUpdater() {
        assertThat(itemUpdaterFactory.createItemUpdater(createItemWithName(SULFURAS)))
                .isInstanceOf(LegendaryItemUpdater.class);
    }

    @Test
    public void createCheeseItemUpdater() {
        assertThat(itemUpdaterFactory.createItemUpdater(createItemWithName(AGED_BRIE)))
                .isInstanceOf(CheeseItemUpdater.class);
    }

    @Test
    public void createBackstagePassItemUpdater() {
        assertThat(itemUpdaterFactory.createItemUpdater(createItemWithName(BACKSTAGE_PASS)))
                .isInstanceOf(BackstagePassItemUpdater.class);
    }

    private Item createItemWithName(String name) {
        return new Item(name, 0, 0);
    }
}
