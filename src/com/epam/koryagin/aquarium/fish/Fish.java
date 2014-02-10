package com.epam.koryagin.aquarium.fish;

import com.epam.koryagin.aquarium.animal.Animal;
import com.epam.koryagin.aquarium.item.Item;

/**
 * Class Fish
 * @author Koryagin
 * @data 2013.12.11
 * @version 1.0.0
 */
public class Fish extends Animal {
	//Minimum Tank Size: 30 gallons
	//Care Level: Easy
	//Temperament: Semi-aggressive
	//Water Conditions: 74-79° F, KH 4-10, pH 6.0-7.0
	//Max. Size: 3"
	//Color Form: Black, Orange, White, Yellow
	//Diet: Omnivore
	//Compatibility: View Chart
	//Origin: Farm Raised, USA
	//Family: Cyprinidae
	private FishType type;

	private double waterTemperatureMax;
	private double waterTemperatureMin;
	private double pHMax;
	private double pHMin;
	private double aquariumMinVolume;
	
	/**
	 * Default constructor
	 * to be on the safe side.
	 */
	public Fish(){
		super(); //just a filler
	}
	
	
	public double getTemperatureMax() {
		return waterTemperatureMax;
	}

	public void setTemperatureMax(double temperatureMax) {
		this.waterTemperatureMax = temperatureMax;
	}

	public double getTemperatureMin() {
		return waterTemperatureMin;
	}

	public void setTemperatureMin(double temperatureMin) {
		this.waterTemperatureMin = temperatureMin;
	}

	public double getpHMax() {
		return pHMax;
	}

	public void setpHMax(double pHMax) {
		this.pHMax = pHMax;
	}

	public double getpHMin() {
		return pHMin;
	}

	public void setpHMin(double pHMin) {
		this.pHMin = pHMin;
	}

	public double getAquariumVolumeMin() {
		return aquariumMinVolume;
	}

	public void setAquariumVolumeMin(double aquariumVolumeMin) {
		this.aquariumMinVolume = aquariumVolumeMin;
	}


	public FishType getType() {
		return type;
	}


	public void setType(FishType type) {
		this.type = type;
	}


	@Override
	public int compareTo(Item o) {
		return this.getName().compareTo(o.getName());
	}
		
}

