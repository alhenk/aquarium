/**
 * 
 */
package com.epam.koryagin.aquarium.reptile;

import java.math.BigDecimal;

import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.item.Item;

/**
 * Class Reptile includes: Order Crocodilia - crocodiles, alligators, caimans,
 * gavials Order Rhynchocephalia - tuataras Order Squamata - amphisbaenians,
 * lizards, snakes Order Testudines - terrapins, tortoises, tortues, turtles
 * 
 * IT DOESN'T NEED TO CREATE SUBCLASSES OF REPTILE - subclasses don't add
 * valuable extensions - subclass differences can be described in String field -
 * the number of reptile's cardinal species is small and suitable for
 * enumeration
 * 
 * @author Koryagin
 * @data 2013.12.11
 * @version 1.0.0
 */
public class Reptile extends Animal {
	private double humidity;
	private double airTemperatureMax;
	private double airTemperatureMin;

	/**
	 * Default constructor
	 */
	public Reptile() {
		super();
	}
	/**
	 * Constructor with Builder
	 * @param name
	 * @param description 
	 * @param price - market price
	 */
	public Reptile(Builder builder) {
		this.setUID(builder.uid);
		this.setName(builder.name);
		this.setDescription(builder.description);
		this.setPrice(builder.price);
		this.setTaxonomy(builder.taxonomy);
		this.setSizeMax(builder.sizeMax);
		this.setTankVolumeMin(builder.tankVolumeMin);
	}

	public static class Builder {
		private int uid;
		private String name;
		private String description = "NA";
		private BigDecimal price = BigDecimal.ZERO;
		private String taxonomy = "NA";
		private double sizeMax = 0.0;
		private double tankVolumeMin = 0.0;

		public Builder(int uid, String name) {
			this.uid = uid;
			this.name = name;
		}

		public Builder description(String text) {
			description = text;
			return this;
		}

		public Builder price(BigDecimal val) {
			price = val;
			return this;
		}

		public Builder taxonomy(String text) {
			taxonomy = text;
			return this;
		}

		public Builder sizeMax(double val) {
			sizeMax = val;
			return this;
		}
		
		public Builder tankVolumeMin(double val) {
			tankVolumeMin = val;
			return this;
		}

		public Reptile build() {
			return new Reptile(this);
		}
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(airTemperatureMax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(airTemperatureMin);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(humidity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reptile other = (Reptile) obj;
		if (Double.doubleToLongBits(airTemperatureMax) != Double
				.doubleToLongBits(other.airTemperatureMax))
			return false;
		if (Double.doubleToLongBits(airTemperatureMin) != Double
				.doubleToLongBits(other.airTemperatureMin))
			return false;
		if (Double.doubleToLongBits(humidity) != Double
				.doubleToLongBits(other.humidity))
			return false;
		return true;
	}
	/**
	 * Ternary vs. Integer.compare(a,b) Ternary used for versions earlier
	 * Java1.7
	 */
	@Override
	public int compareTo(Item o) {
		return (this.getUID() < o.getUID()) ? -1 : ((this.getUID() == o
				.getUID()) ? 0 : 1);
	}

	//Getters & Setters
	public double getAirTemperatureMax() {
		return airTemperatureMax;
	}

	public double getAirTemperatureMin() {
		return airTemperatureMin;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setAirTemperatureMax(double airTemperatureMax) {
		this.airTemperatureMax = airTemperatureMax;
	}

	public void setAirTemperatureMin(double airTemperatureMin) {
		this.airTemperatureMin = airTemperatureMin;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
}
