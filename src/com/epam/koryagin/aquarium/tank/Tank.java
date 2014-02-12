/**
 * 
 */
package com.epam.koryagin.aquarium.tank;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.epam.koryagin.aquarium.accessory.Accessory;
import com.epam.koryagin.aquarium.animal.*;
import com.epam.koryagin.aquarium.item.Item;

/**
 * Class Tank generalization of Aquarium
 * 
 * @author Koryagin
 * @date 2013.12.09
 * @version 1.0.0
 */
public class Tank extends Item{
	
	private double volume;
	private List<Animal> inhabitants;
	private List<Accessory> accessories;
	
	/**
	 * Default constructor
	 */
	public Tank() {
		super();
	}
	
	/**
	 * Constructor with Builder
	 * @param name - tank item
	 * @param description - short technical specification 
	 * @param volume - tank volume
	 * @param price - market price (ebay)
	 * @param inhabitants - list of animals that live in the tank 
	 * @param accessories - list of tank accessories
	 */
	public Tank(Builder builder){
		this.setUID(builder.uid);
		this.setName(builder.name);
		this.setDescription(builder.description);
		this.setPrice(builder.price);
		this.volume = builder.volume;
		this.inhabitants = new ArrayList<Animal>();
		this.accessories = new ArrayList<Accessory>();
	}
	
	public static class Builder{
		private int uid;
		private String name;
		private String description = "NA";
		private BigDecimal price = BigDecimal.ZERO;
		private double volume = 0;
		
		public Builder(int uid, String name){
			this.uid = uid;
			this.name = name;
		}
		
		public Builder description(String text){
			description = text;
			return this;
		}
		
		public Builder price(BigDecimal val){
			price = val;
			return this;
		}
		
		public Builder volume(double val){
			volume = val;
			return this;
		}
		
		public Tank build(){
			return new Tank(this);
		}
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
		sb.append(", $").append(formatter.format(this.getPrice()));
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

	@Override
	public int compareTo(Item o) {
		return this.getName().compareTo(o.getName());
	}

}
