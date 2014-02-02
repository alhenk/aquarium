package com.epam.koryagin.aquarium.tank;

public class AccessoryManager {
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
