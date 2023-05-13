package com.gildedrose;

import static com.gildedrose.ItemUpdateHandler.updaterFor;

/**
 * This class is used to iterate over all the items and applies the
 * corresponding update logic based on the item's type.
 */

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item currentItem : items) {
			updaterFor(currentItem).update(currentItem);
		}
	}
}
