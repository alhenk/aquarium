package com.epam.koryagin.aquarium.resource_manager;

/**
 * Resource Manager aggregates all properties
 * @author Koryagin
 * @date 2014.02.07
 *
 */
public final class ResourceManager {
	
	public static FishDAO fishDao = new FishPropertiesDAO("com.epam.koryagin.aquarium.resources.fish");
	
	/**
	 * Default constructor
	 */
	private ResourceManager() {
		super();
	}
}
