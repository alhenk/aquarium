/**
 * 
 */
package com.epam.koryagin.aquarium.animal;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Super class of aquarium inhabitants
 *  
 * @author Koryagin
 * @date 2013.12.09
 * @version 1.0.0
 */
public abstract class Animal {

	private String name; 
	private String taxonomy;
	private String description;
	private double size;
	private double cost;
	
	public double getCost(){
		return cost;
	}
	/**
	 * setCost
	 * @param cost
	 */
	public void setCost(double cost){
		this.cost = cost;
	}
	/**
	 * getName
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public double getSize(){
		return size;
	}
	
	public void setSize(double size){
		this.size = size;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getTaxonomy(){
		return taxonomy;
	}
	public void setTaxonomy(String taxonomy){
		this.taxonomy = taxonomy;
	}
	
	@Override
	public String toString(){
		NumberFormat formatter = new DecimalFormat("#0.00");
		final StringBuilder sb = new StringBuilder();
		sb.append(this.getName().toUpperCase());
		sb.append(":\t");
		sb.append(this.getTaxonomy());
		sb.append(", $").append(formatter.format(this.getCost()));
		return sb.toString();
	}
}
