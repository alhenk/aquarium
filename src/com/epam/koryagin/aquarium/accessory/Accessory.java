/**
 * 
 */
package com.epam.koryagin.aquarium.accessory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.epam.koryagin.aquarium.item.Item;
	
/**
 * Accessory for Aquarium Tank
 * @author Koryagin
 * @date 2013.12.12
 * @version 1.0.0
 */
public class Accessory extends Item{

	private AccessoryType type;
	
	/**
	 * Default constructor
	 * to be on the safe side;
	 */
	public Accessory(){
		super(); //just a filler
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
			BigDecimal price){
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
	}
	
	
	
	@Override
	public String toString(){
		NumberFormat formatter = new DecimalFormat("#0.00");
		final StringBuilder sb = new StringBuilder();
		sb.append(this.getName().toUpperCase());
		sb.append(":\t");
		sb.append(this.getDescription());
		sb.append(", $").append(formatter.format(this.getPrice()));
		return sb.toString();
	}

	public AccessoryType getType() {
		return type;
	}

	public void setType(AccessoryType type) {
		this.type = type;
	}

	@Override
	public int compareTo(Item o) {
		return this.getName().compareTo(o.getName());
	}
	
}
