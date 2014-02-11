/**
 * 
 */
package com.epam.koryagin.aquarium;

import com.epam.koryagin.aquarium.fish.Fish;
import com.epam.koryagin.aquarium.resource_manager.FishDAO;

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
//		Tank tank = Actions.sampleAquarium();
//		List<Animal> list = tank.getInhabitants();
//		Collections.sort(list);
//		printList((ArrayList<Animal>)list);
		FishDAO fishDAO = new FishDAO();
		Fish fish = (Fish)(fishDAO.fetchItem(11));
		System.out.println(fish);
		System.out.println(fish.getDescription());
		System.out.println(fish.getSize());
		System.out.println(fish.getTankVolumeMin());
		
//
//		Actions.printAllAvailableItems();
		
//		ItemType animal = FishType.ANGELFISH;
//		OUTPUT.println(animal.getClass());
		
		//OUTPUT.println(ResourceManager.fishDao.fetchFishMaxPrice());
		//OUTPUT.printf("%d",4);
		//Actions.runMenu();
//		ResourceBundle fishType = ResourceBundle.getBundle("com.epam.koryagin.aquarium.resources.fishType");
//		ResourceBundle fishProperties = ResourceBundle.getBundle("com.epam.koryagin.aquarium.resources.fish");
//		Enumeration<String> list = fishType.getKeys();
//		StringBuilder sb = new StringBuilder();
//		while (list.hasMoreElements()){
//			String key = list.nextElement();
//			String value = fishType.getString(key);
//			if (Properties.checkIntegerProperty(fishType, key) == 5){
//				sb.append("fish.").append(key).append(".name");
//				System.out.print(fishProperties.getString(sb.toString())+ " -> ");
//				sb = new StringBuilder();
//				sb.append("fish.").append(key).append(".taxonomy");
//				System.out.println(fishProperties.getString(sb.toString()));
//			}
//			
//			System.out.println(key +" -> "+ value );
//		}
		
	}
//	private static void printList(ArrayList<Animal> list){
//		for(Animal a : list){
//			System.out.println(a);
//		}
//	}
	
}
