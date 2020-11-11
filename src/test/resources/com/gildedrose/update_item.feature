Feature: Update items at the end of the day

  Scenario Outline: Update item at the end of the day
    Given an item with name "<name>", sell in <sellIn> and quality <quality>
    When the item is updated at the end of the day
    Then sell in should be <newSellIn>
    And quality should be <newQuality>

    Examples:
      | name                                      | sellIn | quality | newSellIn | newQuality |
      | +5 Dexterity Vest                         | 10     | 20      | 9         | 19         |
      | +5 Dexterity Vest                         | -1     | 10      | -2        | 8          |
      | +5 Dexterity Vest                         | 10     | 0       | 9         | 0          |
      | +5 Dexterity Vest                         | -1     | 1       | -2        | 0          |
      | Aged Brie                                 | 2      | 0       | 1         | 1          |
      | Aged Brie                                 | 20     | 50      | 19        | 50         |
      | Sulfuras, Hand of Ragnaros                | 10     | 20      | 10        | 20         |
      | Backstage passes to a TAFKAL80ETC concert | 10     | 20      | 9         | 22         |
      | Backstage passes to a TAFKAL80ETC concert | 5      | 20      | 4         | 23         |
      | Backstage passes to a TAFKAL80ETC concert | 5      | 49      | 4         | 50         |
      | Backstage passes to a TAFKAL80ETC concert | 0      | 20      | -1        | 0          |
      | Conjured Mana Cake                        | 3      | 6       | 2         | 4          |
      | Conjured Mana Cake                        | 0      | 1       | -1        | -3         |
