package com.basic.projectbook.controller.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.dao.BookStockDAO;
import com.basic.projectbook.dao.StoreDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookStockVO;
import com.basic.projectbook.vo.BookVO;
import com.basic.projectbook.vo.StoreVO;


public class BookStockChangeController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("여기들어옴");
		if(request.getParameter("submit").equals("add")) {
		BookStockDAO.getInstance().bookStockDummy();}
		else if(request.getParameter("submit").equals("delete")) {
		BookStockDAO.getInstance().deleteAllBookStock();
		}
		List<BookVO>list=BookDAO.getInstance().getAllBook();
		List<StoreVO>storeList=StoreDAO.getInstance().getAllStore();
		List<BookStockVO>bookStockList=BookStockDAO.getInstance().getAllBookStock();
		request.setAttribute("list", list);
		request.setAttribute("storeList", storeList);
		request.setAttribute("bookStockList", bookStockList);
		return "book/bookStockManage";
	}

}
