package com.gildedrose;

/**
 * This class implements the Updater interface and provides the logic for
 * updating the quality and sellIn values of Backstage Passes items. It
 * increases the quality of the item as the sellIn value decreases, with a
 * greater increase as the concert date approaches. When the concert is over,
 * the quality drops to zero.
 *
 */
public class ConcertQualityUpdater implements Updater {

	public void update(Item item) {
		if (isAfterTheConcert(item)) {
			item.quality = 0;
		} else if (item.quality < 50) {
			Integer qualityIncrease = qualityIncreaseBy(item.sellIn);
			item.quality += qualityIncrease;
		}
		item.sellIn--;
	}

	private Integer qualityIncreaseBy(Integer remainingDaysBeforeConcert) {
		if (remainingDaysBeforeConcert <= 5) {
			return 3;
		} else if (remainingDaysBeforeConcert <= 10) {
			return 2;
		} else {
			return 1;
		}
	}

	private boolean isAfterTheConcert(Item item) {
		return item.sellIn <= 0;
	}

}