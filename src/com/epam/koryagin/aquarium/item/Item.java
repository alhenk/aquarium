package com.epam.koryagin.aquarium.item;

import java.math.BigDecimal;

/**
 * The top of subject hierarchy,
 * superclass for tank, animal and accessory
 * @author Koryagin
 *
 */
public abstract class Item {
	private String name;
	private int id;
	private String description;
	private BigDecimal price;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
