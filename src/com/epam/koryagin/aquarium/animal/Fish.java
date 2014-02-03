package com.epam.koryagin.aquarium.animal;

/**
 * Class Fish
 * @author Koryagin
 * @data 2013.12.11
 * @version 1.0.0
 */
public class Fish extends Animal {
	
	private double waterTemperatureMax;
	private double waterTemperatureMin;
	private double pHMax;
	private double pHMin;
	private double aquariumMinVolume;
	
	/**
	 * Default constructor;
	 */
	public Fish(){
		super();
	}
	/**
	 * 
	 * @return
	 */
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
		
}
