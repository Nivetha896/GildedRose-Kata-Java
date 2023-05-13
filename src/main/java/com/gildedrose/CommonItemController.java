package com.gildedrose;

/**
 * An updater that handles the update logic for a common item.
 * 
 * This class implements the Updater interface and provides custom logic for
 * updating the sell-in value and quality of a common item. Common items
 * decrease in quality and sell-in value by one each day, and their quality
 * decreases by an additional point after the sell-by date has passed. If the
 * quality of a common item is already zero, it will not decrease any further.
 */

public class CommonItemController implements Updater {

	public void update(Item item) {

		if (canLowerQuality(item)) {
			item.quality--;
			if (pastExpirationDate(item)) {
				item.quality--;
			}
		}

		item.sellIn--;

	}

	// Determines whether the sell-by date of an item has passed.
	private boolean pastExpirationDate(Item item) {
		return item.sellIn <= 0;
	}

	// Determines whether the item's quality can be lowered.
	private boolean canLowerQuality(Item item) {
		return item.quality > 0;
	}

}