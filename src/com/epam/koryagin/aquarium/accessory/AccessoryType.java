package com.epam.koryagin.aquarium.accessory;

import java.util.HashMap;
import java.util.Map;

import com.epam.koryagin.aquarium.ItemType;

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
	PUMP(1,"Pump","300Gal Aquarium Adjustable Air Pump, 6 Air Stones, 25 feet Tubing"),
	FILTER(2,"Filter","100 Gallon Aquarium Fish Tank Canister Filter + 9W UV Sterilizer 370 GPH"),
	ALGEA(3,"Algea","Freshwater aquarium algae"),
	SAND(4,"Sand","Petco Black Aquarium Sand"),
	PEBLES(5,"Pebles","Sonora River Pebbles10 Pounds Natural Aquarium Fish Terrarium Gravel Decorative"),
	LAMP(6,"Lamp","LED 48\" 800 Aquarium Light Freshwater Tropical Fish Single Bright Lunar 120 cm"),
	THERMOMETER(7,"Thermometer","LCD Digital Fish Aquarium Thermometer Water Terrarium Black FREE Extra Batteries"),
	HEATER(8,"Heater","200W Watt 110V Automatic Submersible Fish Tank Aquarium Warmer Heater US Plug");
	
	private int code;
	private String name;
	private String description;
	
	private static Map<Integer, AccessoryType> codeToAccessoryTypeMapping;
	
	/**
	 * Accessories Constructor
	 * @param code - for navigating through the menu in CLI
	 * @param name - accessory item
	 * @param description - short technical specification
	 */
	private AccessoryType(int code, String name, String description){
		this.code = code;
		this.name = name;
		this.description = description;		
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
            codeToAccessoryTypeMapping.put(a.code, a);
        }
    }
	
	public String getDescription() {
		return description;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		final StringBuilder sb = new StringBuilder();
		sb.append(this.getCode()).append(" - ");
		sb.append(this.getName());
		sb.append(" ");
		sb.append(this.getDescription());
		return sb.toString();
	}
}
