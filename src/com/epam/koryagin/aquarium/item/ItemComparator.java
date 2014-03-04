package com.epam.koryagin.aquarium.item;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {
	private ComparatorType comparatorType;

	public enum ComparatorType {
		NAME, PRICE;
	}

	public ItemComparator(ComparatorType comparatorType) {
		this.comparatorType = comparatorType;
	}

	@Override
	public int compare(Item item1, Item item2) {
		switch (comparatorType) {
		case NAME:
			return item1.getName().compareToIgnoreCase(item2.getName());
		case PRICE:
			return item1.getPrice().compareTo(item2.getPrice());
		default:
			return item1.compareTo(item2); // compare UID
		}
	}
}
