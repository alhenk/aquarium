package com.epam.koryagin.aquarium.accessory;

import com.epam.koryagin.aquarium.print.Console;
import com.epam.koryagin.aquarium.print.PrintBehavior;
import com.epam.koryagin.aquarium.resource_manager.AccessoryDAO;


public class AccessoryFactory {
	private static final PrintBehavior OUTPUT = new Console();
		private Accessory accessory;
		
		/**
		 * Overloaded factory method
		 * @param uid
		 * @return
		 */
		public Accessory createAccessory(int uid){
			AccessoryDAO accessoryDAO = new AccessoryDAO();
			Accessory accessory = (Accessory)(accessoryDAO.getItem(uid));
			return accessory;
		}
		/**
		 * Accessory factory method 
		 * @param accessories
		 *            - enumerated accessory constructor choice
		 * @return - an instance of Accessory
		 */
		public Accessory createAccessory(AccessoryType accessories) {

			switch (accessories) {
			case ALGAE:
				accessory = new Accessory();
				accessory.setUID(AccessoryType.ALGAE.getUID());
				accessory.setName(AccessoryType.ALGAE.getName());
				accessory.setDescription(AccessoryType.ALGAE.getDescription());
				accessory.setPrice(AccessoryType.ALGAE.getPrice());
				break;
			case FILTER:
				accessory = new Accessory();
				accessory.setUID(AccessoryType.FILTER.getUID());
				accessory.setName(AccessoryType.FILTER.getName());
				accessory.setDescription(AccessoryType.FILTER.getDescription());
				accessory.setPrice(AccessoryType.FILTER.getPrice());
				break;
			case HEATER:
				accessory = new Accessory();
				accessory.setUID(AccessoryType.HEATER.getUID());
				accessory.setName(AccessoryType.HEATER.getName());
				accessory.setDescription(AccessoryType.HEATER.getDescription());
				accessory.setPrice(AccessoryType.HEATER.getPrice());
				break;
			case LAMP:
				accessory = new Accessory();
				accessory.setUID(AccessoryType.LAMP.getUID());
				accessory.setName(AccessoryType.LAMP.getName());
				accessory.setDescription(AccessoryType.LAMP.getDescription());
				accessory.setPrice(AccessoryType.LAMP.getPrice());
				break;
			case PEBLES:
				accessory = new Accessory();
				accessory.setUID(AccessoryType.PEBLES.getUID());
				accessory.setName(AccessoryType.PEBLES.getName());
				accessory.setDescription(AccessoryType.PEBLES.getDescription());
				accessory.setPrice(AccessoryType.PEBLES.getPrice());
				break;
			case PUMP:
				accessory = new Accessory();
				accessory.setUID(AccessoryType.PUMP.getUID());
				accessory.setName(AccessoryType.PUMP.getName());
				accessory.setDescription(AccessoryType.PUMP.getDescription());
				accessory.setPrice(AccessoryType.PUMP.getPrice());
				break;
			case SAND:
				accessory = new Accessory();
				accessory.setUID(AccessoryType.SAND.getUID());
				accessory.setName(AccessoryType.SAND.getName());
				accessory.setDescription(AccessoryType.SAND.getDescription());
				accessory.setPrice(AccessoryType.SAND.getPrice());
				break;
			case THERMOMETER:
				accessory = new Accessory();
				accessory.setUID(AccessoryType.THERMOMETER.getUID());
				accessory.setName(AccessoryType.THERMOMETER.getName());
				accessory.setDescription(AccessoryType.THERMOMETER.getDescription());
				accessory.setPrice(AccessoryType.THERMOMETER.getPrice());
				break;
			default:
				OUTPUT.println("Wrong Enum Accessories");
				break;
			}
			return accessory;
		}
}
