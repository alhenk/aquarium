package com.epam.koryagin.aquarium.resource_manager;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public final class Properties {
	private static final Logger LOGGER = Logger.getLogger(Properties.class);	
	private Properties(){
	}
	
	public static BigDecimal checkBigDecimalProperty(ResourceBundle resources, String property){
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
	
	public static Integer checkIntegerProperty(ResourceBundle resources, String property){
		Integer result = 0;
		try{
			result = Integer.parseInt(resources.getString(property));
		}catch(NumberFormatException e){
			LOGGER.error("The value of "
					+ property
					+ " is missing or not a number\n"
					+ e);
		}
		return result;
	}
}
