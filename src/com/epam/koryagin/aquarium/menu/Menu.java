package com.epam.koryagin.aquarium.menu;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.epam.koryagin.aquarium.accessory.AccessoryFactory;
import com.epam.koryagin.aquarium.accessory.AccessoryType;
import com.epam.koryagin.aquarium.fish.FishFactory;
import com.epam.koryagin.aquarium.fish.FishType;
import com.epam.koryagin.aquarium.item.ItemType;
import com.epam.koryagin.aquarium.print.Console;
import com.epam.koryagin.aquarium.print.PrintBehavior;
import com.epam.koryagin.aquarium.reptile.ReptileFactory;
import com.epam.koryagin.aquarium.reptile.ReptileType;
import com.epam.koryagin.aquarium.resource_manager.Local;
import com.epam.koryagin.aquarium.resource_manager.LocalType;
import com.epam.koryagin.aquarium.tank.Tank;
import com.epam.koryagin.aquarium.tank.TankManager;
import com.epam.koryagin.aquarium.tank.TankType;

public class Menu {
	private static final PrintBehavior OUTPUT = new Console();
	private Local local = new Local(LocalType.CYR);
	private State state = State.START;
	private ReptileFactory rf = new ReptileFactory();
	private FishFactory ff = new FishFactory();
	private AccessoryFactory am = new AccessoryFactory();
	private TankManager tm = new TankManager();
	private static Tank tank;
	
