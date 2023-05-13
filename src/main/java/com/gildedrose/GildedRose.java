package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item currentItem : items) {
			if (currentItem.name.equals("Aged Brie")) {
				AgingItemController agingItemController = new AgingItemController();
				agingItemController.update(currentItem);

			} else if (currentItem.name.equals("Sulfuras, Hand of Ragnaros")) {

			} else if (currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				BackstagePassesController backstagePassesController = new BackstagePassesController();
				backstagePassesController.update(currentItem);

			} else {
				CommonItemController commonItemController = new CommonItemController();
				commonItemController.update(currentItem);
			}
		}
	}
}
