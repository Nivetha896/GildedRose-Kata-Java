package com.gildedrose;

public class ItemUpdateHandler {

	public static Updater updaterFor(Item currentItem) {
		if (improvesWithAge(currentItem)) {
			return new AgingItemController();
		}
		else if(isLegendary(currentItem)) {
			return new SulfurasController();
		}
		else if(isBackstagePass(currentItem)) {
			return new BackstagePassesController();
		}
		else if(isConjured(currentItem)) {
			return new ConjuredItemController();
		}
		else {
			return new CommonItemController();    	   			
		}
	}
	
	private static boolean isBackstagePass(Item item) {
		return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
	}

	private static boolean isLegendary(Item item) {
		return "Sulfuras, Hand of Ragnaros".equals(item.name);
	}

	private static boolean improvesWithAge(Item item) {
		return "Aged Brie".equals(item.name);
	}
	private static boolean isConjured(Item item) {
		return "Conjured Mana Cake".equals(item.name);
	}



}