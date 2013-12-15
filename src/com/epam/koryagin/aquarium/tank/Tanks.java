package com.epam.koryagin.aquarium.tank;
/**
 * Variety of tank types.
 * TODO This item needs an idea of classification and hierarchy
 * A short list of some items instead of type generalization,
 * due to excluding database usage.
 * 
 * @author Koryagin
 * @date 2012.12.12
 * @version 1.0.0
 */
public enum Tanks {
	
	COMMUNITY_TANK(1,"Community Tank","All Glass Aquarium Tank 29 Gallon (Black) 30 X 12 X 18"),
	TROPICAL_AQUARIUM(2,"Tropical Aquarium","250L Cabinet Aquarium Fish Tank Tropical/Marine 107cm 3.4ft"),
	SPECIES_TANK(3,"Species Tank","55 Gallon Oceanic Fish Aquarium Tank with Pump and Stand"),
	GOLDFISH_BOWL(4,"Goldfish Bowl","Vintage Clear Glass Fish Bowl Terrarium Goldfish Betta Fishbowl"),
	SHARK_POND(5,"Shark Pond","Shark pond 5m x 10m x 2m"),
	TERRARIUM(6,"Terrarium","Exo-Terra Glass Terrarium, 24\" L X 18\" W X 24\" H");
	
	private int code;			
	private String name;		
	private String description;
	
	/**
	 * Tanks Constructor
	 * @param code - for navigating through the menu in CLI
	 * @param name - accessory item
	 * @param description - short technical specification
	 */
	private Tanks(int code, String name, String description){
		this.code = code;
		this.name = name;
		this.description = description;		
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
		StringBuilder sb = new StringBuilder();
		sb.append(this.getCode()).append(" - ");
		sb.append(this.getName());
		sb.append(" ");
		sb.append(this.getDescription());
		return sb.toString();
	}

}
