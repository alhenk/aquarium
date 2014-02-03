/**
 * 
 */
package com.epam.koryagin.aquarium;

import com.epam.koryagin.aquarium.animal.FishType;

/**
 * Aquarium CLI application 
 * 
 * @author Koryagin
 * @date 2013.12.09
 * @version 1.0.0
 */
public class Runner {

	public static void main(String[] args) {
		Actions.sampleAquarium();
		Actions.printAllAvailableItems();
		ItemType animal = FishType.ANGELFISH;
		System.out.println(animal.getClass());
		Actions.runMenu();
		//
	}
}
