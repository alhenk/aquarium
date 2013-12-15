package com.epam.koryagin.aquarium.animal;
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
public enum Fishes implements Animals {
	ANGELFISH(1, "Angelfish", "Class Actinopterygii, Order Perciformes"),
	BASSLET(2,"Basslet", "Class: Actinopterygii, Order Perciformes"),
	BOXFISH(3,"Anthia", "Class: Actinopterygii, Order Tetraodontiformes"),
	BATFISH(4,"Batfish", "Class: Actinopterygii, Order Perciformes"),
	CARDINALFISH(5,"Cardinalfish","Class: Actinopterygii, Order Perciformes"),
	CLOWNFISH(6,"Clownfish","Class: Actinopterygii, Order Perciformes"),
	FOXFACE(7,"Foxface","Class: Actinopterygii, Order Perciformes"),
	GOBY(8,"Goby","Class: Actinopterygii, Order Perciformes"),
	HOGFISH(9,"Hogfish","Class: Actinopterygii, Order Perciformes"),
	SEAHORSE(10,"Seahorse","Class: Actinopterygii, Order Perciformes"),
	SHARK(11,"Shark","Class: Chondrichthyes, Order Carcharhiniformes"),
	TRIGGERFISH(12,"Triggerfish","Class: Actinopterygii, Order Perciformes"),
	WRASSE(13,"Wrasse","Class: Actinopterygii, Order Perciformes");
		
	private int code;
	private String name;
	private String taxonomy;
	
	/**
	 * Fishes constructor
	 * @param code - for navigating through the menu in CLI
	 * @param name - species' name
	 * @param taxonomy - scientific classification
	 */
	private Fishes(int code, String name, String taxonomy){
		this.code = code;
		this.name = name;
		this.taxonomy = taxonomy;
	}
	public String getTaxonomy(){
		return taxonomy;
	}
	public int getCode(){
		return code;
	}
	public String getName(){
		return name;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.getCode()).append(" - ");
		sb.append(this.getTaxonomy());
		sb.append(" -> ");
		sb.append(this.getName());
		return sb.toString();
	}
}
