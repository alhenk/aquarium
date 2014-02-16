/**
 * 
 */
package com.epam.koryagin.aquarium.animal;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Comparator;

import com.epam.koryagin.aquarium.item.Item;

/**
 * Super class of aquarium inhabitants taxonomy - scientific classification
 * sizeMax - maximum size (length)
 * 
 * @author Koryagin
 * @date 2013.12.09
 * @version 1.0.0
 */

public abstract class Animal extends Item {
	public static final Comparator<Animal> NAME_COMPARATOR = new AnimalNameComparator();
	public static final Comparator<Animal> PRICE_COMPARATOR = new AnimalPriceComparator();
	public static final Comparator<Animal> SIZE_COMPARATOR = new AnimalSizeComparator();

	private double sizeMax;
	private double tankVolumeMin;
	private String taxonomy;

	private static class AnimalNameComparator implements Comparator<Animal> {
		@Override
		public int compare(Animal animal1, Animal animal2) {
			return animal1.getName().compareToIgnoreCase(animal2.getName());
		}
	}

	private static class AnimalPriceComparator implements Comparator<Animal> {
		@Override
		public int compare(Animal animal1, Animal animal2) {
			return animal1.getPrice().compareTo(animal2.getPrice());
		}
	}

	private static class AnimalSizeComparator implements Comparator<Animal> {
		@Override
		public int compare(Animal animal1, Animal animal2) {
			Double size1 = new Double(animal1.getSizeMax());
			Double size2 = new Double(animal2.getSizeMax());
			return size1.compareTo(size2);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(sizeMax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tankVolumeMin);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((taxonomy == null) ? 0 : taxonomy.hashCode());
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
		Animal other = (Animal) obj;
		if (Double.doubleToLongBits(sizeMax) != Double
				.doubleToLongBits(other.sizeMax))
			return false;
		if (Double.doubleToLongBits(tankVolumeMin) != Double
				.doubleToLongBits(other.tankVolumeMin))
			return false;
		if (taxonomy == null) {
			if (other.taxonomy != null)
				return false;
		} else if (!taxonomy.equals(other.taxonomy))
			return false;
		return true;
	}

	public double getSizeMax() {
		return sizeMax;
	}

	public double getTankVolumeMin() {
		return tankVolumeMin;
	}

	public String getTaxonomy() {
		return taxonomy;
	}

	public void setSizeMax(double sizeMax) {
		this.sizeMax = sizeMax;
	}

	public void setTankVolumeMin(double tankVolumeMin) {
		this.tankVolumeMin = tankVolumeMin;
	}

	public void setTaxonomy(String taxonomy) {
		this.taxonomy = taxonomy;
	}

	@Override
	public String toString() {
		NumberFormat formatter = new DecimalFormat("#0.00");
		final StringBuilder sb = new StringBuilder();
		sb.append(this.getUID());
		sb.append(")\t");
		sb.append(this.getName().toUpperCase());
		sb.append(":\t");
		sb.append(this.getTaxonomy());
		sb.append(", $").append(formatter.format(this.getPrice()));
		sb.append("\t SIZE = ");
		sb.append(this.getSizeMax());
		sb.append("\t TANK = ");
		sb.append(this.getTankVolumeMin());
		return sb.toString();
	}
}
