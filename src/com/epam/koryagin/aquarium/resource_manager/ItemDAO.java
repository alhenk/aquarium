package com.epam.koryagin.aquarium.resource_manager;

import com.epam.koryagin.aquarium.item.Item;

public interface ItemDAO {
	public Item fetchItem(int uid);
}
