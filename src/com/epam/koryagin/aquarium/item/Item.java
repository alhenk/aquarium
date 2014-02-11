package com.epam.koryagin.aquarium.item;

import java.math.BigDecimal;

/**
 * The top of subject hierarchy, superclass for tank, animal and accessory
 * 
 * @author Koryagin
 * 
 */
public abstract class Item implements Comparable<Item> {
	private int UID;
	private String name;
	private String description;
	private BigDecimal price;

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getUID() {
		return UID;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setUID(int uid) {
		this.UID = uid;
	}

}
