package com.gildedrose;

/**
 * This class implements the Updater interface and represents the update logic
 * for the legendary items that never change their sell-in value and their
 * quality
 */
public class SulfurasController implements Updater {

	public void update(Item item) {
		//since the Sulfuras item is a legendary item, its properties never change. 
		//Therefore, there is no need to update the Sulfuras item's properties.
	}

}