package com.epam.koryagin.aquarium.resource_manager;

import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.epam.koryagin.aquarium.tank.Tank;
import com.epam.koryagin.aquarium.item.Item;

public class TankDAO implements ItemDAO {
	private static final Logger LOGGER = Logger.getLogger(TankDAO.class);
	public static ResourceBundle tankType = ResourceBundle.getBundle("com.epam.koryagin.aquarium.resources.tankType");
	public static ResourceBundle tankProperties = ResourceBundle.getBundle("com.epam.koryagin.aquarium.resources.tank");
	
	@Override
	public Item getItem(int uid) {
		StringBuilder sb;
		String keyName;
		String name;
		String description;
		BigDecimal price;
		BigDecimal priceMin;
		BigDecimal priceMax;
		double volume;
		Enumeration<String> tankList = tankType.getKeys();
		while (tankList.hasMoreElements()){
			keyName = tankList.nextElement();
			if (Properties.checkIntegerProperty(tankType, keyName) == uid){
				try{
					sb = new StringBuilder();
					sb.append("tank.").append(keyName).append(".name");
					name = tankProperties.getString(sb.toString());
				
					sb = new StringBuilder();
					sb.append("tank.").append(keyName).append(".description");
					description = tankProperties.getString(sb.toString());
				
					sb = new StringBuilder();
					sb.append("tank.").append(keyName).append(".price");
					price = Properties.checkBigDecimalProperty(tankProperties, sb.toString());
					
					sb = new StringBuilder();
					sb.append("tank.").append(keyName).append(".priceMin");
					priceMin = Properties.checkBigDecimalProperty(tankProperties, sb.toString());
					
					sb = new StringBuilder();
					sb.append("tank.").append(keyName).append(".priceMax");
					priceMax = Properties.checkBigDecimalProperty(tankProperties, sb.toString());
					
					sb = new StringBuilder();
					sb.append("tank.").append(keyName).append(".volume");
					volume = Properties.checkDoubleProperty(tankProperties, sb.toString());
					
					price = Properties.randomPrice(priceMin, priceMax);
					
					Item item = new Tank.Builder(uid, name).description(description)
										.price(price).volume(volume).build();
					return item;
				} catch (MissingResourceException e){
					LOGGER.error("No such item");
				}
			}
		}
		return null;
	}
}
