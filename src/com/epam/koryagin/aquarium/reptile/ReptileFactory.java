/**
 * 
 */
package com.epam.koryagin.aquarium.reptile;

import java.math.BigDecimal;

import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.animal.AnimalFactory;
import com.epam.koryagin.aquarium.item.ItemType;
import com.epam.koryagin.aquarium.print.Console;
import com.epam.koryagin.aquarium.print.PrintBehavior;
import com.epam.koryagin.aquarium.resource_manager.Properties;

/**
 * The factory creates instances of Reptile
 * 
 * @author Koryagin
 * @date 2013.12.11
 * @version 1.0.0
 */
public class ReptileFactory implements AnimalFactory {
	private static final PrintBehavior OUTPUT = new Console();
	// Reptiles random price constants
	private static final BigDecimal alligatorPrice = Properties.randomPrice(new BigDecimal(500.0), new BigDecimal(1500.0));
	private static final BigDecimal caimanPrice = Properties.randomPrice(new BigDecimal(300.0), new BigDecimal(800.0));
	private static final BigDecimal crocodilePrice = Properties.randomPrice(new BigDecimal(420.0), new BigDecimal(1750.0));
	private static final BigDecimal frogPrice = Properties.randomPrice(new BigDecimal(25.0), new BigDecimal(26.0));
	private static final BigDecimal gharialPrice = Properties.randomPrice(new BigDecimal(630.0), new BigDecimal(2100.0));
	private static final BigDecimal lizardPrice = Properties.randomPrice(new BigDecimal(500.0), new BigDecimal(1500.0));
	private static final BigDecimal salamanderPrice = Properties.randomPrice(new BigDecimal(58.0), new BigDecimal(480.0));
	private static final BigDecimal snakePrice = Properties.randomPrice(new BigDecimal(20.0), new BigDecimal(3500.0));
	private static final BigDecimal tautaraPrice = Properties.randomPrice(new BigDecimal(6.0), new BigDecimal(90.0));
	private static final BigDecimal terrapinPrice = Properties.randomPrice(new BigDecimal(240.0), new BigDecimal(380.0));
	private static final BigDecimal tortoisePrice = Properties.randomPrice(new BigDecimal(678.0), new BigDecimal(852.0));
	private static final BigDecimal turtlePrice = Properties.randomPrice(new BigDecimal(600.0), new BigDecimal(3000.0));

	Animal animal;
	public Animal createAnimal(ItemType pet){
		ReptileType reptiles = (ReptileType) pet;
		switch (reptiles){
		case ALLIGATOR:
			animal = new Reptile();
			animal.setName("Alligator");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setPrice(alligatorPrice);
			break;
		case CAIMAN:
			animal = new Reptile();
			animal.setName("Caiman");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setPrice(caimanPrice);
			break;
		case CROCODILE:
			animal = new Reptile();
			animal.setName("Crocodile");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setPrice(crocodilePrice);
			break;
		case FROG:
			animal = new Reptile();
			animal.setName("Frog");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setPrice(frogPrice);
			break;
		case GHARIAL:
			animal = new Reptile();
			animal.setName("Gharial");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setPrice(gharialPrice);
			break;
		case LIZARD:
			animal = new Reptile();
			animal.setName("Lizard");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setPrice(lizardPrice);
			break;
		case SALAMANDER:
			animal = new Reptile();
			animal.setName("Salamander");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setPrice(salamanderPrice);
			break;
		case SNAKE:
			animal = new Reptile();
			animal.setName("Snake");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setPrice(snakePrice);
			break;
		case TAUTARA:
			animal = new Reptile();
			animal.setName("Tautara");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setPrice(tautaraPrice);
			break;
		case TERRAPIN:
			animal = new Reptile();
			animal.setName("Terrapin");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setDescription("Fresh or brackish water turtle");
			animal.setPrice(terrapinPrice);
			break;
		case TORTOISE:
			animal = new Reptile();
			animal.setName("Tortoise");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setDescription("Land turtle");
			animal.setPrice(tortoisePrice);
			break;
		case TURTLE:
			animal = new Reptile();
			animal.setName("Turtle");
			animal.setTaxonomy(reptiles.getTaxonomy());
			animal.setDescription("Seawater turtle");
			animal.setPrice(turtlePrice);
			break;
		default:
			OUTPUT.println("Wrong Enum Reptiles");
			break;
		}
		return animal;
	}
}
