package com.basic.projectbook.frontController;

import java.util.HashMap;
import java.util.Map;

import com.basic.projectbook.controller.book.BookListController;
import com.basic.projectbook.controller.shop.ShopMainController;

public class Mapping {
	private Map<String,	Controller> mapping;
	
	public Mapping() {
		mapping = new HashMap<>();
		
		mapping.put("/main.do", new MainController());
		
		// member controller
		
		// book controller
		mapping.put("/bookList.do", new BookListController());
		
		// shop controller
		mapping.put("/shopMain.do", new ShopMainController());
		
	}
	
	public Controller getController(String key) {
		return mapping.get(key);
	}
}
