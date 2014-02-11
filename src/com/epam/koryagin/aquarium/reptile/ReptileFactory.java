/**
 * 
 */
package com.epam.koryagin.aquarium.reptile;

import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.animal.AnimalFactory;
import com.epam.koryagin.aquarium.item.ItemType;
import com.epam.koryagin.aquarium.print.Console;
import com.epam.koryagin.aquarium.print.PrintBehavior;
import com.epam.koryagin.aquarium.resource_manager.ReptileDAO;

/**
 * The factory creates instances of Reptile
 * 
 * @author Koryagin
 * @date 2013.12.11
 * @version 1.0.0
 */
public class ReptileFactory implements AnimalFactory {
	private static final PrintBehavior OUTPUT = new Console();
	Animal animal;
	
	/**
	 * Overloaded factory method
	 * @param uid
	 * @return
	 */
	public Animal createAnimal(int uid){
		ReptileDAO reptileDAO = new ReptileDAO();
		Reptile reptile = (Reptile)(reptileDAO.getItem(uid));
		return reptile;
	}
	
	public Animal createAnimal(ItemType pet){
		ReptileType reptiles = (ReptileType) pet;
		switch (reptiles){
		case ALLIGATOR:
			animal = new Reptile();
			animal.setUID(ReptileType.ALLIGATOR.getUID());
			animal.setName(ReptileType.ALLIGATOR.getName());
			animal.setDescription(ReptileType.ALLIGATOR.getDescription());
			animal.setTaxonomy(ReptileType.ALLIGATOR.getTaxonomy());
			animal.setPrice(ReptileType.ALLIGATOR.getPrice());
			animal.setSizeMax(ReptileType.ALLIGATOR.getSizeMax());
			animal.setTankVolumeMin(ReptileType.ALLIGATOR.getTankVolumeMin());
			break;
		case CAIMAN:
			animal = new Reptile();
			animal.setUID(ReptileType.CAIMAN.getUID());
			animal.setName(ReptileType.CAIMAN.getName());
			animal.setDescription(ReptileType.CAIMAN.getDescription());
			animal.setTaxonomy(ReptileType.CAIMAN.getTaxonomy());
			animal.setPrice(ReptileType.CAIMAN.getPrice());
			animal.setSizeMax(ReptileType.CAIMAN.getSizeMax());
			animal.setTankVolumeMin(ReptileType.CAIMAN.getTankVolumeMin());
			break;
		case CROCODILE:
			animal = new Reptile();
			animal.setUID(ReptileType.CROCODILE.getUID());
			animal.setName(ReptileType.CROCODILE.getName());
			animal.setDescription(ReptileType.CROCODILE.getDescription());
			animal.setTaxonomy(ReptileType.CROCODILE.getTaxonomy());
			animal.setPrice(ReptileType.CROCODILE.getPrice());
			animal.setSizeMax(ReptileType.CROCODILE.getSizeMax());
			animal.setTankVolumeMin(ReptileType.CROCODILE.getTankVolumeMin());
			break;
		case FROG:
			animal = new Reptile();
			animal.setUID(ReptileType.FROG.getUID());
			animal.setName(ReptileType.FROG.getName());
			animal.setDescription(ReptileType.FROG.getDescription());
			animal.setTaxonomy(ReptileType.FROG.getTaxonomy());
			animal.setPrice(ReptileType.FROG.getPrice());
			animal.setSizeMax(ReptileType.FROG.getSizeMax());
			animal.setTankVolumeMin(ReptileType.FROG.getTankVolumeMin());
			break;
		case GHARIAL:
			animal = new Reptile();
			animal.setUID(ReptileType.GHARIAL.getUID());
			animal.setName(ReptileType.GHARIAL.getName());
			animal.setDescription(ReptileType.GHARIAL.getDescription());
			animal.setTaxonomy(ReptileType.GHARIAL.getTaxonomy());
			animal.setPrice(ReptileType.GHARIAL.getPrice());
			animal.setSizeMax(ReptileType.GHARIAL.getSizeMax());
			animal.setTankVolumeMin(ReptileType.GHARIAL.getTankVolumeMin());
			break;
		case LIZARD:
			animal = new Reptile();
			animal.setUID(ReptileType.LIZARD.getUID());
			animal.setName(ReptileType.LIZARD.getName());
			animal.setDescription(ReptileType.LIZARD.getDescription());
			animal.setTaxonomy(ReptileType.LIZARD.getTaxonomy());
			animal.setPrice(ReptileType.LIZARD.getPrice());
			animal.setSizeMax(ReptileType.LIZARD.getSizeMax());
			animal.setTankVolumeMin(ReptileType.LIZARD.getTankVolumeMin());
			break;
		case SALAMANDER:
			animal = new Reptile();
			animal.setUID(ReptileType.SALAMANDER.getUID());
			animal.setName(ReptileType.SALAMANDER.getName());
			animal.setDescription(ReptileType.SALAMANDER.getDescription());
			animal.setTaxonomy(ReptileType.SALAMANDER.getTaxonomy());
			animal.setPrice(ReptileType.SALAMANDER.getPrice());
			animal.setSizeMax(ReptileType.SALAMANDER.getSizeMax());
			animal.setTankVolumeMin(ReptileType.SALAMANDER.getTankVolumeMin());
			break;
		case SNAKE:
			animal = new Reptile();
			animal.setUID(ReptileType.SNAKE.getUID());
			animal.setName(ReptileType.SNAKE.getName());
			animal.setDescription(ReptileType.SNAKE.getDescription());
			animal.setTaxonomy(ReptileType.SNAKE.getTaxonomy());
			animal.setPrice(ReptileType.SNAKE.getPrice());
			animal.setSizeMax(ReptileType.SNAKE.getSizeMax());
			animal.setTankVolumeMin(ReptileType.SNAKE.getTankVolumeMin());
			break;
		case TAUTARA:
			animal = new Reptile();
			animal.setUID(ReptileType.TAUTARA.getUID());
			animal.setName(ReptileType.TAUTARA.getName());
			animal.setDescription(ReptileType.TAUTARA.getDescription());
			animal.setTaxonomy(ReptileType.TAUTARA.getTaxonomy());
			animal.setPrice(ReptileType.TAUTARA.getPrice());
			animal.setSizeMax(ReptileType.TAUTARA.getSizeMax());
			animal.setTankVolumeMin(ReptileType.TAUTARA.getTankVolumeMin());
			break;
		case TERRAPIN:
			animal = new Reptile();
			animal.setUID(ReptileType.TERRAPIN.getUID());
			animal.setName(ReptileType.TERRAPIN.getName());
			animal.setDescription(ReptileType.TERRAPIN.getDescription());
			animal.setTaxonomy(ReptileType.TERRAPIN.getTaxonomy());
			animal.setPrice(ReptileType.TERRAPIN.getPrice());
			animal.setSizeMax(ReptileType.TERRAPIN.getSizeMax());
			animal.setTankVolumeMin(ReptileType.TERRAPIN.getTankVolumeMin());
			break;
		case TORTOISE:
			animal = new Reptile();
			animal.setUID(ReptileType.TORTOISE.getUID());
			animal.setName(ReptileType.TORTOISE.getName());
			animal.setDescription(ReptileType.TORTOISE.getDescription());
			animal.setTaxonomy(ReptileType.TORTOISE.getTaxonomy());
			animal.setPrice(ReptileType.TORTOISE.getPrice());
			animal.setSizeMax(ReptileType.TORTOISE.getSizeMax());
			animal.setTankVolumeMin(ReptileType.TORTOISE.getTankVolumeMin());
			break;
		case TURTLE:
			animal = new Reptile();
			animal.setUID(ReptileType.TURTLE.getUID());
			animal.setName(ReptileType.TURTLE.getName());
			animal.setDescription(ReptileType.TURTLE.getDescription());
			animal.setTaxonomy(ReptileType.TURTLE.getTaxonomy());
			animal.setPrice(ReptileType.TURTLE.getPrice());
			animal.setSizeMax(ReptileType.TURTLE.getSizeMax());
			animal.setTankVolumeMin(ReptileType.TURTLE.getTankVolumeMin());
			break;
		default:
			OUTPUT.println("Wrong Enum Reptiles");
			break;
		}
		return animal;
	}
}
