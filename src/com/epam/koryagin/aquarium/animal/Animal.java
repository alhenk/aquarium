/**
 * 
 */
package com.epam.koryagin.aquarium.animal;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.epam.koryagin.aquarium.Item;

/**
 * Super class of aquarium inhabitants
 *  
 * @author Koryagin
 * @date 2013.12.09
 * @version 1.0.0
 */

public abstract class Animal extends Item{
	private String taxonomy;
	
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
