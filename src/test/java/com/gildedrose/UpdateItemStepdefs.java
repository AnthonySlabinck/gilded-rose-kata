package com.gildedrose;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateItemStepdefs {

    private Item item;
    private GildedRose app;

    @Given("an item with name {string}, sell in {int} and quality {int}")
    public void anItem(String name, Integer sellIn, Integer quality) {
        item = new Item(name, sellIn, quality);
        app = new GildedRose(new Item[]{item});
    }

    @When("the item is updated at the end of the day")
    public void updateAtEndOfDay() {
        app.updateAtEndOfDay();
    }

    @Then("sell in should be {int}")
    public void sellInShouldBe(int newSellIn) {
        assertThat(item.sellIn).isEqualTo(newSellIn);
    }

    @Then("quality should be {int}")
    public void qualityShouldBe(int newQuality) {
        assertThat(item.quality).isEqualTo(newQuality);
    }
}
