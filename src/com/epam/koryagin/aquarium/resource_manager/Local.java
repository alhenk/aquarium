package com.epam.koryagin.aquarium.resource_manager;

import java.util.ResourceBundle;

public class Local {
	
	private ResourceBundle resources;
		
	public Local(){
		super();
		this.resources = ResourceBundle.getBundle(LocalType.EN.getBaseName());
	}
	public String getString(String key){
		return this.resources.getString(key);
	}
	public Local(LocalType localType) {
		super();
		this.resources = ResourceBundle.getBundle(localType.getBaseName());
	}
	
	public ResourceBundle getResources() {
		return resources;
	}

	public void setResources(ResourceBundle resources) {
		this.resources = resources;
	}
}
