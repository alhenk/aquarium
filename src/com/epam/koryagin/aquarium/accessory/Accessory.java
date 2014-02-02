/**
 * 
 */
package com.epam.koryagin.aquarium.accessory;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Accessory for Aquarium Tank
 * @author Koryagin
 * @date 2013.12.12
 * @version 1.0.0
 */
public class Accessory {
	private double cost;
	private String name;
	private String description;

	/**
	 * Default constructor
	 */
	public Accessory(){
		super();
	}
	
	/**
	 * Constructor with one parameter
	 * @param name - accessory item
	 */
	public Accessory(String name){
		this.setName(name);
	}
	
	/**
	 * Constructor with parameters
	 * @param name - accessory item
	 * @param description - short technical specification 
	 * @param cost - market price (ebay)
	 */
	public Accessory(String name,  String description, 
					double cost){
		this.setName(name);
		this.setDescription(description);
		this.setCost(cost);
	}
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
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
	
	@Override
	public String toString(){
		NumberFormat formatter = new DecimalFormat("#0.00");
		final StringBuilder sb = new StringBuilder();
		sb.append(this.getName().toUpperCase());
		sb.append(":\t");
		sb.append(this.getDescription());
		sb.append(", $").append(formatter.format(this.getCost()));
		return sb.toString();
	}
	
}
