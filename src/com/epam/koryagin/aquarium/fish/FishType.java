package com.epam.koryagin.aquarium.fish;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.epam.koryagin.aquarium.item.ItemType;
import com.epam.koryagin.aquarium.resource_manager.Properties;

/**
 * The total number of Fish's species is huge,
 * and it's very difficult to support all of them
 * in the project without database.
 * Thus, it sounds reasonable to enumerate some of them. 
 * 
 * @author Koryagin
 * @date 2013.12.11
 * @version 1.0.0
 */
public enum FishType implements ItemType {
	ANGELFISH(1, "Angelfish","NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class Actinopterygii, Order Perciformes", 10, 10),
	BASSLET(2,"Basslet","NA" ,
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class: Actinopterygii, Order Perciformes", 10, 10),
	BOXFISH(3,"Boxfish","NA",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class: Actinopterygii, Order Tetraodontiformes", 10, 10),
	TIGER_BARB(4,"TigerBarb", "NA", 
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class: Actinopterygii, Order Cypriniformes", 10, 10),
	CARDINALFISH(5,"Cardinalfish","NA",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class: Actinopterygii, Order Perciformes", 10, 10),
	CLOWNFISH(6,"Clownfish","NA",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class: Actinopterygii, Order Perciformes", 10, 10),
	FOXFACE(7,"Foxface","NA",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class: Actinopterygii, Order Perciformes", 10, 10),
	GOBY(8,"Goby","NA",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class: Actinopterygii, Order Perciformes", 10, 10),
	HOGFISH(9,"Hogfish","NA",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class: Actinopterygii, Order Perciformes", 10, 10),
	SEAHORSE(10,"Seahorse","NA",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class: Actinopterygii, Order Syngnathiformes", 10, 10),
	SHARK(11,"Shark","NA",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class: Chondrichthyes, Order Carcharhiniformes", 10, 10),
	TRIGGERFISH(12,"Triggerfish","NA",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class: Actinopterygii, Order Tetraodontiformes", 10, 10),
	WRASSE(13,"Wrasse","NA",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98),
			"Class: Actinopterygii, Order Perciformes", 10, 10);
		
	private int uid;
	private String name;
	private String description;
	private BigDecimal price;
	private BigDecimal priceMax;
	private BigDecimal priceMin;
	private String taxonomy;
	private double sizeMax;
	private double tankVolumeMin;

	private static Map<Integer, FishType> codeToFishTypeMapping;

	/**
	 * Fishes constructor
	 * 
	 * @param code
	 *            - for navigating through the menu in CLI
	 * @param name
	 *            - species' name
	 * @param taxonomy
	 *            - scientific classification
	 */
	private FishType(int uid, String name, String description,
			BigDecimal price, BigDecimal priceMax, BigDecimal priceMin,
			String taxonomy, double sizeMax, double tankVolumeMin){
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

	public static FishType select(int i) {
		if (codeToFishTypeMapping == null) {
			initMapping();
		}
		return codeToFishTypeMapping.get(i);
	}

	private static void initMapping() {
		codeToFishTypeMapping = new HashMap<Integer, FishType>();
		for (FishType f : values()) {
			codeToFishTypeMapping.put(f.uid, f);
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getUID()).append(" - ");
		sb.append(this.getTaxonomy());
		sb.append(" -> ");
		sb.append(this.getName());
		return sb.toString();
	}
	
	public String getTaxonomy() {
		return taxonomy;
	}

	public int getUID() {
		return uid;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(BigDecimal priceMax) {
		this.priceMax = priceMax;
	}

	public BigDecimal getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(BigDecimal priceMin) {
		this.priceMin = priceMin;
	}

	public double getSizeMax() {
		return sizeMax;
	}

	public void setSizeMax(double sizeMax) {
		this.sizeMax = sizeMax;
	}

	public double getTankVolumeMin() {
		return tankVolumeMin;
	}

	public void setTankVolumeMin(double tankVolumeMin) {
		this.tankVolumeMin = tankVolumeMin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
