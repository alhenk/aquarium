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
		sb.append( this.getUID());
		sb.append(")\t");
		sb.append(this.getName().toUpperCase());
		sb.append(":\t");
		sb.append(this.getTaxonomy());
		sb.append(", $").append(formatter.format(this.getPrice()));
		return sb.toString();
	}
}
