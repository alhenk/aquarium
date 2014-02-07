package com.epam.koryagin.aquarium.resource_manager;

import java.math.BigDecimal;

public interface FishDAO {
	public  BigDecimal fetchFishMinPrice();
	public  BigDecimal fetchFishMaxPrice();

}
