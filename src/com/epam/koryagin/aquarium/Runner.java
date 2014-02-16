/**
 * 
 */
package com.epam.koryagin.aquarium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.fish.FishFactory;
import com.epam.koryagin.aquarium.reptile.ReptileFactory;

/**
 * Aquarium CLI application
 * 
 * @author Koryagin
 * @date 2013.12.09
 * @version 1.0.0 release 20140203
 */
public class Runner {
	// private static final PrintBehavior OUTPUT = new Console();
	public static final ResourceBundle fishProperties = ResourceBundle
			.getBundle("com.epam.koryagin.aquarium.resources.fish");

	public static void main(String[] args) {
		// Tank tank = Actions.sampleAquarium();
		// List<Animal> list = tank.getInhabitants();
		// Collections.sort(list);
		// printList((ArrayList<Animal>)list);
		FishFactory ff = new FishFactory();
		List<Animal> fish = new ArrayList<Animal>();
		fish.add(ff.createAnimal(1));
		fish.add(ff.createAnimal(2));
		fish.add(ff.createAnimal(3));
		fish.add(ff.createAnimal(4));
		fish.add(ff.createAnimal(5));
		fish.add(ff.createAnimal(6));
		fish.add(ff.createAnimal(7));
		fish.add(ff.createAnimal(8));
		fish.add(ff.createAnimal(9));
		fish.add(ff.createAnimal(10));
		//ItemComparator ic = new ItemComparator(ComparatorType.PRICE);
		System.out.println("UNSORTED :");
		printList((List<Animal>) fish);

		System.out.println();
		System.out.println();

		Collections.sort(fish, Animal.SIZE_COMPARATOR);
		System.out.println("SORT BY SIZE :");
		printList((ArrayList<Animal>) fish);

		//ic = new ItemComparator(ComparatorType.NAME);
		System.out.println();
		System.out.println();

		Collections.sort(fish, Animal.NAME_COMPARATOR);
		System.out.println("SORT BY NAME :");
		printList((ArrayList<Animal>) fish);

		System.out.println();
		System.out.println();
		
		Collections.sort(fish, Animal.PRICE_COMPARATOR);
		System.out.println("SORT BY PRICE :");
		printList((ArrayList<Animal>) fish);

		System.out.println();
		System.out.println();

		Collections.sort(fish);
		System.out.println("SORT BY NATURAL ORDRDER (COMPARABLE) :");
		printList((ArrayList<Animal>) fish);
		
		System.out.println();
		System.out.println();

		// FishDAO fishDAO = new FishDAO();
		// Fish fish = (Fish)(fishDAO.getItem(11));
		// System.out.println(fish);
		// System.out.println(fish.getDescription());
		// System.out.println(fish.getSize());
		// System.out.println(fish.getTankVolumeMin());
		// System.out.println();
		// ReptileDAO reptileDAO = new ReptileDAO();
		// Reptile reptile = (Reptile)(reptileDAO.getItem(12));
		// System.out.println(reptile);
		// System.out.println(reptile.getDescription());
		// System.out.println(reptile.getSize());
		// System.out.println(reptile.getTankVolumeMin());
		// System.out.println();
		// AccessoryDAO accessoryDAO = new AccessoryDAO();
		// Accessory accessory = (Accessory)(accessoryDAO.getItem(1));
		// System.out.println(accessory);
		// System.out.println();
		// TankDAO tankDAO = new TankDAO();
		// Tank tank = (Tank)(tankDAO.getItem(2));
		// System.out.println(tank);

		//
		// Actions.printAllAvailableItems();

		// ItemType animal = FishType.ANGELFISH;
		// OUTPUT.println(animal.getClass());

		// OUTPUT.println(ResourceManager.fishDao.fetchFishMaxPrice());
		// OUTPUT.printf("%d",4);

		//Actions.runMenu();
		
		ReptileFactory rf = new ReptileFactory();
		List<Animal> reptile = new ArrayList<Animal>();
		reptile.add(rf.createAnimal(1));
		reptile.add(rf.createAnimal(2));
		reptile.add(rf.createAnimal(3));
		reptile.add(rf.createAnimal(4));
		reptile.add(rf.createAnimal(5));
		reptile.add(rf.createAnimal(6));
		reptile.add(rf.createAnimal(7));
		reptile.add(rf.createAnimal(8));
		reptile.add(rf.createAnimal(9));
		System.out.println("UNSORTED :");
		printList((List<Animal>) reptile);

		System.out.println();
		System.out.println();

		Collections.sort(reptile, Animal.SIZE_COMPARATOR);
		System.out.println("SORT BY SIZE :");
		printList((ArrayList<Animal>) reptile);
		
		System.out.println();
		System.out.println();

		Collections.sort(reptile, Animal.NAME_COMPARATOR);
		System.out.println("SORT BY NAME :");
		printList((ArrayList<Animal>) reptile);
		
		System.out.println();
		System.out.println();

		Collections.sort(reptile, Animal.PRICE_COMPARATOR);
		System.out.println("SORT BY PRICE :");
		printList((ArrayList<Animal>) reptile);
	}

	private static void printList(List<Animal> fish) {
		for (Animal a : fish) {
			System.out.println(a);
		}
	}

}
