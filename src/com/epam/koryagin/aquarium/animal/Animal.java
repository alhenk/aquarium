/**
 * 
 */
package com.epam.koryagin.aquarium.animal;

import java.text.DecimalFormat;
import java.text.NumberFormat;

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
	private double sizeMax;
	private double tankVolumeMin;
	private String taxonomy;

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

	public double getSize() {
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
		return sb.toString();
	}
}
