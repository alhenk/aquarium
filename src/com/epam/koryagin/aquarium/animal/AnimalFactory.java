package com.epam.koryagin.aquarium.animal;

import com.epam.koryagin.aquarium.item.ItemType;

public interface AnimalFactory {
	
	public Animal createAnimal(ItemType pet);

}
