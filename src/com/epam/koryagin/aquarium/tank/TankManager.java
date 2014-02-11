package com.epam.koryagin.aquarium.tank;

import java.math.BigDecimal;
import java.util.List;

import com.epam.koryagin.aquarium.accessory.Accessory;
import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.print.Console;
import com.epam.koryagin.aquarium.print.PrintBehavior;
import com.epam.koryagin.aquarium.resource_manager.TankDAO;

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
	private Tank tank;

	
	/**
	 * Overloaded factory method
	 * @param uid
	 * @return
	 */
	public Tank createTank(int uid){
		TankDAO tankDAO = new TankDAO();
		Tank tank = (Tank)(tankDAO.getItem(uid));
		return tank;
	}
	
	/**
	 * Tank factory method TODO think of abstract factory
	 *  
	 * @param tanks
	 *            - enumerated tank constructor choice
	 * @return tank - instance of Tank
	 */
	public Tank createTank(TankType tanks) {
		switch (tanks) {
		case COMMUNITY_TANK:
			tank = new Tank();
			tank.setUID(TankType.COMMUNITY_TANK.getUID());
			tank.setName(TankType.COMMUNITY_TANK.getName());
			tank.setDescription(TankType.COMMUNITY_TANK.getDescription());
			tank.setPrice(TankType.COMMUNITY_TANK.getPrice());
			tank.setVolume(TankType.COMMUNITY_TANK.getVolume());
			break;
		case TERRARIUM:
			tank = new Tank();
			tank.setUID(TankType.TERRARIUM.getUID());
			tank.setName(TankType.TERRARIUM.getName());
			tank.setDescription(TankType.TERRARIUM.getDescription());
			tank.setPrice(TankType.TERRARIUM.getPrice());
			tank.setVolume(TankType.TERRARIUM.getVolume());
			break;
		case GOLDFISH_BOWL:
			tank = new Tank();
			tank.setUID(TankType.GOLDFISH_BOWL.getUID());
			tank.setName(TankType.GOLDFISH_BOWL.getName());
			tank.setDescription(TankType.GOLDFISH_BOWL.getDescription());
			tank.setPrice(TankType.GOLDFISH_BOWL.getPrice());
			tank.setVolume(TankType.GOLDFISH_BOWL.getVolume());
			break;
		case SHARK_POND:
			tank = new Tank();
			tank.setUID(TankType.SHARK_POND.getUID());
			tank.setName(TankType.SHARK_POND.getName());
			tank.setDescription(TankType.SHARK_POND.getDescription());
			tank.setPrice(TankType.SHARK_POND.getPrice());
			tank.setVolume(TankType.SHARK_POND.getVolume());
			break;
		case SPECIES_TANK:
			tank = new Tank();
			tank.setUID(TankType.SPECIES_TANK.getUID());
			tank.setName(TankType.SPECIES_TANK.getName());
			tank.setDescription(TankType.SPECIES_TANK.getDescription());
			tank.setPrice(TankType.SPECIES_TANK.getPrice());
			tank.setVolume(TankType.SPECIES_TANK.getVolume());
			break;
		case TROPICAL_AQUARIUM:
			tank = new Tank();
			tank.setUID(TankType.TROPICAL_AQUARIUM.getUID());
			tank.setName(TankType.TROPICAL_AQUARIUM.getName());
			tank.setDescription(TankType.TROPICAL_AQUARIUM.getDescription());
			tank.setPrice(TankType.TROPICAL_AQUARIUM.getPrice());
			tank.setVolume(TankType.TROPICAL_AQUARIUM.getVolume());
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
}
