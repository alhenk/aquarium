package com.epam.koryagin.aquarium;

import java.util.Scanner;

import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.animal.FishFactory;
import com.epam.koryagin.aquarium.animal.FishType;
import com.epam.koryagin.aquarium.animal.ReptileFactory;
import com.epam.koryagin.aquarium.animal.ReptileType;
import com.epam.koryagin.aquarium.menu.Menu;
import com.epam.koryagin.aquarium.menu.State;
import com.epam.koryagin.aquarium.tank.AccessoryType;
import com.epam.koryagin.aquarium.tank.Accessory;
import com.epam.koryagin.aquarium.tank.Tank;
import com.epam.koryagin.aquarium.tank.TankManager;
import com.epam.koryagin.aquarium.tank.TankType;

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

		Tank tank = tm.createTank(TankType.TROPICAL_AQUARIUM);
		tank.addAccessory(tm.createAccessory(AccessoryType.LAMP));
		tank.addAccessory(tm.createAccessory(AccessoryType.PUMP));
		tank.addAccessory(tm.createAccessory(AccessoryType.THERMOMETER));
		tank.addAccessory(tm.createAccessory(AccessoryType.SAND));

		tank.addAnimal(ff.createAnimal(FishType.CARDINALFISH));
		tank.addAnimal(ff.createAnimal(FishType.BOXFISH));
		tank.addAnimal(ff.createAnimal(FishType.HOGFISH));

		tank.addAnimal(rf.createAnimal(ReptileType.FROG));
		tank.addAnimal(rf.createAnimal(ReptileType.TERRAPIN));

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
		for (ReptileType reptile : ReptileType.values()) {
			Animal animal = rf.createAnimal(reptile);
			System.out.println(animal);
		}
		System.out.println();

		System.out.println("FISHES :");
		for (FishType fish : FishType.values()) {
			Animal animal = ff.createAnimal(fish);
			System.out.println(animal);
		}
		System.out.println();

		System.out.println("TANKS :");

		for (TankType t : TankType.values()) {
			Tank tank = tm.createTank(t);
			System.out.println(tank);
		}
		System.out.println();

		System.out.println("ACCESSORIES :");
		for (AccessoryType a : AccessoryType.values()) {
			Accessory accessory = tm.createAccessory(a);
			System.out.println(accessory);
		}
	}

	public static void runMenu() {
		Menu menu = new Menu();
		int command = 0;
		State state = State.START;
		Scanner userInput = new Scanner(System.in);
		System.out.println();
		System.out.println("Choose Tank:");
		menu.displayInitTankMenu();
		try {
			while (state != State.EXIT) {
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
