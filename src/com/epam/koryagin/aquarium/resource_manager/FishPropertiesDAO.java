package com.epam.koryagin.aquarium.resource_manager;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class FishPropertiesDAO implements FishDAO {
	private static final Logger LOGGER = Logger.getLogger(FishPropertiesDAO.class);
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
		return checkBigDecimalProperty("fish.minPrice");
	}

	@Override
	public BigDecimal fetchFishMaxPrice() {
		return checkBigDecimalProperty("fish.maxPrice");
	}
	
	private BigDecimal checkBigDecimalProperty(String property){
		BigDecimal result = new BigDecimal(0);
		try{
			result = BigDecimal.valueOf(Double
					.parseDouble(resources.getString(property)));
		}catch(NumberFormatException e){
			LOGGER.error("The value of "
					+ property
					+ " is missing or not a number\n"
					+ e);
		}
		return result;
	}

}
