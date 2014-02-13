/**
 * 
 */
package com.epam.koryagin.aquarium.accessory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;


import com.epam.koryagin.aquarium.item.Item;

/**
 * Accessory for Aquarium Tank
 * 
 * @author Koryagin
 * @date 2013.12.12
 * @version 1.0.0
 */
public class Accessory extends Item {

	private AccessoryType type;

	/**
	 * Default constructor to be on the safe side;
	 */
	public Accessory() {
		super(); // just a filler
	}
	/**
	 * Constructor with Builder
	 * @param name
	 * @param description 
	 * @param price - market price
	 */
	public Accessory(Builder builder) {
		this.setUID(builder.uid);
		this.setName(builder.name);
		this.setDescription(builder.description);
		this.setPrice(builder.price);
	}

	public static class Builder {
		private int uid;
		private String name;
		private String description = "NA";
		private BigDecimal price = BigDecimal.ZERO;

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

		public Accessory build() {
			return new Accessory(this);
		}
	}

	@Override
	public String toString() {
		NumberFormat formatter = new DecimalFormat("#0.00");
		final StringBuilder sb = new StringBuilder();
		sb.append(this.getName().toUpperCase());
		sb.append(":\t");
		sb.append(this.getDescription());
		sb.append(", $").append(formatter.format(this.getPrice()));
		return sb.toString();
	}

	public AccessoryType getType() {
		return type;
	}

	public void setType(AccessoryType type) {
		this.type = type;
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
}
