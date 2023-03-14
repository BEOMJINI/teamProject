package com.basic.projectbook.frontController;

import java.util.HashMap;
import java.util.Map;

public class Mapping {
	private Map<String,	Controller> mapping;
	
	public Mapping() {
		mapping = new HashMap<>();
		
		mapping.put("/main.do", new MainController());
	}
	
	public Controller getController(String key) {
		return mapping.get(key);
	}
}
