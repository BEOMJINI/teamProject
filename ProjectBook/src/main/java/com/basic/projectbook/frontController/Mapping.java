package com.basic.projectbook.frontController;

import java.util.HashMap;
import java.util.Map;


import com.basic.projectbook.controller.book.BookCategoryController;
import com.basic.projectbook.controller.book.BookInfoController;
import com.basic.projectbook.controller.book.BookListController;
import com.basic.projectbook.controller.bookstock.AddBookStockController;
import com.basic.projectbook.controller.bookstock.AddBookStockProController;
import com.basic.projectbook.controller.bookstock.ApplyRestockController;
import com.basic.projectbook.controller.bookstock.BookStockChangeController;
import com.basic.projectbook.controller.bookstock.BookStockManageController;
import com.basic.projectbook.controller.cart.CartAddController;
import com.basic.projectbook.controller.cart.CartListController;
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
		mapping.put("/bookStockChange.do", new BookStockChangeController());
		mapping.put("/addBookStock.do", new AddBookStockController());
		mapping.put("/addBookStockPro.do", new AddBookStockProController());
		mapping.put("/applyRestock.do", new ApplyRestockController());
		
		// cart controller
		mapping.put("/cartList.do", new CartListController());
		mapping.put("/cartAdd.do", new CartAddController());
		
		// shop controller
		mapping.put("/shopMain.do", new ShopMainController());
		
		// event controller
		mapping.put("/eventMain.do", new EventMainController());
		
		
	}
	
	public Controller getController(String key) {
		return mapping.get(key);
	}
}
