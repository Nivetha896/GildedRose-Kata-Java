package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
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

}
