package com.epam.koryagin.aquarium.animal;

import java.util.HashMap;
import java.util.Map;

import com.epam.koryagin.aquarium.ItemType;

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
	TURTLE(1, "Turtle", "Class Reptilia, Order Testudines"),
	TORTOISE(2,"Tortoise", "Class Reptilia, Order Testudines"),
	TERRAPIN(3,"Terrapin", "Class Reptilia, Order Testudines"),
	CROCODILE(4,"Crocodile", "Class Reptilia, Order Crocodilia"),
	ALLIGATOR(5,"Alligator","Class Reptilia, Order Crocodilia"),
	CAIMAN(6,"Caiman","Class Reptilia, Order Crocodilia"),
	GHARIAL(7,"Gharial","Class Reptilia, Order Crocodilia"),
	TAUTARA(8,"Tautara","Class Reptilia, Order Rhynchocephalia"),
	LIZARD(9,"Lizard","Class Reptilia, Order Squamata"),
	SNAKE(10,"Snake","Class Reptilia, Order Squamata"),
	FROG(11,"Frog","Class Reptilia, Order Squamata"),
	SALAMANDER(12,"Salamander","Class Reptilia, Order Squamata");
	
	private int code;
	private String name;
	private String taxonomy;
	
	private static Map<Integer, ReptileType> codeToReptileTypeMapping;
	
	/**
	 * Reptiles Constructor
	 * @param code - for navigating through the menu in CLI
	 * @param name - species' name
	 * @param taxonomy - scientific classification
	 */
	private ReptileType(int code, String name, String taxonomy){
		this.code = code;
		this.name = name;
		this.taxonomy = taxonomy;
	}
	
	public static ReptileType select(int i) {
        if (codeToReptileTypeMapping == null) {
            initMapping();
        }
        return codeToReptileTypeMapping.get(i);
    }
 
    private static void initMapping() {
        codeToReptileTypeMapping = new HashMap<Integer, ReptileType>();
        for (ReptileType r : values()) {
            codeToReptileTypeMapping.put(r.code, r);
        }
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
		sb.append(this.getName().toUpperCase());
		sb.append(this.getCode()).append(" : ");
		sb.append(this.getTaxonomy());

		return sb.toString();
	}
}
