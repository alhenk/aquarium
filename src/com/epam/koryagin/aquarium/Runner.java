/**
 * 
 */
package com.epam.koryagin.aquarium;

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
		Actions.runMenu();
		
	}
}
