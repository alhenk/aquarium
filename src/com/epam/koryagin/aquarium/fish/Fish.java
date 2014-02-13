package com.epam.koryagin.aquarium.fish;

import java.math.BigDecimal;

import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.item.Item;

/**
 * Class Fish Minimum Tank Size: 30 gallons Care Level: Easy Temperament:
 * Semi-aggressive Water Conditions: 74-79° F, KH 4-10, pH 6.0-7.0 Max. Size:
 * 3" Color Form: Black, Orange, White, Yellow Diet: Omnivore Compatibility:
 * View Chart Origin: Farm Raised, USA Family: Cyprinidae
 * 
 * @author Koryagin
 * @data 2013.12.11
 * @version 1.0.0
 */
public class Fish extends Animal {

	private double pHMax;
	private double pHMin;
	private double waterTemperatureMax;
	private double waterTemperatureMin;

	/**
	 * Default constructor, to be on the safe side.
	 */
	public Fish() {
		super(); // just a filler
	}
	/**
	 * Constructor with Builder
	 * @param name
	 * @param description 
	 * @param price - market price
	 */
	public Fish(Builder builder) {
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

		public Fish build() {
			return new Fish(this);
		}
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

	public double getpHMax() {
		return pHMax;
	}

	public double getpHMin() {
		return pHMin;
	}

	public double getTemperatureMax() {
		return waterTemperatureMax;
	}

	public double getTemperatureMin() {
		return waterTemperatureMin;
	}

	public double getWaterTemperatureMax() {
		return waterTemperatureMax;
	}

	public double getWaterTemperatureMin() {
		return waterTemperatureMin;
	}

	public void setpHMax(double pHMax) {
		this.pHMax = pHMax;
	}

	public void setpHMin(double pHMin) {
		this.pHMin = pHMin;
	}

	public void setTemperatureMax(double temperatureMax) {
		this.waterTemperatureMax = temperatureMax;
	}

	public void setTemperatureMin(double temperatureMin) {
		this.waterTemperatureMin = temperatureMin;
	}

}
