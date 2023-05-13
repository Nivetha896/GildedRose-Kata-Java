package com.gildedrose;

/**
 * An interface that defines a method for updating the sell-in value and quality
 * of an item.
 * 
 * Classes that implement this interface provide custom logic for updating the
 * properties of a specific type of item .Each updater is responsible for
 * checking the current state of an item and updating its sell-in value and
 * quality according to the rules of the item.
 */
public interface Updater {

	public void update(Item item);

}
