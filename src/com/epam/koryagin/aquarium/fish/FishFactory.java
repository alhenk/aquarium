package com.epam.koryagin.aquarium.fish;

import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.animal.AnimalFactory;
import com.epam.koryagin.aquarium.item.ItemType;
import com.epam.koryagin.aquarium.print.Console;
import com.epam.koryagin.aquarium.print.PrintBehavior;

/**
 * The factory creates instances of Fish
 * 
 * @author Koryagin
 * @date 2013.12.11
 * @version 1.0.0
 */
public class FishFactory implements AnimalFactory {
	private static final PrintBehavior OUTPUT = new Console();
	// Reptiles random cost constants
	// TODO move it to a dedicated test/debug/simulation class 
	private static final double angelfishCost = generateCost(12.0, 15.0);
	private static final double bassletCost = generateCost(13.0, 15.0);
	private static final double tigerbarbCost = generateCost(9.0, 11.0);
	private static final double boxfishCost = generateCost(5.0, 25.0);
	private static final double cardinalfishCost = generateCost(12.0, 17.0);
	private static final double clownfishCost = generateCost(2.0, 4.0);
	private static final double foxfaceCost = generateCost(20.0, 22.0);
	private static final double gobyCost = generateCost(7.0, 8.0);
	private static final double hogfishCost = generateCost(28.0, 32.0);
	private static final double seahorseCost = generateCost(8.0, 10.0);
	private static final double sharkCost = generateCost(1200.0, 4500.0);
	private static final double triggerfishCost = generateCost(13.0, 26.0);
	private static final double wrasseCost = generateCost(33.0, 36.0);
	
	Animal animal;
	Fish fish;
	public Animal createAnimal(ItemType pet){
		FishType fishes = (FishType)pet;
		switch (fishes){
		case ANGELFISH:
			animal = new Fish();
			animal.setName("Angelfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setCost(angelfishCost);
			fish = (Fish)animal;
			fish.setAquariumVolumeMin(30.0);
			break;
		case BASSLET:
			animal = new Fish();
			animal.setName("Basslet");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setCost(bassletCost);
			break;
		case TIGER_BARB:
			animal = new Fish();
			animal.setName("Batfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setCost(tigerbarbCost);
			break;
		case BOXFISH:
			animal = new Fish();
			animal.setName("Boxfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setCost(boxfishCost);
			break;
		case CARDINALFISH:
			animal = new Fish();
			animal.setName("Cardinalfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setCost(cardinalfishCost);
			break;
		case CLOWNFISH:
			animal = new Fish();
			animal.setName("Clownfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setCost(clownfishCost);
			break;
		case FOXFACE:
			animal = new Fish();
			animal.setName("Foxface");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setCost(foxfaceCost);
			break;
		case GOBY:
			animal = new Fish();
			animal.setName("Goby");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setCost(gobyCost);
			break;
		case HOGFISH:
			animal = new Fish();
			animal.setName("Hogfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setCost(hogfishCost);
			break;
		case SEAHORSE:
			animal = new Fish();
			animal.setName("Seahorse");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setCost(seahorseCost);
			break;
		case SHARK:
			animal = new Fish();
			animal.setName("Shark");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setCost(sharkCost);
			break;
		case TRIGGERFISH:
			animal = new Fish();
			animal.setName("Triggerfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setCost(triggerfishCost);
			break;
		case WRASSE:
			animal = new Fish();
			animal.setName("Wrasse");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setCost(wrasseCost);
			break;
		default:
			OUTPUT.println("Wrong Enum Fishes");
			break;
		
		}
		return animal;
	}
	
	/**
	 * Random cost generator
	 * TODO move it to a dedicated test/debug/simulation class 
	 * @note IT VIOLATES THE DRY PRINCIPLE!
	 * @param min cost
	 * @param max cost
	 * @return random cost value
	 */
	public static double generateCost(double min, double max){
		return min + Math.random()*(max-min);
	}
}
