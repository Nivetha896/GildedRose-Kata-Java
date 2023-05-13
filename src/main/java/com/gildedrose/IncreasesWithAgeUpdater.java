package com.gildedrose;

/**
 * This class implements the Updater interface and provides the logic to update
 * the quality and sell-in value for Aged Brie item .If the
 * quality of the item is less than 50, it increases by 1. The sell-in value is
 * decremented by 1.
 */
public class IncreasesWithAgeUpdater implements Updater {

	public void update(Item item) {
		if (item.quality < 50) {
			item.quality++;
		}
		item.sellIn--;
	}

}
