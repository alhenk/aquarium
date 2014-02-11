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
	public Item fetchItem(int uid) {
		StringBuilder sb;
		String keyName;
		String name;
		String description;
		BigDecimal price;
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

					Item item = new Accessory(uid, name, description, price);
					return item;
				} catch (MissingResourceException e){
					LOGGER.error("No such item");
				}
			}
		}
		return null;
	}
}
