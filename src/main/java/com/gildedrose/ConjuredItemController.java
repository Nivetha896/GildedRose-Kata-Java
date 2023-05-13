package com.gildedrose;

/**
 * This class implements the Updater interface for updating "Conjured" items.It
 * reduces the quality of the item by 2 and updates the sell-in value by 1 each
 * day. If the quality of the item falls below 0, it sets it to 0.
 */
public class ConjuredItemController implements Updater {

	public void update(Item item) {
		item.quality -= 2;
		if (item.quality < 0) {
			item.quality = 0;
		}
		item.sellIn--;
	}

}
