/**
 * 
 */
package com.epam.koryagin.aquarium;

//import com.epam.koryagin.aquarium.fish.FishType;
//import com.epam.koryagin.aquarium.item.ItemType;
import com.epam.koryagin.aquarium.resource_manager.ResourceManager;

/**
 * Aquarium CLI application 
 * 
 * @author Koryagin
 * @date 2013.12.09
 * @version 1.0.0
 * release 20140203
 */
public class Runner {

	public static void main(String[] args) {
//		Actions.sampleAquarium();
//		Actions.printAllAvailableItems();
//		ItemType animal = FishType.ANGELFISH;
//		System.out.println(animal.getClass());
		
		System.out.println(ResourceManager.fishDao.fetchFishMinPrice());
		
		//Actions.runMenu();
		//
	}
}
