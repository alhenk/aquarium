package com.epam.koryagin.aquarium.reptile;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.epam.koryagin.aquarium.item.ItemType;
import com.epam.koryagin.aquarium.resource_manager.Properties;

/**
 * The total number of Reptilia's subclasses 
 * and included species is limited,
 * so it sounds reasonable to enumerate them.
 * 
 * @author Koryagin
 * @date 2013.12.11
 * @version 1.0.0
 */
public enum ReptileType implements ItemType {
	TURTLE(1, "Turtle", "NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class Reptilia, Order Testudines", 10, 10),
	TORTOISE(2,"Tortoise", "NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class Reptilia, Order Testudines", 10, 10),
	TERRAPIN(3,"Terrapin", "NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class Reptilia, Order Testudines", 10, 10),
	CROCODILE(4,"Crocodile", "NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class Reptilia, Order Crocodilia", 10, 10),
	ALLIGATOR(5,"Alligator", "NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class Reptilia, Order Crocodilia", 10, 10),
	CAIMAN(6,"Caiman", "NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class Reptilia, Order Crocodilia", 10, 10),
	GHARIAL(7,"Gharial", "NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class Reptilia, Order Crocodilia", 10, 10),
	TAUTARA(8,"Tautara", "NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class Reptilia, Order Rhynchocephalia", 10, 10),
	LIZARD(9,"Lizard", "NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class Reptilia, Order Squamata", 10, 10),
	SNAKE(10,"Snake", "NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class Reptilia, Order Squamata", 10, 10),
	FROG(11,"Frog", "NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class Reptilia, Order Squamata", 10, 10),
	SALAMANDER(12,"Salamander", "NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class Reptilia, Order Squamata", 10, 10);
	
	private static void initMapping() {
		codeToReptileTypeMapping = new HashMap<Integer, ReptileType>();
		for (ReptileType r : values()) {
			codeToReptileTypeMapping.put(r.uid, r);
		}
	}

	public static ReptileType select(int i) {
		if (codeToReptileTypeMapping == null) {
			initMapping();
		}
		return codeToReptileTypeMapping.get(i);
	}

	private int uid;
	private String name;
	private String description;
	private BigDecimal price;
	private BigDecimal priceMax;
	private BigDecimal priceMin;
	private String taxonomy;

	private double sizeMax;

	private double tankVolumeMin;

	private static Map<Integer, ReptileType> codeToReptileTypeMapping;

	/**
	 * Reptiles Constructor
	 * 
	 * @param code
	 *            - for navigating through the menu in CLI
	 * @param name
	 *            - species' name
	 * @param taxonomy
	 *            - scientific classification
	 */
	private ReptileType(int uid, String name, String description,
			BigDecimal price, BigDecimal priceMax, BigDecimal priceMin,
			String taxonomy, double sizeMax, double tankVolumeMin) {
		this.uid = uid;
		this.name = name;
		this.setDescription(description);
		this.setPrice(Properties.randomPrice(priceMin, priceMax));
		this.setPriceMax(priceMax);
		this.setPriceMin(priceMin);
		this.taxonomy = taxonomy;
		this.sizeMax = sizeMax;
		this.tankVolumeMin = tankVolumeMin;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getPriceMax() {
		return priceMax;
	}

	public BigDecimal getPriceMin() {
		return priceMin;
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

	public int getUID() {
		return uid;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setPriceMax(BigDecimal priceMax) {
		this.priceMax = priceMax;
	}

	public void setPriceMin(BigDecimal priceMin) {
		this.priceMin = priceMin;
	}

	public void setSizeMax(double sizeMax) {
		this.sizeMax = sizeMax;
	}

	public void setTankVolumeMin(double tankVolumeMin) {
		this.tankVolumeMin = tankVolumeMin;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getUID()).append(" - ");
		sb.append(this.getName().toUpperCase());
		sb.append(this.getUID()).append(" : ");
		sb.append(this.getTaxonomy());

		return sb.toString();
	}
}
