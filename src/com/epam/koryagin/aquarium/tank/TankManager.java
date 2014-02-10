package com.epam.koryagin.aquarium.tank;

import java.math.BigDecimal;
import java.util.List;

import com.epam.koryagin.aquarium.accessory.Accessory;
import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.print.Console;
import com.epam.koryagin.aquarium.print.PrintBehavior;

/**
 * Tank Manager create an instance of Tank, create instances of accessories and
 * add them in a corresponded list of the tank properties. TM populate (add)
 * animals in the tank and calculate the total price of the set
 * 
 * @author Koryagin
 * @date 2013.12.12
 * @version 1.0.0
 */
public class TankManager {
	private static final PrintBehavior OUTPUT = new Console();
	// Tanks random price constants
	// TODO move it to dedicated test/debug/simulation class
	private static final BigDecimal communityTankPrice = generatePrice(new BigDecimal(79.90), new BigDecimal(114.90));
	private static final BigDecimal speciesTankPrice = generatePrice(new BigDecimal(199.0), new BigDecimal(249.90));
	private static final BigDecimal terrariumPrice = generatePrice(new BigDecimal(169.90), new BigDecimal(209.90));
	private static final BigDecimal goldfishBowlPrice = generatePrice(new BigDecimal(169.90), new BigDecimal(209.90));
	private static final BigDecimal sharkPondPrice = generatePrice(new BigDecimal(10000.0), new BigDecimal(25000.0));
	private static final BigDecimal tropicalAquariumPrice = 
												generatePrice(new BigDecimal(245.61),	new BigDecimal(532.14));

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
			tank.setPrice(communityTankPrice);
			break;
		case TERRARIUM:
			tank = new Tank();
			tank.setName("Terrarium");
			tank.setDescription(TankType.TERRARIUM.getDescription());
			tank.setVolume(100.0);
			tank.setPrice(terrariumPrice);
			break;
		case GOLDFISH_BOWL:
			tank = new Tank();
			tank.setName("Goldfish bowl");
			tank.setDescription(TankType.GOLDFISH_BOWL.getDescription());
			tank.setVolume(10.0);
			tank.setPrice(goldfishBowlPrice);
			break;
		case SHARK_POND:
			tank = new Tank();
			tank.setName("Shark pond");
			tank.setDescription(TankType.SHARK_POND.getDescription());
			tank.setVolume(10000.0);
			tank.setPrice(sharkPondPrice);
			break;
		case SPECIES_TANK:
			tank = new Tank();
			tank.setName("Species tank");
			tank.setDescription(TankType.SPECIES_TANK.getDescription());
			tank.setVolume(10.0);
			tank.setPrice(speciesTankPrice);
			break;
		case TROPICAL_AQUARIUM:
			tank = new Tank();
			tank.setName("Tropical aquarium");
			tank.setDescription(TankType.TROPICAL_AQUARIUM.getDescription());
			tank.setVolume(10.0);
			tank.setPrice(tropicalAquariumPrice);
			break;
		default:
			OUTPUT.println("Wrong Enum Accessories");
			break;
		}
		return tank;
	}

	/**
	 * calculateTotalSum returns the tank price including the price of all
	 * inhabitants and accessories.
	 * @param tank - the instance of Tank to be calculated
	 * @return total price
	 */
	public BigDecimal calculateTotalSum(Tank tank) {
		if (tank == null) {
			return new BigDecimal(0);
		}
		BigDecimal total = BigDecimal.ZERO;
		total = total.add(tank.getPrice());
		List<Animal> inhabitants = tank.getInhabitants();
		List<Accessory> accessories = tank.getAccessories();
		if (!inhabitants.isEmpty()) {
			for (Animal animal : inhabitants) {
				total = total.add(animal.getPrice());
			}
		}
		if (!accessories.isEmpty()) {
			for (Accessory accessory : accessories) {
				total = total.add(accessory.getPrice());
			}
		}
		return (BigDecimal) total;
	}

	/**
	 * Random price generator 
	 * TODO move it to a dedicated test/debug/simulation
	 * class
	 * @note IT VIOLATES THE DRY PRINCIPLE
	 * @param min price
	 * @param max price
	 * @return random price value
	 */
	public static BigDecimal generatePrice(BigDecimal min, BigDecimal max){
		return (max.subtract(min)).multiply(new BigDecimal(Math.random())).add(min);
	}
}
