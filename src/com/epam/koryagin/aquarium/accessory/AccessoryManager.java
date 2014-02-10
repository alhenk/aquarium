package com.epam.koryagin.aquarium.accessory;

import java.math.BigDecimal;

import com.epam.koryagin.aquarium.print.Console;
import com.epam.koryagin.aquarium.print.PrintBehavior;


public class AccessoryManager {
	private static final PrintBehavior OUTPUT = new Console();
	// Accessories random price constants
		// TODO move it to dedicated test/debug/simulation class
		private static final BigDecimal algeaPrice = generatePrice(new BigDecimal(12.0), new BigDecimal(15.0));
		private static final BigDecimal filterPrice = generatePrice(new BigDecimal(44.99), new BigDecimal(66.45));
		private static final BigDecimal heaterPrice = generatePrice(new BigDecimal(7.98), new BigDecimal(27.99));
		private static final BigDecimal lampPrice = generatePrice(new BigDecimal(53.95), new BigDecimal(132.85));
		private static final BigDecimal peblesPrice = generatePrice(new BigDecimal(5.50), new BigDecimal(31.9));
		private static final BigDecimal pumpPrice = generatePrice(new BigDecimal(49.98), new BigDecimal(66.45));
		private static final BigDecimal sandPrice = generatePrice(new BigDecimal(4.99), new BigDecimal(17.99));
		private static final BigDecimal thermometerPrice = generatePrice(new BigDecimal(4.27), new BigDecimal(8.85));
		
		private Accessory accessory;
		
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
				accessory.setPrice(algeaPrice);
				break;
			case FILTER:
				accessory = new Accessory();
				accessory.setName("Filter");
				accessory.setDescription(AccessoryType.FILTER.getDescription());
				accessory.setPrice(filterPrice);
				break;
			case HEATER:
				accessory = new Accessory();
				accessory.setName("Heater");
				accessory.setDescription(AccessoryType.HEATER.getDescription());
				accessory.setPrice(heaterPrice);
				break;
			case LAMP:
				accessory = new Accessory();
				accessory.setName("Lamp");
				accessory.setDescription(AccessoryType.LAMP.getDescription());
				accessory.setPrice(lampPrice);
				break;
			case PEBLES:
				accessory = new Accessory();
				accessory.setName("Pebles");
				accessory.setDescription(AccessoryType.PEBLES.getDescription());
				accessory.setPrice(peblesPrice);
				break;
			case PUMP:
				accessory = new Accessory();
				accessory.setName("Pump");
				accessory.setDescription(AccessoryType.PUMP.getDescription());
				accessory.setPrice(pumpPrice);
				break;
			case SAND:
				accessory = new Accessory();
				accessory.setName("Sand");
				accessory.setDescription(AccessoryType.SAND.getDescription());
				accessory.setPrice(sandPrice);
				break;
			case THERMOMETER:
				accessory = new Accessory();
				accessory.setName("Thermometer");
				accessory.setDescription(AccessoryType.THERMOMETER.getDescription());
				accessory.setPrice(thermometerPrice);
				break;
			default:
				OUTPUT.println("Wrong Enum Accessories");
				break;
			}
			return accessory;
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
