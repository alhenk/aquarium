package com.epam.koryagin.aquarium.tank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.epam.koryagin.aquarium.item.ItemType;
import com.epam.koryagin.aquarium.resource_manager.Properties;

/**
 * Variety of tank types.
 * A short list of some items instead of type generalization,
 * due to excluding database usage.
 * 
 * @author Koryagin
 * @date 2012.12.12
 * @version 1.0.0
 */
public enum TankType implements ItemType{
	COMMUNITY_TANK(1, "Community Tank", "All Glass Aquarium Tank 29 Gallon (Black) 30 X 12 X 18",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98), 100),
	TROPICAL_AQUARIUM(2,"Tropical Aquarium","250L Cabinet Aquarium Fish Tank Tropical/Marine 107cm 3.4ft",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98), 100),
	SPECIES_TANK(3, "Species Tank", "55 Gallon Oceanic Fish Aquarium Tank with Pump and Stand",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98), 100),
	GOLDFISH_BOWL(4, "Goldfish Bowl", "Vintage Clear Glass Fish Bowl Terrarium Goldfish Betta Fishbowl",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98), 100),
	SHARK_POND(5, "Shark Pond", "Shark pond 5m x 10m x 2m",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98), 100),
	TERRARIUM(6, "Terrarium", "Exo-Terra Glass Terrarium, 24\" L X 18\" W X 24\" H",
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98), 100);
	
	private static void initMapping() {
    	codeToTankTypeMapping = new HashMap<Integer, TankType>();
        for (TankType t : values()) {
        	codeToTankTypeMapping.put(t.uid, t);
        }
    }
	public static TankType select(int i) {
        if (codeToTankTypeMapping == null) {
            initMapping();
        }
        return codeToTankTypeMapping.get(i);
    }
	private int uid;
	private String name;
	private String description;
	private BigDecimal price;
	private BigDecimal priceMax;
	
	
	private BigDecimal priceMin;
	
	private double volume;
	
	private static Map<Integer, TankType> codeToTankTypeMapping;
 
    /**
	 * Tanks Constructor
	 * @param code - for navigating through the menu in CLI
	 * @param name - accessory item
	 * @param description - short technical specification
	 */
	private TankType(int uid, 
			String name, 
			String description, 
			BigDecimal price,
			BigDecimal priceMax,
			BigDecimal priceMin,
			double volume){
		this.uid = uid;
		this.name = name;
		this.description = description;
		this.setPrice(Properties.randomPrice(priceMin, priceMax));
		this.setPriceMax(priceMax);
		this.setPriceMin(priceMin);
		this.setVolume(volume);
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

	public int getUID() {
		return uid;
	}

	public double getVolume() {
		return volume;
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

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getUID()).append(" - ");
		sb.append(this.getName());
		sb.append(" ");
		sb.append(this.getDescription());
		return sb.toString();
	}

}
