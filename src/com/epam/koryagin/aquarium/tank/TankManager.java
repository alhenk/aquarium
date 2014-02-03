package com.epam.koryagin.aquarium.tank;

import java.util.List;

import com.epam.koryagin.aquarium.accessory.Accessory;
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
	// Tanks random cost constants
	// TODO move it to dedicated test/debug/simulation class
	private static final double communityTankCost = generateCost(79.90, 114.90);
	private static final double speciesTankCost = generateCost(199.0, 249.90);
	private static final double terrariumCost = generateCost(169.90, 209.90);
	private static final double goldfishBowlCost = generateCost(169.90, 209.90);
	private static final double sharkPondCost = generateCost(10000.0, 25000.0);
	private static final double tropicalAquariumCost = 
												generateCost(245.61,	532.14);

	//private Accessory accessory;
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
