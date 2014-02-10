package com.epam.koryagin.aquarium.resource_manager;

import java.math.BigDecimal;
import java.util.ResourceBundle;

public class FishPropertiesDAO implements FishDAO {
	//private static final Logger LOGGER = Logger.getLogger(FishPropertiesDAO.class);
	private ResourceBundle resources;
	/**
	 * Default constructor
	 */
	public FishPropertiesDAO() {
		super();
	}
	
	/**
	 * Constructor with a parameter
	 * @param baseName
	 * property file name
	 */
	public FishPropertiesDAO(String baseName) {
		super();
		resources = ResourceBundle.getBundle(baseName);
	}
	
	@Override
	public BigDecimal fetchFishMinPrice() {
		return Properties.checkBigDecimalProperty(resources, "fish.minPrice");
	}

	@Override
	public BigDecimal fetchFishMaxPrice() {
		return Properties.checkBigDecimalProperty(resources, "fish.maxPrice");
	}
	
}
