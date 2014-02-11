package com.epam.koryagin.aquarium.fish;

import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.animal.AnimalFactory;
import com.epam.koryagin.aquarium.item.ItemType;
import com.epam.koryagin.aquarium.print.Console;
import com.epam.koryagin.aquarium.print.PrintBehavior;
import com.epam.koryagin.aquarium.resource_manager.FishDAO;

/**
 * The factory creates instances of Fish
 * 
 * @author Koryagin
 * @date 2013.12.11
 * @version 1.0.0
 */
public class FishFactory implements AnimalFactory {
	private static final PrintBehavior OUTPUT = new Console();
	Animal animal;
	Fish fish;
	
	/**
	 * Overloaded factory method
	 * @param uid
	 * @return
	 */
	public Animal createAnimal(int uid){
		FishDAO fishDAO = new FishDAO();
		Fish fish = (Fish)(fishDAO.getItem(uid));
		return fish;
	}
	
	public Animal createAnimal(ItemType pet){
		FishType fishes = (FishType)pet;
		switch (fishes){
		case ANGELFISH:
			animal = new Fish();
			animal.setUID(FishType.ANGELFISH.getUID());
			animal.setName(FishType.ANGELFISH.getName());
			animal.setDescription(FishType.ANGELFISH.getDescription());
			animal.setTaxonomy(FishType.ANGELFISH.getTaxonomy());
			animal.setPrice(FishType.ANGELFISH.getPrice());
			animal.setSizeMax(FishType.ANGELFISH.getSizeMax());
			animal.setTankVolumeMin(FishType.ANGELFISH.getTankVolumeMin());
			break;
		case BASSLET:
			animal = new Fish();
			animal.setUID(FishType.BASSLET.getUID());
			animal.setName(FishType.BASSLET.getName());
			animal.setDescription(FishType.BASSLET.getDescription());
			animal.setTaxonomy(FishType.BASSLET.getTaxonomy());
			animal.setPrice(FishType.BASSLET.getPrice());
			animal.setSizeMax(FishType.BASSLET.getSizeMax());
			animal.setTankVolumeMin(FishType.BASSLET.getTankVolumeMin());
			break;
		case TIGER_BARB:
			animal = new Fish();
			animal.setUID(FishType.TIGER_BARB.getUID());
			animal.setName(FishType.TIGER_BARB.getName());
			animal.setDescription(FishType.TIGER_BARB.getDescription());
			animal.setTaxonomy(FishType.TIGER_BARB.getTaxonomy());
			animal.setPrice(FishType.TIGER_BARB.getPrice());
			animal.setSizeMax(FishType.TIGER_BARB.getSizeMax());
			animal.setTankVolumeMin(FishType.TIGER_BARB.getTankVolumeMin());
			break;
		case BOXFISH:
			animal = new Fish();
			animal.setUID(FishType.BOXFISH.getUID());
			animal.setName(FishType.BOXFISH.getName());
			animal.setDescription(FishType.BOXFISH.getDescription());
			animal.setTaxonomy(FishType.BOXFISH.getTaxonomy());
			animal.setPrice(FishType.BOXFISH.getPrice());
			animal.setSizeMax(FishType.BOXFISH.getSizeMax());
			animal.setTankVolumeMin(FishType.BOXFISH.getTankVolumeMin());
			break;
		case CARDINALFISH:
			animal = new Fish();
			animal.setUID(FishType.CARDINALFISH.getUID());
			animal.setName(FishType.CARDINALFISH.getName());
			animal.setDescription(FishType.CARDINALFISH.getDescription());
			animal.setTaxonomy(FishType.CARDINALFISH.getTaxonomy());
			animal.setPrice(FishType.CARDINALFISH.getPrice());
			animal.setSizeMax(FishType.CARDINALFISH.getSizeMax());
			animal.setTankVolumeMin(FishType.CARDINALFISH.getTankVolumeMin());
			break;
		case CLOWNFISH:
			animal = new Fish();
			animal.setUID(FishType.CLOWNFISH.getUID());
			animal.setName(FishType.CLOWNFISH.getName());
			animal.setDescription(FishType.CLOWNFISH.getDescription());
			animal.setTaxonomy(FishType.CLOWNFISH.getTaxonomy());
			animal.setPrice(FishType.CLOWNFISH.getPrice());
			animal.setSizeMax(FishType.CLOWNFISH.getSizeMax());
			animal.setTankVolumeMin(FishType.CLOWNFISH.getTankVolumeMin());
			break;
		case FOXFACE:
			animal = new Fish();
			animal.setUID(FishType.FOXFACE.getUID());
			animal.setName(FishType.FOXFACE.getName());
			animal.setDescription(FishType.FOXFACE.getDescription());
			animal.setTaxonomy(FishType.FOXFACE.getTaxonomy());
			animal.setPrice(FishType.FOXFACE.getPrice());
			animal.setSizeMax(FishType.FOXFACE.getSizeMax());
			animal.setTankVolumeMin(FishType.FOXFACE.getTankVolumeMin());
			break;
		case GOBY:
			animal = new Fish();
			animal.setUID(FishType.GOBY.getUID());
			animal.setName(FishType.GOBY.getName());
			animal.setDescription(FishType.GOBY.getDescription());
			animal.setTaxonomy(FishType.GOBY.getTaxonomy());
			animal.setPrice(FishType.GOBY.getPrice());
			animal.setSizeMax(FishType.GOBY.getSizeMax());
			animal.setTankVolumeMin(FishType.GOBY.getTankVolumeMin());
			break;
		case HOGFISH:
			animal = new Fish();
			animal.setUID(FishType.HOGFISH.getUID());
			animal.setName(FishType.HOGFISH.getName());
			animal.setDescription(FishType.HOGFISH.getDescription());
			animal.setTaxonomy(FishType.HOGFISH.getTaxonomy());
			animal.setPrice(FishType.HOGFISH.getPrice());
			animal.setSizeMax(FishType.HOGFISH.getSizeMax());
			animal.setTankVolumeMin(FishType.HOGFISH.getTankVolumeMin());
			break;
		case SEAHORSE:
			animal = new Fish();
			animal.setUID(FishType.SEAHORSE.getUID());
			animal.setName(FishType.SEAHORSE.getName());
			animal.setDescription(FishType.SEAHORSE.getDescription());
			animal.setTaxonomy(FishType.SEAHORSE.getTaxonomy());
			animal.setPrice(FishType.SEAHORSE.getPrice());
			animal.setSizeMax(FishType.SEAHORSE.getSizeMax());
			animal.setTankVolumeMin(FishType.SEAHORSE.getTankVolumeMin());
			break;
		case SHARK:
			animal = new Fish();
			animal.setUID(FishType.SHARK.getUID());
			animal.setName(FishType.SHARK.getName());
			animal.setDescription(FishType.SHARK.getDescription());
			animal.setTaxonomy(FishType.SHARK.getTaxonomy());
			animal.setPrice(FishType.SHARK.getPrice());
			animal.setSizeMax(FishType.SHARK.getSizeMax());
			animal.setTankVolumeMin(FishType.SHARK.getTankVolumeMin());
			break;
		case TRIGGERFISH:
			animal = new Fish();
			animal.setUID(FishType.TRIGGERFISH.getUID());
			animal.setName(FishType.TRIGGERFISH.getName());
			animal.setDescription(FishType.TRIGGERFISH.getDescription());
			animal.setTaxonomy(FishType.TRIGGERFISH.getTaxonomy());
			animal.setPrice(FishType.TRIGGERFISH.getPrice());
			animal.setSizeMax(FishType.TRIGGERFISH.getSizeMax());
			animal.setTankVolumeMin(FishType.TRIGGERFISH.getTankVolumeMin());
			break;
		case WRASSE:
			animal = new Fish();
			animal.setUID(FishType.WRASSE.getUID());
			animal.setName(FishType.WRASSE.getName());
			animal.setDescription(FishType.WRASSE.getDescription());
			animal.setTaxonomy(FishType.WRASSE.getTaxonomy());
			animal.setPrice(FishType.WRASSE.getPrice());
			animal.setSizeMax(FishType.WRASSE.getSizeMax());
			animal.setTankVolumeMin(FishType.WRASSE.getTankVolumeMin());
			break;
		default:
			OUTPUT.println("Wrong Enum Fishes");
			break;
		
		}
		return animal;
	}
}
