package com.gildedrose;

import static com.gildedrose.ItemUpdateHandler.updaterFor;

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
