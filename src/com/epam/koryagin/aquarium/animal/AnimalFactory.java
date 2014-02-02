package com.epam.koryagin.aquarium.animal;

import com.epam.koryagin.aquarium.ItemType;

public interface AnimalFactory {
	
	public Animal createAnimal(ItemType pet);

}
