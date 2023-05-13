package com.gildedrose;

import java.util.List;
import java.util.Map;
import static java.util.Arrays.asList;

import com.google.common.collect.ImmutableMap;

public class ItemUpdateHandler {

	private static Map<String, List<String>> itemTypes = ImmutableMap.<String, List<String>>builder()
			.put("backstage-passes", asList("Backstage passes to a TAFKAL80ETC concert"))
			.put("legendary", asList("Sulfuras, Hand of Ragnaros"))
			.put("improves-with-age", asList("Aged Brie"))
			.put("conjured", asList("Conjured Mana Cake"))
			.build();

	public static Updater updaterFor(Item currentItem) {
		if (improvesWithAge(currentItem)) {
			return new AgingItemController();
		} else if (isLegendary(currentItem)) {
			return new SulfurasController();
		} else if (isBackstagePass(currentItem)) {
			return new BackstagePassesController();
		} else if (isConjured(currentItem)) {
			return new ConjuredItemController();
		} else {
			return new CommonItemController();
		}
	}

	private static boolean isBackstagePass(Item item) {
		return itemTypes.get("backstage-passes").contains(item.name);
	}

	private static boolean isLegendary(Item item) {
		return itemTypes.get("legendary").contains(item.name);
	}

	private static boolean improvesWithAge(Item item) {
		return itemTypes.get("improves-with-age").contains(item.name);
	}

	private static boolean isConjured(Item item) {
		return itemTypes.get("conjured").contains(item.name);
	}

}