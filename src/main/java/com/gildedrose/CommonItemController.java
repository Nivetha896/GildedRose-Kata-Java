package com.gildedrose;

public class CommonItemController implements Updater{
	
	public void update(Item item)  {
		if (item.quality > 0) {
			item.quality--;
		}
		item.sellIn--;

		if (item.sellIn < 0 && item.quality > 0) {
			item.quality--;
		}
	}
}
