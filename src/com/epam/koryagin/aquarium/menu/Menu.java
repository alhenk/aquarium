package com.epam.koryagin.aquarium.menu;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.epam.koryagin.aquarium.animal.FishFactory;
import com.epam.koryagin.aquarium.animal.Fishes;
import com.epam.koryagin.aquarium.animal.ReptileFactory;
import com.epam.koryagin.aquarium.animal.Reptiles;
import com.epam.koryagin.aquarium.tank.Accessories;
import com.epam.koryagin.aquarium.tank.Tank;
import com.epam.koryagin.aquarium.tank.TankManager;
import com.epam.koryagin.aquarium.tank.Tanks;

public class Menu {
	private States state = States.START;
	private ReptileFactory rf = new ReptileFactory();
	private FishFactory ff = new FishFactory();
	private TankManager tm = new TankManager();
	private static Tank tank;
	
	public States oneStep(int choise){
		
		switch (state){
		case START:
		case INIT_TANK:
			state = initTank(choise);
			break;
		case SELECT_ACCESSORIES:
			state = selectAccessory(choise);
			break;
		case SELECT_FISHES:
			state = selectFish(choise);
			break;
		case EQUIP_AND_POPULATE:
			state = equipMenu(choise);
			break;
		case SELECT_REPTILES:
			state = selectReptile(choise);
			break;
		case EXIT:
		default:
			state = States.EXIT;
			break;
		}
		return state;
	}
	
	public States equipMenu(int command){
		if (command == 0){
			return States.EXIT;
		}
		switch (command){
		case 1:
			state = States.SELECT_FISHES;
			break;
		case 2:
			state = States.SELECT_REPTILES;
			break;
		case 3:
			state = States.SELECT_ACCESSORIES;
			break;
		case 4:
			generateRepor();
			break;
		default:
			state = States.EXIT;
			break;
		}
		return state;
	}
	
	public States initTank(int command){
		if (command == 0){
			return States.EXIT;
		}
		Tanks theItem = findItemByCode(command);
		if(theItem == null){
			System.out.println("Wrong Choise - no such item");
			return States.INIT_TANK;
		}
		switch (theItem){
		case COMMUNITY_TANK :
		case TROPICAL_AQUARIUM :
		case SPECIES_TANK:
		case GOLDFISH_BOWL:
		case SHARK_POND:
		case TERRARIUM:
			state = buyTheItem(theItem);
			break;
		default:
		state = States.EXIT;
			break;
		}
		return state;
	}
	
	public States selectFish(int command){
		if (command == 0){
			return States.EXIT;
		}
		Fishes theItem = findFishByCode(command);
		if(theItem == null){
			System.out.println("Wrong Choise - no such item");
			return States.EQUIP_AND_POPULATE;
		}

		switch (theItem){
		case ANGELFISH:
		case BASSLET:
		case BATFISH:
		case BOXFISH:
		case CARDINALFISH:
		case CLOWNFISH:
		case FOXFACE:
		case GOBY:
		case HOGFISH:
		case SEAHORSE:
		case SHARK:
		case TRIGGERFISH:
		case WRASSE:
			buyTheFish(theItem);
			break;
		default:
			state = States.EXIT;
			break;
		}
		return state;
	}
	
	public States selectReptile(int command){
		if (command == 0){
			return States.EXIT;
		}
		Reptiles theItem = findReptileByCode(command);
		if(theItem == null){
			System.out.println("Wrong Choise - no such item");
			return States.EQUIP_AND_POPULATE;
		}
		switch (theItem){
		case ALLIGATOR:
		case CAIMAN:
		case CROCODILE:
		case FROG:
		case GHARIAL:
		case LIZARD:
		case SALAMANDER:
		case SNAKE:
		case TAUTARA:
		case TERRAPIN:
		case TORTOISE:
		case TURTLE:
			buyTheReptile(theItem);
			break;
		default:
			state = States.EXIT;
			break;
		}
		return state;
	}
	
	public States selectAccessory(int command){
		if (command == 0){
			return States.EXIT;
		}
		Accessories theItem = findAccessoryByCode(command);
		if(theItem == null){
			System.out.println("Wrong Choise - no such item");
			return States.EQUIP_AND_POPULATE;
		}
		switch (theItem){
		case ALGEA:
		case FILTER:
		case HEATER:
		case LAMP:
		case PEBLES:
		case PUMP:
		case SAND:
		case THERMOMETER:
			buyTheAccessory(theItem);
			break;
		default:
			state = States.EXIT;
			break;
		}
		return state;
	}
	
