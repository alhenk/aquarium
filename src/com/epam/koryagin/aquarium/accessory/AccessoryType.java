package com.epam.koryagin.aquarium.accessory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.epam.koryagin.aquarium.item.ItemType;
import com.epam.koryagin.aquarium.resource_manager.Properties;

/**
 * Assortment of accessories for aquarium.
 * A short list of some items instead of type generalization,
 * due to excluding database usage.
 * 
 * @author Koryagin
 * @date 2013.12.11
 * @version 1.0.0
 */
public enum AccessoryType implements ItemType{
	PUMP(1,"Pump","300Gal Aquarium Adjustable Air Pump, 6 Air Stones, 25 feet Tubing", 
			new BigDecimal(53.98), new BigDecimal(66.45), new BigDecimal(49.98)),
	FILTER(2,"Filter","100 Gallon Aquarium Fish Tank Canister Filter + 9W UV Sterilizer 370 GPH",
			new BigDecimal(52.99),new BigDecimal(66.45),new BigDecimal(44.99)),
	ALGAE(3,"Algae","Freshwater aquarium algae",
			new BigDecimal(13.98), new BigDecimal(15.0),new BigDecimal(12.0)),
	SAND(4,"Sand","Petco Black Aquarium Sand", 
			new BigDecimal(12.99), new BigDecimal(17.99), new BigDecimal(4.99)),
	PEBLES(5,"Pebles","Sonora River Pebbles10 Pounds Natural Aquarium Fish Terrarium Gravel Decorative",
			new BigDecimal(25.99),new BigDecimal(31.9),new BigDecimal(50.50)),
	LAMP(6,"Lamp","LED 48\" 800 Aquarium Light Freshwater Tropical Fish Single Bright Lunar 120 cm",
			new BigDecimal(85.99),new BigDecimal(132.85),new BigDecimal(53.95)),
	THERMOMETER(7,"Thermometer","LCD Digital Fish Aquarium Thermometer Water Terrarium Black FREE Extra Batteries",
			new BigDecimal(20.9),new BigDecimal(8.85),new BigDecimal(4.27)),
	HEATER(8,"Heater","200W Watt 110V Automatic Submersible Fish Tank Aquarium Warmer Heater US Plug",
			new BigDecimal(17.99),new BigDecimal(27.99),new BigDecimal(7.98));
	
	private int uid;
	private String name;
	private String description;
	private BigDecimal price;
	private BigDecimal priceMax;
	private BigDecimal priceMin;
	
	private static Map<Integer, AccessoryType> codeToAccessoryTypeMapping;
	
	/**
	 * Accessories Constructor
	 * @param code - for navigating through the menu in CLI
	 * @param name - accessory item
	 * @param description - short technical specification
	 */
	private AccessoryType(
			int uid, 
			String name, 
			String description, 
			BigDecimal price,
			BigDecimal priceMax,
			BigDecimal priceMin){
		this.uid = uid;
		this.name = name;
		this.description = description;
		this.setPrice(Properties.randomPrice(priceMin, priceMax));
		this.setPriceMax(priceMax);
		this.setPriceMin(priceMin);		
	}
		
	public static AccessoryType select(int i) {
        if (codeToAccessoryTypeMapping == null) {
            initMapping();
        }
        return codeToAccessoryTypeMapping.get(i);
    }
 
    private static void initMapping() {
        codeToAccessoryTypeMapping = new HashMap<Integer, AccessoryType>();
        for (AccessoryType a : values()) {
            codeToAccessoryTypeMapping.put(a.uid, a);
        }
    }
	
	public String getDescription() {
		return description;
	}

	public int getUID() {
		return uid;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		final StringBuilder sb = new StringBuilder();
		sb.append(this.getUID()).append(" - ");
		sb.append(this.getName());
		sb.append(" ");
		sb.append(this.getDescription());
		return sb.toString();
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
}
