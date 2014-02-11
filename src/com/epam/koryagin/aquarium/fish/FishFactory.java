package com.epam.koryagin.aquarium.fish;

import java.math.BigDecimal;

import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.animal.AnimalFactory;
import com.epam.koryagin.aquarium.item.ItemType;
import com.epam.koryagin.aquarium.print.Console;
import com.epam.koryagin.aquarium.print.PrintBehavior;
import com.epam.koryagin.aquarium.resource_manager.Properties;

/**
 * The factory creates instances of Fish
 * 
 * @author Koryagin
 * @date 2013.12.11
 * @version 1.0.0
 */
public class FishFactory implements AnimalFactory {
	private static final PrintBehavior OUTPUT = new Console();
	// Reptiles random price constants
	// TODO move it to a dedicated test/debug/simulation class 
	private static final BigDecimal angelfishPrice = Properties.randomPrice(new BigDecimal(12.0), new BigDecimal(15.0));
	private static final BigDecimal bassletPrice = Properties.randomPrice(new BigDecimal(13.0), new BigDecimal(15.0));
	private static final BigDecimal tigerbarbPrice = Properties.randomPrice(new BigDecimal(9.0), new BigDecimal(11.0));
	private static final BigDecimal boxfishPrice = Properties.randomPrice(new BigDecimal(5.0), new BigDecimal(25.0));
	private static final BigDecimal cardinalfishPrice = Properties.randomPrice(new BigDecimal(12.0), new BigDecimal(17.0));
	private static final BigDecimal clownfishPrice = Properties.randomPrice(new BigDecimal(2.0), new BigDecimal(4.0));
	private static final BigDecimal foxfacePrice = Properties.randomPrice(new BigDecimal(20.0), new BigDecimal(22.0));
	private static final BigDecimal gobyPrice = Properties.randomPrice(new BigDecimal(7.0), new BigDecimal(8.0));
	private static final BigDecimal hogfishPrice = Properties.randomPrice(new BigDecimal(28.0), new BigDecimal(32.0));
	private static final BigDecimal seahorsePrice = Properties.randomPrice(new BigDecimal(8.0), new BigDecimal(10.0));
	private static final BigDecimal sharkPrice = Properties.randomPrice(new BigDecimal(1200.0), new BigDecimal(4500.0));
	private static final BigDecimal triggerfishPrice = Properties.randomPrice(new BigDecimal(13.0),new BigDecimal( 26.0));
	private static final BigDecimal wrassePrice = Properties.randomPrice(new BigDecimal(33.0), new BigDecimal(36.0));
	
	Animal animal;
	Fish fish;
	public Animal createAnimal(ItemType pet){
		FishType fishes = (FishType)pet;
		switch (fishes){
		case ANGELFISH:
			animal = new Fish();
			animal.setName("Angelfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setPrice(angelfishPrice);
			fish = (Fish)animal;
			fish.setTankVolumeMin(30.0);
			break;
		case BASSLET:
			animal = new Fish();
			animal.setName("Basslet");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setPrice(bassletPrice);
			break;
		case TIGER_BARB:
			animal = new Fish();
			animal.setName("Batfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setPrice(tigerbarbPrice);
			break;
		case BOXFISH:
			animal = new Fish();
			animal.setName("Boxfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setPrice(boxfishPrice);
			break;
		case CARDINALFISH:
			animal = new Fish();
			animal.setName("Cardinalfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setPrice(cardinalfishPrice);
			break;
		case CLOWNFISH:
			animal = new Fish();
			animal.setName("Clownfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setPrice(clownfishPrice);
			break;
		case FOXFACE:
			animal = new Fish();
			animal.setName("Foxface");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setPrice(foxfacePrice);
			break;
		case GOBY:
			animal = new Fish();
			animal.setName("Goby");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setPrice(gobyPrice);
			break;
		case HOGFISH:
			animal = new Fish();
			animal.setName("Hogfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setPrice(hogfishPrice);
			break;
		case SEAHORSE:
			animal = new Fish();
			animal.setName("Seahorse");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setPrice(seahorsePrice);
			break;
		case SHARK:
			animal = new Fish();
			animal.setName("Shark");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setPrice(sharkPrice);
			break;
		case TRIGGERFISH:
			animal = new Fish();
			animal.setName("Triggerfish");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setPrice(triggerfishPrice);
			break;
		case WRASSE:
			animal = new Fish();
			animal.setName("Wrasse");
			animal.setTaxonomy(fishes.getTaxonomy());
			animal.setPrice(wrassePrice);
			break;
		default:
			OUTPUT.println("Wrong Enum Fishes");
			break;
		
		}
		return animal;
	}
}