	public void displayInitTankMenu(){
		StringBuilder sb = new StringBuilder();
		for (Tanks t : Tanks.values()){
			sb.append(t.getCode()).append(" ");
			sb.append(t.getName().toUpperCase()).append("\n");
		}
		sb.append("0 EXIT");
		System.out.println(sb.toString());
		System.out.print("> ");
	}
	
	public void displayFishMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (Fishes f : Fishes.values()){
			sb.append(f.getCode()).append(" ");
			sb.append(f.getName().toUpperCase()).append("\n");
		}
		sb.append("0 EXIT");
		System.out.println(sb.toString());
		System.out.print("> ");
	}
	
	public void displayReptileMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (Reptiles r : Reptiles.values()){
			sb.append(r.getCode()).append(" ");
			sb.append(r.getName().toUpperCase()).append("\n");
		}
		sb.append("0 EXIT");
		System.out.println(sb.toString());
		System.out.print("> ");
	}
	public void displayAccessoryMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (Accessories a : Accessories.values()){
			sb.append(a.getCode()).append(" ");
			sb.append(a.getName().toUpperCase()).append("\n");
		}
		sb.append("0 EXIT");
		System.out.println(sb.toString());
		System.out.print("> ");
	}
	
	public void displayEquipMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("\n1 SELECT FISH\n"); 
		sb.append("2 SELECT REPTILE\n");
		sb.append("3 SELECT ACCESSORIES\n");
		sb.append("4 GENERATE REPORT\n");
		sb.append("0 EXIT");
		System.out.println(sb.toString());
		System.out.print("> ");
	}
			
	public States buyTheItem(Tanks theItem){
		if(theItem != null) {
			tank = tm.createTank(theItem);
		} else {
			System.out.println("Wrong Choise - no such item");
			state = States.INIT_TANK;
		}
		state = States.EQUIP_AND_POPULATE;
		return state;
	}
	
	public States buyTheFish(Fishes theItem){
		if(theItem != null) {
			tank.addAnimal(ff.createAnimal(theItem));
		} else {
			System.out.println("Wrong Choise - no such item");
		}
		state = States.EQUIP_AND_POPULATE;
		return state;
	}
	
	public States buyTheReptile(Reptiles theItem){
		if(theItem != null) {
			tank.addAnimal(rf.createAnimal(theItem));
		} else {
			System.out.println("Wrong Choise - no such item");
		}
		state = States.EQUIP_AND_POPULATE;
		return state;
	}
	
	public States buyTheAccessory(Accessories theItem){
		if(theItem != null) {
			tank.addAccessory(tm.createAccessory(theItem));
		} else {
			System.out.println("Wrong Choise - no such item");
		}
		state = States.EQUIP_AND_POPULATE;
		return state;
	}
	
	public States generateRepor(){
		NumberFormat formatter = new DecimalFormat("#0.00");
		StringBuilder sb = new StringBuilder();
		sb.append(tank.toString());
		sb.append("TOTAL: $").append(formatter.format(tm.calculateTotalSum(tank)));
		System.out.println(sb.toString());
		return state;
	}
	
	public Tanks findItemByCode(int code){
		Tanks tank = null;
		for (Tanks t : Tanks.values()){
			if (t.getCode() == code){
				tank = t;
			}
		}
		return tank;
	}
	
	public Fishes findFishByCode(int code){
		Fishes fish = null;
		for (Fishes f : Fishes.values()){
			if (f.getCode() == code){
				fish = f;
			}
		}
		return fish;
	}
	
	public Reptiles findReptileByCode(int code){
		Reptiles reptile = null;
		for (Reptiles r : Reptiles.values()){
			if (r.getCode() == code){
				reptile = r;
			}
		}
		return reptile;
	}
	
	public Accessories findAccessoryByCode(int code){
		Accessories accessory = null;
		for (Accessories a : Accessories.values()){
			if (a.getCode() == code){
				accessory = a;
			}
		}
		return accessory;
	}
		
	public void clean(){
		for(int i = 0; i < 50; i++){
			System.out.println();
		}
	}
}
