/**
 * 
 */
package com.epam.koryagin.aquarium.animal;

/**
 * The factory creates instances of Reptile
 * 
 * @author Koryagin
 * @date 2013.12.11
 * @version 1.0.0
 */
public class ReptileFactory implements AnimalFactory {
	// Reptiles random cost constants
	private static final double alligatorCost = generateCost(500.0, 1500.0);
	private static final double caimanCost = generateCost(300.0, 800.0);
	private static final double crocodileCost = generateCost(420.0, 1750.0);
	private static final double frogCost = generateCost(25.0, 26.0);
	private static final double gharialCost = generateCost(630.0, 2100.0);
	private static final double lizardCost = generateCost(500.0, 1500.0);
	private static final double salamanderCost = generateCost(58.0, 480.0);
	private static final double snakeCost = generateCost(20.0, 3500.0);
	private static final double tautaraCost = generateCost(6.0, 90.0);
	private static final double terrapinCost = generateCost(240.0, 380.0);
	private static final double tortoiseCost = generateCost(678.0, 852.0);
	private static final double turtleCost = generateCost(600.0, 3000.0);

	Animal animal;
	public Animal createAnimal(AnimalType pet){
		ReptileType reptiles = (ReptileType) pet;
		switch (reptiles){
		case ALLIGATOR:
			animal = new Reptile();
			animal.setName("Alligator");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setCost(alligatorCost);
			break;
		case CAIMAN:
			animal = new Reptile();
			animal.setName("Caiman");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setCost(caimanCost);
			break;
		case CROCODILE:
			animal = new Reptile();
			animal.setName("Crocodile");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setCost(crocodileCost);
			break;
		case FROG:
			animal = new Reptile();
			animal.setName(reptiles.getName());
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setCost(frogCost);
			break;
		case GHARIAL:
			animal = new Reptile();
			animal.setName("Gharial");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setCost(gharialCost);
			break;
		case LIZARD:
			animal = new Reptile();
			animal.setName("Lizard");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setCost(lizardCost);
			break;
		case SALAMANDER:
			animal = new Reptile();
			animal.setName("Salamander");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setCost(salamanderCost);
			break;
		case SNAKE:
			animal = new Reptile();
			animal.setName("Snake");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setCost(snakeCost);
			break;
		case TAUTARA:
			animal = new Reptile();
			animal.setName("Tautara");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setCost(tautaraCost);
			break;
		case TERRAPIN:
			animal = new Reptile();
			animal.setName("Terrapin");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setDescription("Fresh or brackish water turtle");
			animal.setCost(terrapinCost);
			break;
		case TORTOISE:
			animal = new Reptile();
			animal.setName("Tortoise");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setDescription("Land turtle");
			animal.setCost(tortoiseCost);
			break;
		case TURTLE:
			animal = new Reptile();
			animal.setName("Turtle");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setDescription("Seawater turtle");
			animal.setCost(turtleCost);
			break;
		default:
			System.out.println("Wrong Enum Reptiles");
			break;
		}
		return animal;
	}
	
	/**
	 * Random cost generator
	 * TODO move it to a dedicated test/debug/simulation class 
	 * @note IT VIOLATES THE DRY PRINCIPLE
	 * @param min cost
	 * @param max cost
	 * @return random cost value
	 */
	public static double generateCost(double min, double max){
		return min + Math.random()*(max-min);
	}
}
