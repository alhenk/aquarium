/**
 * 
 */
package com.epam.koryagin.aquarium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import com.epam.koryagin.aquarium.fish.Fish;
import com.epam.koryagin.aquarium.fish.FishFactory;
import com.epam.koryagin.aquarium.item.Item;
import com.epam.koryagin.aquarium.item.ItemComparator;
import com.epam.koryagin.aquarium.item.ItemComparator.ComparatorType;

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
	public static final  ResourceBundle fishProperties = ResourceBundle.getBundle("com.epam.koryagin.aquarium.resources.fish");
	public static void main(String[] args) {
//		Tank tank = Actions.sampleAquarium();
//		List<Animal> list = tank.getInhabitants();
//		Collections.sort(list);
//		printList((ArrayList<Animal>)list);
		FishFactory ff = new FishFactory();
		List<Item> fish = new ArrayList<Item>();
		fish.add((Item)ff.createAnimal(1));
		fish.add((Fish)ff.createAnimal(2));
		fish.add((Fish)ff.createAnimal(3));
		fish.add((Fish)ff.createAnimal(4));
		fish.add((Fish)ff.createAnimal(5));
		fish.add((Fish)ff.createAnimal(6));
		fish.add((Fish)ff.createAnimal(7));
		fish.add((Fish)ff.createAnimal(8));
		fish.add((Fish)ff.createAnimal(9));
		fish.add((Fish)ff.createAnimal(10));
		ItemComparator ic = new ItemComparator(fish,ComparatorType.PRICE);
		printList((ArrayList<Item>)fish);
		
		System.out.println();
		System.out.println();
		
		Collections.sort(fish, ic);
		printList((ArrayList<Item>)fish);
		
		ic = new ItemComparator(fish,ComparatorType.NAME);
		System.out.println();
		System.out.println();
		
		Collections.sort(fish, ic);
		printList((ArrayList<Item>)fish);
		
		System.out.println();
		System.out.println();
		
		Collections.sort(fish);
		
//		FishDAO fishDAO = new FishDAO();
//		Fish fish = (Fish)(fishDAO.getItem(11));
//		System.out.println(fish);
//		System.out.println(fish.getDescription());
//		System.out.println(fish.getSize());
//		System.out.println(fish.getTankVolumeMin());
//		System.out.println();
//		ReptileDAO reptileDAO = new ReptileDAO();
//		Reptile reptile = (Reptile)(reptileDAO.getItem(12));
//		System.out.println(reptile);
//		System.out.println(reptile.getDescription());
//		System.out.println(reptile.getSize());
//		System.out.println(reptile.getTankVolumeMin());
//		System.out.println();
//		AccessoryDAO accessoryDAO = new AccessoryDAO();
//		Accessory accessory = (Accessory)(accessoryDAO.getItem(1));
//		System.out.println(accessory);
//		System.out.println();
//		TankDAO tankDAO = new TankDAO();
//		Tank tank = (Tank)(tankDAO.getItem(2));
//		System.out.println(tank);
		
//
//		Actions.printAllAvailableItems();
		
//		ItemType animal = FishType.ANGELFISH;
//		OUTPUT.println(animal.getClass());
		
		//OUTPUT.println(ResourceManager.fishDao.fetchFishMaxPrice());
		//OUTPUT.printf("%d",4);
		
		//Actions.runMenu();
	}
		

	private static void printList(ArrayList<Item> list){
		for(Item a : list){
			System.out.println(a);
		}
	}
	
}
