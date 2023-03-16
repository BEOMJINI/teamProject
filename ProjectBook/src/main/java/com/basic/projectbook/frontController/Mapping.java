package com.basic.projectbook.frontController;

import java.util.HashMap;
import java.util.Map;

import com.basic.projectbook.controller.book.BookListController;
import com.basic.projectbook.controller.event.EventMainController;
import com.basic.projectbook.controller.member.JoinController;
import com.basic.projectbook.controller.member.LogInController;
import com.basic.projectbook.controller.member.LogOutController;
import com.basic.projectbook.controller.member.MemberUpdateController;
import com.basic.projectbook.controller.shop.ShopMainController;

public class Mapping {
	private Map<String,	Controller> mapping;
	
	public Mapping() {
		mapping = new HashMap<>();
		
		mapping.put("/main.do", new MainController());
		
		// member controller
		mapping.put("/login.do", new LogInController());
		mapping.put("/logout.do", new LogOutController());
		mapping.put("/join.do", new JoinController());
		mapping.put("/memberUpdate.do", new MemberUpdateController());
		
		// book controller
		mapping.put("/bookList.do", new BookListController());
		
		// shop controller
		mapping.put("/shopMain.do", new ShopMainController());
		
		// event controller
		mapping.put("/eventMain.do", new EventMainController());
	}
	
	public Controller getController(String key) {
		return mapping.get(key);
	}
}
