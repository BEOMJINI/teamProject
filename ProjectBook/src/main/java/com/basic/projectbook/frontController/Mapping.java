package com.basic.projectbook.frontController;

import java.util.HashMap;
import java.util.Map;

import com.basic.projectbook.controller.book.BookCategoryController;
import com.basic.projectbook.controller.book.BookInfoController;
import com.basic.projectbook.controller.book.BookListController;
import com.basic.projectbook.controller.book.BookStockManageController;
import com.basic.projectbook.controller.event.EventMainController;
import com.basic.projectbook.controller.member.JoinController;
import com.basic.projectbook.controller.member.LogInController;
import com.basic.projectbook.controller.member.LogOutController;
import com.basic.projectbook.controller.member.MemberDeleteController;
import com.basic.projectbook.controller.member.MemberListController;
import com.basic.projectbook.controller.member.MemberUpdateController;
import com.basic.projectbook.controller.shop.ShopMainController;
import com.basic.projectbook.util.SearchAPI;
import com.basic.projectbook.util.saveAPI;

public class Mapping {
	private Map<String,	Controller> mapping;
	
	public Mapping() {
		mapping = new HashMap<>();
		
		mapping.put("/main.do", new MainController());
		mapping.put("/api.do", new ApiController());
		mapping.put("/searchBook.do", new SearchAPI());
		mapping.put("/saveBook.do", new saveAPI());
		
		// member controller
		mapping.put("/login.do", new LogInController());
		mapping.put("/logout.do", new LogOutController());
		mapping.put("/join.do", new JoinController());
		mapping.put("/memberUpdate.do", new MemberUpdateController());
		mapping.put("/memberList.do", new MemberListController());
		mapping.put("/memberDelete.do", new MemberDeleteController());
		
		// book controller
		mapping.put("/bookList.do", new BookListController());
		mapping.put("/bookinfo.do", new BookInfoController());
		mapping.put("/bookCategory.do", new BookCategoryController());
		mapping.put("/bookStockManage.do", new BookStockManageController());
		
		// shop controller
		mapping.put("/shopMain.do", new ShopMainController());
		
		// event controller
		mapping.put("/eventMain.do", new EventMainController());
	}
	
	public Controller getController(String key) {
		return mapping.get(key);
	}
}
