/**
 * 
 */
package com.epam.koryagin.aquarium.tank;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.epam.koryagin.aquarium.animal.*;

/**
 * Class Tank generalization of Aquarium
 * 
 * @author Koryagin
 * @date 2013.12.09
 * @version 1.0.0
 */
public class Tank {
	private String name;
	private String description;
	private double volume;
	private double cost;
	private List<Animal> inhabitants = new ArrayList<Animal>();
	private List<Accessory> accessories = new ArrayList<Accessory>();

	/**
	 * Default constructor
	 */
	public Tank() {
		super();
	}
	
	/**
	 * Constructor with parameters
	 * @param name - tank item
	 * @param description - short technical specification 
	 * @param volume - tank volume
	 * @param cost - market price (ebay)
	 * @param inhabitants - list of animals that live in the tank 
	 * @param accessories - list of tank accessories
	 */
	public Tank(String name, String description, double volume, double cost, 
			ArrayList<Animal> inhabitants, ArrayList<Accessory> accessories){
		this.name = name;
		this.description = description;
		this.volume = volume;
		this.cost = cost;
		this.inhabitants = inhabitants;
		this.accessories = accessories;
	}

	public List<Animal> getInhabitants() {
		return inhabitants;
	}

	public void setInhabitants(ArrayList<Animal> inhabitants) {
		this.inhabitants = inhabitants;
	}

	public List<Accessory> getAccessories() {
		return accessories;
	}

	public void setAccessories(ArrayList<Accessory> accessories) {
		this.accessories = accessories;
	}

	public void addAnimal(Animal animal) {
		inhabitants.add(animal);
	}

	public void addAccessory(Accessory accessory) {
		accessories.add(accessory);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		NumberFormat formatter = new DecimalFormat("#0.00");
		final StringBuilder sb = new StringBuilder();
		sb.append(this.getName().toUpperCase());
		sb.append(" : ");
		sb.append(this.getDescription());
		sb.append(", $").append(formatter.format(this.getCost()));
		if (!inhabitants.isEmpty()) {
			sb.append("\n");
			sb.append("INHABITANTS : ").append("\n");
			for (Animal a : inhabitants) {
				sb.append("\t");
				sb.append(a.toString()).append("\n");
			}
		}
		if (!accessories.isEmpty()) {
			sb.append("ACCESSORY : ").append("\n");
			for (Accessory a : accessories) {
				sb.append("\t");
				sb.append(a.toString()).append("\n");
			}
		}
		return sb.toString();
	}

}