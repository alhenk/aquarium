package com.epam.koryagin.aquarium;

import java.util.Scanner;

import com.epam.koryagin.aquarium.accessory.Accessory;
import com.epam.koryagin.aquarium.accessory.AccessoryFactory;
import com.epam.koryagin.aquarium.accessory.AccessoryType;
import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.fish.FishFactory;
import com.epam.koryagin.aquarium.fish.FishType;
import com.epam.koryagin.aquarium.menu.Menu;
import com.epam.koryagin.aquarium.menu.State;
import com.epam.koryagin.aquarium.print.Console;
import com.epam.koryagin.aquarium.print.PrintBehavior;
import com.epam.koryagin.aquarium.reptile.ReptileFactory;
import com.epam.koryagin.aquarium.reptile.ReptileType;
import com.epam.koryagin.aquarium.tank.Tank;
import com.epam.koryagin.aquarium.tank.TankManager;
import com.epam.koryagin.aquarium.tank.TankType;

import org.apache.log4j.Logger;

/**
 * Class Action with all static methods that implements Steps of Execution 
 * (USE CASE) and some useful tests
 * 
 * @author Koryagin
 * @date 2013.12.12
 * @version 1.0.0
 */
public class Actions {
	private static final Logger LOGGER = Logger.getLogger(Actions.class);
	private static final PrintBehavior OUTPUT = new Console();
	
	
	
	/**
	 * Private constructor, 
	 * utility class with only static methods
	 */
	private Actions(){
		super();
	}
	
	/**
	 * sampleAquarium creates an instance of Tank,
	 * populates it with some animals
	 * and equips it with a number of accessories
	 * @return the tank
	 */
	public static Tank sampleAquarium() {
		ReptileFactory rf = new ReptileFactory();
		FishFactory ff = new FishFactory();
		AccessoryFactory am = new AccessoryFactory();
		TankManager tm = new TankManager();

		Tank tank = tm.createTank(TankType.TROPICAL_AQUARIUM);
		tank.addAccessory(am.createAccessory(AccessoryType.LAMP));
		tank.addAccessory(am.createAccessory(AccessoryType.PUMP));
		tank.addAccessory(am.createAccessory(AccessoryType.THERMOMETER));
		tank.addAccessory(am.createAccessory(AccessoryType.SAND));

		tank.addAnimal(ff.createAnimal(FishType.CARDINALFISH));
		tank.addAnimal(ff.createAnimal(FishType.BOXFISH));
		tank.addAnimal(ff.createAnimal(FishType.HOGFISH));

		tank.addAnimal(rf.createAnimal(ReptileType.FROG));
		tank.addAnimal(rf.createAnimal(ReptileType.TERRAPIN));

		
		OUTPUT.println(tank);
		OUTPUT.print("TOTAL SUM: $");
		OUTPUT.printf("%.2f\n\n", tm.calculateTotalSum(tank));
		LOGGER.info("Sample tank created");
		return tank;
	}

	/**
	 * Print out lists of Reptiles, Fishes, Tanks and Accessories for test
	 * purpose
	 */
	public static void printAllAvailableItems() {
		ReptileFactory rf = new ReptileFactory();
		FishFactory ff = new FishFactory();
		AccessoryFactory am = new AccessoryFactory();
		TankManager tm = new TankManager();

		OUTPUT.println("REPTILES :");
		for (ReptileType reptile : ReptileType.values()) {
			Animal animal = rf.createAnimal(reptile);
			OUTPUT.println(animal);
		}
		OUTPUT.println();

		OUTPUT.println("FISHES :");
		for (FishType fish : FishType.values()) {
			Animal animal = ff.createAnimal(fish);
			OUTPUT.println(animal);
		}
		OUTPUT.println();

		OUTPUT.println("TANKS :");

		for (TankType t : TankType.values()) {
			Tank tank = tm.createTank(t);
			OUTPUT.println(tank);
		}
		OUTPUT.println();

		OUTPUT.println("ACCESSORIES :");
		for (AccessoryType a : AccessoryType.values()) {
			Accessory accessory = am.createAccessory(a);
			OUTPUT.println(accessory);
		}
	}

	public static void runMenu() {
		Menu menu = new Menu();
		int command = 0;
		State state = State.START;
		Scanner userInput = new Scanner(System.in);
		OUTPUT.println();
		OUTPUT.println("Choose Tank:");
		menu.displayInitTankMenu();
		try {
			while (state != State.EXIT) {
				if (userInput.hasNext()) {
					if (!userInput.hasNextInt()){
						userInput.next();
						OUTPUT.println("Please enter a digit.");
						continue;
					}
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
			OUTPUT.println("BYE");
		} catch (Exception e) {
			OUTPUT.println(e);
		} finally {
			userInput.close();
		}
	}
}