	public State oneStep(int choise){
		
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
			state = State.EXIT;
			break;
		}
		return state;
	}
	
	public State equipMenu(int command){
		if (command == 0){
			return State.EXIT;
		}
		switch (command){
		case 1:
			state = State.SELECT_FISHES;
			break;
		case 2:
			state = State.SELECT_REPTILES;
			break;
		case 3:
			state = State.SELECT_ACCESSORIES;
			break;
		case 4:
			generateRepor();
			break;
		default:
			state = State.EXIT;
			break;
		}
		return state;
	}
	
	public State initTank(int command){
		if (command == 0){
			return State.EXIT;
		}
		TankType theItem = TankType.select(command);
		if(theItem == null){
			OUTPUT.println(local.getString("message.menu.wrongChoice"));
			return State.INIT_TANK;
		}
		switch (theItem){
		case COMMUNITY_TANK :
		case TROPICAL_AQUARIUM :
		case SPECIES_TANK:
		case GOLDFISH_BOWL:
		case SHARK_POND:
		case TERRARIUM:
			state = buyTheItem((TankType)theItem);
			break;
		default:
		state = State.EXIT;
			break;
		}
		return state;
	}
	
	public State selectFish(int command){
		if (command == 0){
			return State.EXIT;
		}
		FishType theItem = FishType.select(command);
		if(theItem == null){
			OUTPUT.println(local.getString("message.menu.wrongChoice"));
			return State.EQUIP_AND_POPULATE;
		}

		switch (theItem){
		case ANGELFISH:
		case BASSLET:
		case TIGER_BARB:
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
			buyTheItem((ItemType)theItem);
			break;
		default:
			state = State.EXIT;
			break;
		}
		return state;
	}
	
	public State selectReptile(int command){
		if (command == 0){
			return State.EXIT;
		}
		ReptileType theItem = ReptileType.select(command);
		if(theItem == null){
			OUTPUT.println(local.getString("message.menu.wrongChoice"));
			return State.EQUIP_AND_POPULATE;
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
			buyTheItem((ItemType)theItem);
			break;
		default:
			state = State.EXIT;
			break;
		}
		return state;
	}
	
	public State selectAccessory(int command){
		if (command == 0){
			return State.EXIT;
		}
		AccessoryType theItem = AccessoryType.select(command);
		if(theItem == null){
			OUTPUT.println(local.getString("message.menu.wrongChoice"));
			return State.EQUIP_AND_POPULATE;
		}
		switch (theItem){
		case ALGAE:
		case FILTER:
		case HEATER:
		case LAMP:
		case PEBLES:
		case PUMP:
		case SAND:
		case THERMOMETER:
			buyTheItem((ItemType)theItem);
			break;
		default:
			state = State.EXIT;
			break;
		}
		return state;
	}
	
	public void displayInitTankMenu(){
		StringBuilder sb = new StringBuilder();
		for (TankType t : TankType.values()){
			sb.append(t.getUID()).append(" ");
			sb.append(t.getName().toUpperCase()).append("\n");
		}
		sb.append("0 ");
		sb.append(local.getString("message.menu.exit"));
		OUTPUT.println(sb.toString());
		OUTPUT.print("> ");
	}
	
	public void displayFishMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (FishType f : FishType.values()){
			sb.append(f.getUID()).append(" ");
			sb.append(f.getName().toUpperCase()).append("\n");
		}
		sb.append("0 ");
		sb.append(local.getString("message.menu.exit"));
		OUTPUT.println(sb.toString());
		OUTPUT.print("> ");
	}
	
	public void displayReptileMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (ReptileType r : ReptileType.values()){
			sb.append(r.getUID()).append(" ");
			sb.append(r.getName().toUpperCase()).append("\n");
		}
		sb.append("0 ");
		sb.append(local.getString("message.menu.exit"));
		OUTPUT.println(sb.toString());
		OUTPUT.print("> ");
	}
	public void displayAccessoryMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (AccessoryType a : AccessoryType.values()){
			sb.append(a.getUID()).append(" ");
			sb.append(a.getName().toUpperCase()).append("\n");
		}
		sb.append("0 ");
		sb.append(local.getString("message.menu.exit"));
		OUTPUT.println(sb.toString());
		OUTPUT.print("> ");
	}
	
	public void displayEquipMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("\n1 ");
		sb.append(local.getString("message.menu.selectFish")).append("\n"); 
		sb.append("2 ");
		sb.append(local.getString("message.menu.selectReptile")).append("\n");
		sb.append("3 ");
		sb.append(local.getString("message.menu.selectAccessory")).append("\n");
		sb.append("4 ");
		sb.append(local.getString("message.menu.generateReport")).append("\n");
		sb.append("0 ");
		sb.append(local.getString("message.menu.exit"));
		OUTPUT.println(sb.toString());
		OUTPUT.print("> ");
	}
			
	/**
	 * buyTheItem -	create tank and 
	 * add items to tank with corresponded factory method
	 * @param item
	 * @return
	 */
	public State buyTheItem(ItemType item){
		if(item != null) {
			if (item instanceof FishType){
				tank.addAnimal(ff.createAnimal((FishType)item));
			}else if(item instanceof ReptileType){
				tank.addAnimal(rf.createAnimal((ReptileType)item));
			} else if (item instanceof AccessoryType){
				tank.addAccessory(am.createAccessory((AccessoryType)item));
			} else if (item instanceof TankType){
				tank = tm.createTank((TankType)item);
			}
		} else {
			OUTPUT.println("Wrong Choice - no such item");
			if (item instanceof TankType){
				return state = State.INIT_TANK;
			}
		}
		state = State.EQUIP_AND_POPULATE;
		return state;
	}
	/**
	 * generateReport - tank and accessory total with description
	 * @return
	 */
	public State generateRepor(){
		NumberFormat formatter = new DecimalFormat("#0.00");
		StringBuilder sb = new StringBuilder();
		sb.append(tank.toString());
		sb.append("TOTAL: $").append(formatter.format(tm.calculateTotalSum(tank)));
		OUTPUT.println(sb.toString());
		return state;
	}
	
	/**
	 * scroll 50 lines, imitation of clean() 
	 */
	public void clean(){
		for(int i = 0; i < 50; i++){
			OUTPUT.println();
		}
	}
}
