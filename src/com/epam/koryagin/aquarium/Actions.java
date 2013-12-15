package com.epam.koryagin.aquarium;

import java.util.Scanner;

import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.animal.FishFactory;
import com.epam.koryagin.aquarium.animal.Fishes;
import com.epam.koryagin.aquarium.animal.ReptileFactory;
import com.epam.koryagin.aquarium.animal.Reptiles;
import com.epam.koryagin.aquarium.menu.Menu;
import com.epam.koryagin.aquarium.menu.States;
import com.epam.koryagin.aquarium.tank.Accessories;
import com.epam.koryagin.aquarium.tank.Accessory;
import com.epam.koryagin.aquarium.tank.Tank;
import com.epam.koryagin.aquarium.tank.TankManager;
import com.epam.koryagin.aquarium.tank.Tanks;

/**
 * Class Action with all static methods that implements Steps of Execution 
 * (USE CASE) and some useful tests
 * 
 * @author Koryagin
 * @date 2013.12.12
 * @version 1.0.0
 */
public class Actions {
	/**
	 * sampleAquarium creates an instance of Tank populates it with some animals
	 * and equips it with a number of accessories
	 * 
	 * @return the tank
	 */
	
	/**
	 * Private constructor
	 */
	private Actions(){
		super();
	}
	
	public static Tank sampleAquarium() {
		ReptileFactory rf = new ReptileFactory();
		FishFactory ff = new FishFactory();
		TankManager tm = new TankManager();

		Tank tank = tm.createTank(Tanks.TROPICAL_AQUARIUM);
		tank.addAccessory(tm.createAccessory(Accessories.LAMP));
		tank.addAccessory(tm.createAccessory(Accessories.PUMP));
		tank.addAccessory(tm.createAccessory(Accessories.THERMOMETER));
		tank.addAccessory(tm.createAccessory(Accessories.SAND));

		tank.addAnimal(ff.createAnimal(Fishes.CARDINALFISH));
		tank.addAnimal(ff.createAnimal(Fishes.BOXFISH));
		tank.addAnimal(ff.createAnimal(Fishes.HOGFISH));

		tank.addAnimal(rf.createAnimal(Reptiles.FROG));
		tank.addAnimal(rf.createAnimal(Reptiles.TERRAPIN));

		System.out.println(tank);
		System.out.print("TOTAL SUM: $");
		System.out.printf("%.2f\n\n", tm.calculateTotalSum(tank));
		return tank;
	}

	/**
	 * Print out lists of Reptiles, Fishes, Tanks and Accessories for test
	 * purpose
	 */
	public static void printAllAvailableItems() {
		ReptileFactory rf = new ReptileFactory();
		FishFactory ff = new FishFactory();
		TankManager tm = new TankManager();

		System.out.println("REPTILES :");
		for (Reptiles reptile : Reptiles.values()) {
			Animal animal = rf.createAnimal(reptile);
			System.out.println(animal);
		}
		System.out.println();

		System.out.println("FISHES :");
		for (Fishes fish : Fishes.values()) {
			Animal animal = ff.createAnimal(fish);
			System.out.println(animal);
		}
		System.out.println();

		System.out.println("TANKS :");

		for (Tanks t : Tanks.values()) {
			Tank tank = tm.createTank(t);
			System.out.println(tank);
		}
		System.out.println();

		System.out.println("ACCESSORIES :");
		for (Accessories a : Accessories.values()) {
			Accessory accessory = tm.createAccessory(a);
			System.out.println(accessory);
		}
	}

	public static void runMenu() {
		Menu menu = new Menu();
		int command = 0;
		States state = States.START;
		Scanner userInput = new Scanner(System.in);
		System.out.println();
		System.out.println("Choose Tank:");
		menu.displayInitTankMenu();
		try {
			while (state != States.EXIT) {
				if (userInput.hasNextInt()) {
					command = userInput.nextInt();
					state = menu.oneStep(command);
					switch (state){
					case EQUIP_AND_POPULATE:
						menu.displayEquipMenu();
						break;
					case EXIT:
						break;
					case INIT_TANK:
						menu.displayInitTankMenu();
						break;
					case SELECT_ACCESSORIES:
						menu.displayAccessoryMenu();
						break;
					case SELECT_FISHES:
						menu.displayFishMenu();
						break;
					case SELECT_REPTILES:
						menu.displayReptileMenu();
						break;
					case START:
						break;
					default:
						break;
					}
				}
			}
			System.out.println("BYE");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			userInput.close();
		}
	}
}
