package com.epam.koryagin.aquarium.fish;

import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.item.Item;

/**
 * Class Fish
 * Minimum Tank Size: 30 gallons
 * Care Level: Easy
 * Temperament: Semi-aggressive
 * Water Conditions: 74-79° F, KH 4-10, pH 6.0-7.0
 * Max. Size: 3"
 * Color Form: Black, Orange, White, Yellow
 * Diet: Omnivore
 * Compatibility: View Chart
 * Origin: Farm Raised, USA
 * Family: Cyprinidae
 * 
 * @author Koryagin
 * @data 2013.12.11
 * @version 1.0.0
 */
public class Fish extends Animal {
	private double aquariumMinVolume;
	private double pHMax;
	private double pHMin;
	private FishType type;
	private double waterTemperatureMax;
	private double waterTemperatureMin;

	/**
	 * Default constructor, to be on the safe side.
	 */
	public Fish() {
		super(); // just a filler
	}

	public Fish(int uid, String name) {
		this.setUID(uid);
		this.setName(name);
	}

	@Override
	public int compareTo(Item o) {
		return this.getName().compareTo(o.getName());
	}

	// setters & getters
	public double getAquariumVolumeMin() {
		return aquariumMinVolume;
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

	public FishType getType() {
		return type;
	}

	public void setAquariumVolumeMin(double aquariumVolumeMin) {
		this.aquariumMinVolume = aquariumVolumeMin;
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

	public void setType(FishType type) {
		this.type = type;
	}

}
