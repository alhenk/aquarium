package com.epam.koryagin.aquarium.tank;

import java.util.List;

import com.epam.koryagin.aquarium.animal.Animal;

/**
 * Tank Manager create an instance of Tank, create instances of accessories and
 * add them in a corresponded list of the tank properties. TM populate (add)
 * animals in the tank and calculate the total cost of the set
 * 
 * @author Koryagin
 * @date 2013.12.12
 * @version 1.0.0
 */
public class TankManager {
	// Accessories random cost constants
	// TODO move it to dedicated test/debug/simulation class
	private static final double algeaCost = generateCost(12.0, 15.0);
	private static final double filterCost = generateCost(44.99, 66.45);
	private static final double heaterCost = generateCost(7.98, 27.99);
	private static final double lampCost = generateCost(53.95, 132.85);
	private static final double peblesCost = generateCost(5.50, 31.9);
	private static final double pumpCost = generateCost(49.98, 66.45);
	private static final double sandCost = generateCost(4.99, 17.99);
	private static final double thermometerCost = generateCost(4.27, 8.85);
	// Tanks random cost constants
	// TODO move it to dedicated test/debug/simulation class
	private static final double communityTankCost = generateCost(79.90, 114.90);
	private static final double speciesTankCost = generateCost(199.0, 249.90);
	private static final double terrariumCost = generateCost(169.90, 209.90);
	private static final double goldfishBowlCost = generateCost(169.90, 209.90);
	private static final double sharkPondCost = generateCost(10000.0, 25000.0);
	private static final double tropicalAquariumCost = 
												generateCost(245.61,	532.14);

	private Accessory accessory;
	private Tank tank;

	/**
	 * Tank factory method TODO think of abstract factory TODO the volume
	 * parameter doesn't correspond to the one in the description
	 * 
	 * @param tanks
	 *            - enumerated tank constructor choice
	 * @return tank - instance of Tank
	 */
	public Tank createTank(TankType tanks) {
		switch (tanks) {
		case COMMUNITY_TANK:
			tank = new Tank();
			tank.setName("Community tank");
			tank.setDescription(TankType.COMMUNITY_TANK.getDescription());
			tank.setVolume(30.0);
			tank.setCost(communityTankCost);
			break;
		case TERRARIUM:
			tank = new Tank();
			tank.setName("Terrarium");
			tank.setDescription(TankType.TERRARIUM.getDescription());
			tank.setVolume(100.0);
			tank.setCost(terrariumCost);
			break;
		case GOLDFISH_BOWL:
			tank = new Tank();
			tank.setName("Goldfish bowl");
			tank.setDescription(TankType.GOLDFISH_BOWL.getDescription());
			tank.setVolume(10.0);
			tank.setCost(goldfishBowlCost);
			break;
		case SHARK_POND:
			tank = new Tank();
			tank.setName("Shark pond");
			tank.setDescription(TankType.SHARK_POND.getDescription());
			tank.setVolume(10000.0);
			tank.setCost(sharkPondCost);
			break;
		case SPECIES_TANK:
			tank = new Tank();
			tank.setName("Species tank");
			tank.setDescription(TankType.SPECIES_TANK.getDescription());
			tank.setVolume(10.0);
			tank.setCost(speciesTankCost);
			break;
		case TROPICAL_AQUARIUM:
			tank = new Tank();
			tank.setName("Tropical aquarium");
			tank.setDescription(TankType.TROPICAL_AQUARIUM.getDescription());
			tank.setVolume(10.0);
			tank.setCost(tropicalAquariumCost);
			break;
		default:
			System.out.println("Wrong Enum Accessories");
			break;
		}
		return tank;
	}

	/**
	 * Accessory factory method 
	 * TODO think of abstract factory
	 * @param accessories
	 *            - enumerated accessory constructor choice
	 * @return - an instance of Accessory
	 */
	public Accessory createAccessory(AccessoryType accessories) {

		switch (accessories) {
		case ALGEA:
			accessory = new Accessory();
			accessory.setName("Algea");
			accessory.setDescription(AccessoryType.ALGEA.getDescription());
			accessory.setCost(algeaCost);
			break;
		case FILTER:
			accessory = new Accessory();
			accessory.setName("Filter");
			accessory.setDescription(AccessoryType.FILTER.getDescription());
			accessory.setCost(filterCost);
			break;
		case HEATER:
			accessory = new Accessory();
			accessory.setName("Heater");
			accessory.setDescription(AccessoryType.HEATER.getDescription());
			accessory.setCost(heaterCost);
			break;
		case LAMP:
			accessory = new Accessory();
			accessory.setName("Lamp");
			accessory.setDescription(AccessoryType.LAMP.getDescription());
			accessory.setCost(lampCost);
			break;
		case PEBLES:
			accessory = new Accessory();
			accessory.setName("Pebles");
			accessory.setDescription(AccessoryType.PEBLES.getDescription());
			accessory.setCost(peblesCost);
			break;
		case PUMP:
			accessory = new Accessory();
			accessory.setName("Pump");
			accessory.setDescription(AccessoryType.PUMP.getDescription());
			accessory.setCost(pumpCost);
			break;
		case SAND:
			accessory = new Accessory();
			accessory.setName("Sand");
			accessory.setDescription(AccessoryType.SAND.getDescription());
			accessory.setCost(sandCost);
			break;
		case THERMOMETER:
			accessory = new Accessory();
			accessory.setName("Thermometer");
			accessory.setDescription(AccessoryType.THERMOMETER.getDescription());
			accessory.setCost(thermometerCost);
			break;
		default:
			System.out.println("Wrong Enum Accessories");
			break;
		}
		return accessory;
	}

	/**
	 * calculateTotalSum returns the tank cost including the cost of all
	 * inhabitants and accessories.
	 * 
	 * @param tank
	 *            - the instance of Tank to be calculated
	 * @return total cost
	 */
	public double calculateTotalSum(Tank tank) {
		if (tank == null) {
			return 0;
		}
		double total = tank.getCost();
		List<Animal> inhabitants = tank.getInhabitants();
		List<Accessory> accessories = tank.getAccessories();
		if (!inhabitants.isEmpty()) {
			for (Animal animal : inhabitants) {
				total += animal.getCost();
			}
		}
		if (!accessories.isEmpty()) {
			for (Accessory accessory : accessories) {
				total += accessory.getCost();
			}
		}
		return total;
	}

	/**
	 * Random cost generator 
	 * TODO move it to a dedicated test/debug/simulation
	 * class
	 * 
	 * @note IT VIOLATES THE DRY PRINCIPLE
	 * @param min
	 *            cost
	 * @param max
	 *            cost
	 * @return random cost value
	 */
	public static double generateCost(double min, double max) {
		return min + Math.random() * (max - min);
	}
}
