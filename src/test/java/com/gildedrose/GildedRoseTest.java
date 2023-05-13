package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
	// Aged Brie
	@Test
	public void quality_increases_at_the_end_of_each_day() throws Exception {
		Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(9, app.items[0].sellIn);
		assertEquals(11, app.items[0].quality);
	}

	// Aged Brie
	@Test
	public void quality_above_50_never_increases() throws Exception {
		Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(9, app.items[0].sellIn);
		assertEquals(50, app.items[0].quality);
	}

	// Sulfuras
	@Test
	public void never_lowers_sulfuras_quality_and_sellIn_values() throws Exception {
		Item[] items = new Item[] {
				new ItemBuilder().called("Sulfuras, Hand of Ragnaros").toBeSoldIn(10).ofQuality(10).build() };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(10, app.items[0].sellIn);
		assertEquals(10, app.items[0].quality);
	}

//Backstage Passes
	@Test
	public void increases_quality_at_the_end_of_each_day() throws Exception {
		Item[] items = new Item[] { new ItemBuilder().called("Backstage passes to a TAFKAL80ETC concert").toBeSoldIn(20)
				.ofQuality(10).build() };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(19, app.items[0].sellIn);
		assertEquals(11, app.items[0].quality);
	}

	// Backstage Passes
	@Test
	public void never_increases_when_quality_above_50() throws Exception {
		Item[] items = new Item[] { new ItemBuilder().called("Backstage passes to a TAFKAL80ETC concert").toBeSoldIn(20)
				.ofQuality(50).build() };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(19, app.items[0].sellIn);
		assertEquals(50, app.items[0].quality);
	}

	// Backstage Passes
	@Test
	public void backstage_passes_quality_increases_sellIn_value_is_equal_or_less_than_10() throws Exception {
		Item[] items = new Item[] { new ItemBuilder().called("Backstage passes to a TAFKAL80ETC concert").toBeSoldIn(10)
				.ofQuality(10).build() };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(9, app.items[0].sellIn);
		assertEquals(12, app.items[0].quality);
	}

	// Backstage Passes
	@Test
	public void quality_increases_thrice_sellIn_value_is_equal_or_less_than_5() throws Exception {
		Item[] items = new Item[] { new ItemBuilder().called("Backstage passes to a TAFKAL80ETC concert").toBeSoldIn(5)
				.ofQuality(10).build() };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(4, app.items[0].sellIn);
		assertEquals(13, app.items[0].quality);
	}

	// Backstage Passes
	@Test
	public void quality_to_zero_when_past_expiration_date() throws Exception {
		Item[] items = new Item[] { new ItemBuilder().called("Backstage passes to a TAFKAL80ETC concert")
				.pastExpirationDate().ofQuality(10).build() };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(-1, app.items[0].sellIn);
		assertEquals(0, app.items[0].quality);
	}

	// common
	@Test
	public void lowers_quality_twice_when_past_expiration_date() throws Exception {
		Item[] items = new Item[] { new ItemBuilder().called("Any Item").pastExpirationDate().ofQuality(10).build() };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(-1, app.items[0].sellIn);
		assertEquals(8, app.items[0].quality);
	}

	// Common
	@Test
	public void never_lowers_quality_value_below_zero() throws Exception {
		Item[] items = new Item[] { new ItemBuilder().called("Any Item").toBeSoldIn(10).ofQuality(0).build() };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(9, app.items[0].sellIn);
		assertEquals(0, app.items[0].quality);
	}

	// Conjured Items
	@Test
	public void Conjured_items_decreases_quality_twice() throws Exception {
		Item[] items = new Item[] { new ItemBuilder().called("Conjured Mana Cake").toBeSoldIn(10).ofQuality(10).build() };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(9, app.items[0].sellIn);
		assertEquals(8, app.items[0].quality);
	}

	// Conjured Items
	@Test
	public void never_lowers_soulstones_quality_below_zero() throws Exception {
		Item[] items = new Item[] { new ItemBuilder().called("Conjured Mana Cake").toBeSoldIn(10).ofQuality(0).build() };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(9, app.items[0].sellIn);
		assertEquals(0, app.items[0].quality);
	}

}