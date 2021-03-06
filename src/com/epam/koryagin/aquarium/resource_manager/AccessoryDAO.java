package com.epam.koryagin.aquarium.resource_manager;

import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import com.epam.koryagin.aquarium.item.Item;
import com.epam.koryagin.aquarium.accessory.Accessory;

public class AccessoryDAO implements ItemDAO{
	private static final Logger LOGGER = Logger.getLogger(AccessoryDAO.class);
	public static ResourceBundle accessoryType = ResourceBundle.getBundle("com.epam.koryagin.aquarium.resources.accessoryType");
	public static ResourceBundle accessoryProperties = ResourceBundle.getBundle("com.epam.koryagin.aquarium.resources.accessory");
	
	@Override
	public Item getItem(int uid) {
		StringBuilder sb;
		String keyName;
		String name;
		String description;
		BigDecimal price;
		BigDecimal priceMin;
		BigDecimal priceMax;
		Enumeration<String> accessoryList = accessoryType.getKeys();
		while (accessoryList.hasMoreElements()){
			keyName = accessoryList.nextElement();
			if (Properties.checkIntegerProperty(accessoryType, keyName) == uid){
				try{
					sb = new StringBuilder();
					sb.append("accessory.").append(keyName).append(".name");
					name = accessoryProperties.getString(sb.toString());
				
					sb = new StringBuilder();
					sb.append("accessory.").append(keyName).append(".description");
					description = accessoryProperties.getString(sb.toString());
				
					sb = new StringBuilder();
					sb.append("accessory.").append(keyName).append(".price");
					price = Properties.checkBigDecimalProperty(accessoryProperties, sb.toString());
					
					sb = new StringBuilder();
					sb.append("accessory.").append(keyName).append(".priceMin");
					priceMin = Properties.checkBigDecimalProperty(accessoryProperties, sb.toString());
					
					sb = new StringBuilder();
					sb.append("accessory.").append(keyName).append(".priceMax");
					priceMax = Properties.checkBigDecimalProperty(accessoryProperties, sb.toString());
					
					price = Properties.randomPrice(priceMin, priceMax);
					Item item = new Accessory.Builder(uid, name).description(description).price(price).build();
					return item;
				} catch (MissingResourceException e){
					LOGGER.error("No such item");
				}
			}
		}
		return null;
	}
}
