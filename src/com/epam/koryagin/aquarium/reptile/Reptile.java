/**
 * 
 */
package com.epam.koryagin.aquarium.reptile;

import java.math.BigDecimal;

import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.item.Item;

/**
 * Class Reptile includes:
 * 	Order Crocodilia  -  crocodiles, alligators, caimans, gavials
 * 	Order Rhynchocephalia  - tuataras
 *  Order Squamata  - amphisbaenians, lizards, snakes
 *  Order Testudines - terrapins, tortoises, tortues, turtles
 *  
 *  IT DOESN'T NEED TO CREATE SUBCLASSES OF REPTILE
 *  	- subclasses don't add valuable extensions
 *  	- subclass differences can be described in String field
 *  	- the number of reptile's cardinal species is small 
 *  	and suitable for enumeration
 *  
 * @author Koryagin
 * @data 2013.12.11
 * @version 1.0.0
 */
public class Reptile extends Animal {
	private ReptileType type;
	private double humidity ;
	private double airTemperatureMax;
	private double airTemperatureMin;
	/**
	 * Default constructor
	 */
	public Reptile(){
		super();
	}
	/**
	 * Constructor with one parameter
	 * @param name - species name 
	 */
	public Reptile(String name){
		this.setName(name);
	}
	/**
	 * Constructor with parameters
	 * @param name - reptile name
	 * @param description - taxonomic classification
	 * @param cost 
	 * @param size - length 
	 */
	public Reptile(String name, String taxonomy, String description, 
			BigDecimal price, double size){
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
		this.setSizeMax(size);
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public double getAirTemperatureMax() {
		return airTemperatureMax;
	}
	public void setAirTemperatureMax(double airTemperatureMax) {
		this.airTemperatureMax = airTemperatureMax;
	}
	public double getAirTemperatureMin() {
		return airTemperatureMin;
	}
	public void setAirTemperatureMin(double airTemperatureMin) {
		this.airTemperatureMin = airTemperatureMin;
	}
	public ReptileType getType() {
		return type;
	}
	public void setType(ReptileType type) {
		this.type = type;
	}
	@Override
	public int compareTo(Item o) {
		return this.getName().compareTo(o.getName());
	}
}
