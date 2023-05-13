package com.gildedrose;

public class ItemUpdateHandler {

	public static Updater updaterFor(Item currentItem) {
		if (currentItem.name.equals("Aged Brie")) {
			return new AgingItemController();
		}
		else if(currentItem.name.equals("Sulfuras, Hand of Ragnaros")) {
			return new SulfurasController();
		}
		else if(currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			return new BackstagePassesController();
		}
		else {
			return new CommonItemController();    			
		}
	}

}