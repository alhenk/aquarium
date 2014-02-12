package com.epam.koryagin.aquarium.resource_manager;

import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.epam.koryagin.aquarium.item.Item;
import com.epam.koryagin.aquarium.reptile.Reptile;

public class ReptileDAO implements ItemDAO {
	private static final Logger LOGGER = Logger.getLogger(ReptileDAO.class);
	public static ResourceBundle reptileType = ResourceBundle.getBundle("com.epam.koryagin.aquarium.resources.reptileType");
	public static ResourceBundle reptileProperties = ResourceBundle.getBundle("com.epam.koryagin.aquarium.resources.reptile");
	
	@Override
	public Item getItem(int uid) {
		StringBuilder sb;
		String keyName;
		String name;
		String description;
		BigDecimal price;
		Double sizeMax;
		Double tankVolumeMin;
		String taxonomy;
		BigDecimal priceMin;
		BigDecimal priceMax;
		Enumeration<String> reptileList = reptileType.getKeys();
		while (reptileList.hasMoreElements()){
			keyName = reptileList.nextElement();
			if (Properties.checkIntegerProperty(reptileType, keyName) == uid){
				try{
					sb = new StringBuilder();
					sb.append("reptile.").append(keyName).append(".name");
					name = reptileProperties.getString(sb.toString());
				
					sb = new StringBuilder();
					sb.append("reptile.").append(keyName).append(".description");
					description = reptileProperties.getString(sb.toString());
				
					sb = new StringBuilder();
					sb.append("reptile.").append(keyName).append(".price");
					price = Properties.checkBigDecimalProperty(reptileProperties, sb.toString());
				
					sb = new StringBuilder();
					sb.append("reptile.").append(keyName).append(".taxonomy");
					taxonomy = reptileProperties.getString(sb.toString());
					
					sb = new StringBuilder();
					sb.append("reptile.").append(keyName).append(".sizeMax");
					sizeMax = Properties.checkDoubleProperty(reptileProperties, sb.toString());
					
					sb = new StringBuilder();
					sb.append("reptile.").append(keyName).append(".tankVolumeMin");
					tankVolumeMin = Properties.checkDoubleProperty(reptileProperties, sb.toString());
				
					sb = new StringBuilder();
					sb.append("reptile.").append(keyName).append(".priceMin");
					priceMin = Properties.checkBigDecimalProperty(reptileProperties, sb.toString());
					
					sb = new StringBuilder();
					sb.append("reptile.").append(keyName).append(".priceMax");
					priceMax = Properties.checkBigDecimalProperty(reptileProperties, sb.toString());
					
					price = Properties.randomPrice(priceMin, priceMax);
					
					//DP Builder
					Item item = new Reptile.Builder(uid, name).description(description)
							.price(price).taxonomy(taxonomy).sizeMax(sizeMax)
							.tankVolumeMin(tankVolumeMin).build();
				
					return item;
				} catch (MissingResourceException e){
					LOGGER.error("No such item");
				}
			}
		}
		return null;
	}

}
