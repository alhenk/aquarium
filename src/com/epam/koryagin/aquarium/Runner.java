/**
 * 
 */
package com.epam.koryagin.aquarium;

//import com.epam.koryagin.aquarium.print.Console;
//import com.epam.koryagin.aquarium.print.PrintBehavior;
//import com.epam.koryagin.aquarium.fish.FishType;
//import com.epam.koryagin.aquarium.item.ItemType;
//import com.epam.koryagin.aquarium.resource_manager.ResourceManager;

/**
 * Aquarium CLI application 
 * 
 * @author Koryagin
 * @date 2013.12.09
 * @version 1.0.0
 * release 20140203
 */
public class Runner {
	//private static final PrintBehavior OUTPUT = new Console();

	public static void main(String[] args) {
//		Actions.sampleAquarium();
//		Actions.printAllAvailableItems();
//		ItemType animal = FishType.ANGELFISH;
//		OUTPUT.println(animal.getClass());
		
		//OUTPUT.println(ResourceManager.fishDao.fetchFishMaxPrice());
		//OUTPUT.printf("%d",4);
		Actions.runMenu();
	
	}
}
