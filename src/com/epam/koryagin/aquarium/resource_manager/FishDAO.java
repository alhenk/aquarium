package com.epam.koryagin.aquarium.resource_manager;

import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import com.epam.koryagin.aquarium.fish.Fish;
import com.epam.koryagin.aquarium.item.Item;

public class FishDAO implements ItemDAO {
	private static final Logger LOGGER = Logger.getLogger(ItemDAO.class);
	public static ResourceBundle fishType = ResourceBundle.getBundle("com.epam.koryagin.aquarium.resources.fishType");
	public static ResourceBundle fishProperties = ResourceBundle.getBundle("com.epam.koryagin.aquarium.resources.fish");
	
	@Override
	public Item fetchItem(int uid) {
		StringBuilder sb;
		String keyName;
		String name;
		String description;
		BigDecimal price;
		Double sizeMax;
		Double tankVolumeMin;
		String taxonomy;
		Enumeration<String> fishList = fishType.getKeys();
		while (fishList.hasMoreElements()){
			keyName = fishList.nextElement();
			if (Properties.checkIntegerProperty(fishType, keyName) == uid){
				try{
					sb = new StringBuilder();
					sb.append("fish.").append(keyName).append(".name");
					name = fishProperties.getString(sb.toString());
				
					sb = new StringBuilder();
					sb.append("fish.").append(keyName).append(".description");
					description = fishProperties.getString(sb.toString());
				
					sb = new StringBuilder();
					sb.append("fish.").append(keyName).append(".price");
					price = Properties.checkBigDecimalProperty(fishProperties, sb.toString());
				
					sb = new StringBuilder();
					sb.append("fish.").append(keyName).append(".taxonomy");
					taxonomy = fishProperties.getString(sb.toString());
					
					sb = new StringBuilder();
					sb.append("fish.").append(keyName).append(".sizeMax");
					sizeMax = Properties.checkDoubleProperty(fishProperties, sb.toString());
					
					sb = new StringBuilder();
					sb.append("fish.").append(keyName).append(".tankVolumeMin");
					tankVolumeMin = Properties.checkDoubleProperty(fishProperties, sb.toString());
				
					Item item = new Fish(uid, name);
					item.setPrice(price);
					item.setDescription(description);
					((Fish)item).setTaxonomy(taxonomy);
					((Fish)item).setSizeMax(sizeMax);
					((Fish)item).setTankVolumeMin(tankVolumeMin);
					return item;
				} catch (MissingResourceException e){
					LOGGER.error("No such item");
				}
			}
		}
		return null;
	}
}
