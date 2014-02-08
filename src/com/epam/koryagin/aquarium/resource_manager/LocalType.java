package com.epam.koryagin.aquarium.resource_manager;

import java.util.HashMap;
import java.util.Map;


public enum LocalType {
	EN(0, "com.epam.koryagin.aquarium.resources.messageEnUS"),
	CYR(1, "com.epam.koryagin.aquarium.resources.messageCyr");
	
	
	private int code;
	private String baseName;
	private static Map<Integer, LocalType> codeToLocalTypeMapping;
	
	private LocalType(int code, String baseName) {
		this.code = code;
		this.setBaseName(baseName);
	}
	
	public static LocalType select(int i) {
        if (codeToLocalTypeMapping == null) {
            initMapping();
        }
        return codeToLocalTypeMapping.get(i);
    }
	
	private static void initMapping() {
		codeToLocalTypeMapping = new HashMap<Integer, LocalType>();
        for (LocalType local : values()) {
        	codeToLocalTypeMapping.put(local.code, local);
        }
    }

	public String getBaseName() {
		return baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

}
