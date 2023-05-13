package com.gildedrose;

public class AgingItemController {

	public void update(Item item) {
		if (item.quality < 50) {
			item.quality++;
		}
		item.sellIn--;
	}
	
}
