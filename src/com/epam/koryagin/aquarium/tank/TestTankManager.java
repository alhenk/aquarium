package com.epam.koryagin.aquarium.tank;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.koryagin.aquarium.accessory.Accessory;
import com.epam.koryagin.aquarium.accessory.AccessoryType;
import com.epam.koryagin.aquarium.fish.Fish;
import com.epam.koryagin.aquarium.fish.FishType;
import com.epam.koryagin.aquarium.reptile.Reptile;
import com.epam.koryagin.aquarium.reptile.ReptileType;

public class TestTankManager{
	private static Tank tank;
	private static Accessory accessory;
	private static Fish fish;
	private static Reptile reptile;
	private static TankManager tm;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tank = new Tank();
		tank.setName("Community tank");
		tank.setDescription(TankType.COMMUNITY_TANK.getDescription());
		tank.setVolume(30.0);
		tank.setPrice(new BigDecimal(123.5));
		
		accessory = new Accessory();
		accessory.setName("Algea");
		accessory.setDescription(AccessoryType.ALGEA.getDescription());
		accessory.setPrice(new BigDecimal(5.36));
		
		fish = new Fish();
		fish.setName("Basslet");
		fish.setTaxonomy(FishType.ANGELFISH.getTaxonomy());
		fish.setPrice(new BigDecimal(3.25));
		
		reptile = new Reptile();
		reptile.setName("Frog");
		reptile.setTaxonomy(ReptileType.FROG.getTaxonomy());
		reptile.setPrice(new BigDecimal(12.5));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tank.addAccessory(accessory);
		tank.addAnimal(fish);
		tank.addAnimal(reptile);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		tm = new TankManager();
		BigDecimal result = tm.calculateTotalSum(tank);
		assertEquals("Total must be 144.61",144.61,result.doubleValue(),0.005); 
		//fail("Not yet implemented");
	}

}
