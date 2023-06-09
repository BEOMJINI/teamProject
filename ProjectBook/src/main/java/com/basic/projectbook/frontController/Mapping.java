package com.basic.projectbook.frontController;

import java.util.HashMap;
import java.util.Map;



import com.basic.projectbook.controller.book.BookInfoController;
import com.basic.projectbook.controller.book.BookListController;
import com.basic.projectbook.controller.book.DummyController;
import com.basic.projectbook.controller.book.DummyProController;
import com.basic.projectbook.controller.bookstock.AddBookStockController;
import com.basic.projectbook.controller.bookstock.AddBookStockProController;
import com.basic.projectbook.controller.applyrestock.ApplyRestockController;
import com.basic.projectbook.controller.applyrestock.ApplyRestockListController;
import com.basic.projectbook.controller.applyrestock.ApplyRestockProController;
import com.basic.projectbook.controller.bookstock.BookStockChangeController;
import com.basic.projectbook.controller.bookstock.BookStockManageController;
import com.basic.projectbook.controller.cart.CartAddController;
import com.basic.projectbook.controller.cart.CartCountController;
import com.basic.projectbook.controller.cart.CartDeleteAllController;
import com.basic.projectbook.controller.cart.CartDeleteController;
import com.basic.projectbook.controller.cart.CartListController;
import com.basic.projectbook.controller.cart.CartUpdateController;
import com.basic.projectbook.controller.event.EventMainController;
import com.basic.projectbook.controller.member.JoinController;
import com.basic.projectbook.controller.member.LogInController;
import com.basic.projectbook.controller.member.LogOutController;
import com.basic.projectbook.controller.member.MemberDeleteController;
import com.basic.projectbook.controller.member.MemberInfoController;
import com.basic.projectbook.controller.member.MemberListController;
import com.basic.projectbook.controller.member.MemberUpdateController;
import com.basic.projectbook.controller.orderlist.ShowMyOrderController;
import com.basic.projectbook.controller.pay.PayMainController;
import com.basic.projectbook.controller.pay.PickupMainController;
import com.basic.projectbook.controller.pay.SelectShopController;
import com.basic.projectbook.controller.pay.StockCheckController;
import com.basic.projectbook.controller.pay.payResultController;
import com.basic.projectbook.controller.review.ShowMyReviewController;
import com.basic.projectbook.controller.review.ShowMyReviewProController;
import com.basic.projectbook.controller.review.ShowReviewController;
import com.basic.projectbook.controller.review.ShowReviewInfoController;
import com.basic.projectbook.controller.review.WriteReviewController;
import com.basic.projectbook.controller.review.WriteReviewProController;
import com.basic.projectbook.controller.shop.ShopMainController;
import com.basic.projectbook.controller.store.StoreInfoController;
import com.basic.projectbook.controller.store.StoreMapController;
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
		mapping.put("/memberInfo.do", new MemberInfoController());
		
		// book controller
		mapping.put("/bookList.do", new BookListController());
		mapping.put("/bookinfo.do", new BookInfoController());
		
		
		
		
		
		// bookstock controller
		mapping.put("/bookStockManage.do", new BookStockManageController());
		mapping.put("/bookStockChange.do", new BookStockChangeController());
		mapping.put("/addBookStock.do", new AddBookStockController());
		mapping.put("/addBookStockPro.do", new AddBookStockProController());
		
		// applyrestock controller
		mapping.put("/applyRestock.do", new ApplyRestockController());
		mapping.put("/applyRestockPro.do", new ApplyRestockProController() );
		mapping.put("/applyRestockList.do", new ApplyRestockListController());
		
		// store controller
		mapping.put("/storeInfo.do", new StoreInfoController());
		mapping.put("/storeMap.do", new StoreMapController());
		
		// cart controller
		mapping.put("/cartList.do", new CartListController());
		mapping.put("/cartAdd.do", new CartAddController());
		mapping.put("/cartDelete.do", new CartDeleteController());
		mapping.put("/cartDeleteAll.do", new CartDeleteAllController());
		mapping.put("/cartCount.do", new CartCountController());
		mapping.put("/cartUpdate.do", new CartUpdateController());
		
		// pay controller
		mapping.put("/payMain.do", new PayMainController());
		mapping.put("/payResult.do", new payResultController());
		mapping.put("/selectShop.do", new SelectShopController());
		mapping.put("/stockCheck.do", new StockCheckController());
		mapping.put("/pickupMain.do", new PickupMainController());
		
		// shop controller
		mapping.put("/shopMain.do", new ShopMainController());
		//orderlist controller
		mapping.put("/showMyOrder.do", new ShowMyOrderController());
		
		// event controller
		mapping.put("/eventMain.do", new EventMainController());
		//dummy
		mapping.put("/dummy.do", new DummyController());
		mapping.put("/dummyPro.do", new DummyProController());
		//review
		mapping.put("/writeReview.do", new WriteReviewController());
		mapping.put("/showMyReview.do", new ShowMyReviewController());
		mapping.put("/writeReviewPro.do", new WriteReviewProController());
		mapping.put("/showMyReviewPro.do", new ShowMyReviewProController());
		mapping.put("/showReview.do", new ShowReviewController());
		mapping.put("/showReviewInfo.do", new ShowReviewInfoController());
		
	}
	
	public Controller getController(String key) {
		return mapping.get(key);
	}
}
