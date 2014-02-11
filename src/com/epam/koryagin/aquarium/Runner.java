/**
 * 
 */
package com.epam.koryagin.aquarium;

import com.epam.koryagin.aquarium.accessory.Accessory;
import com.epam.koryagin.aquarium.fish.Fish;
import com.epam.koryagin.aquarium.reptile.Reptile;
import com.epam.koryagin.aquarium.resource_manager.AccessoryDAO;
import com.epam.koryagin.aquarium.resource_manager.FishDAO;
import com.epam.koryagin.aquarium.resource_manager.ReptileDAO;

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
		System.out.println();
		ReptileDAO reptileDAO = new ReptileDAO();
		Reptile reptile = (Reptile)(reptileDAO.fetchItem(12));
		System.out.println(reptile);
		System.out.println(reptile.getDescription());
		System.out.println(reptile.getSize());
		System.out.println(reptile.getTankVolumeMin());
		System.out.println();
		AccessoryDAO accessoryDAO = new AccessoryDAO();
		Accessory accessory = (Accessory)(accessoryDAO.fetchItem(1));
		System.out.println(accessory);

		
		
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
