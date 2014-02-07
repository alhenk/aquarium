package com.epam.koryagin.aquarium.resource_manager;

import java.math.BigDecimal;
import java.util.ResourceBundle;

public class FishProperties implements FishDAO {

	private ResourceBundle resources;
	/**
	 * Default constructor
	 */
	public FishProperties() {
		super();
	}
	
	/**
	 * Constructor with parameters
	 * 
	 * @param baseName
	 *            property file name
	 */
	public FishProperties(String baseName) {
		super();
		resources = ResourceBundle.getBundle(baseName);
	}
	
	
	@Override
	public BigDecimal fetchFishMinPrice() {
		
		return BigDecimal.valueOf(Double.parseDouble(resources.getString("fish.minPrice")));
	}

}
