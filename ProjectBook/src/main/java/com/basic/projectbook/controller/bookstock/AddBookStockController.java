package com.basic.projectbook.controller.bookstock;

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

public class AddBookStockController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn=request.getParameter("isbn");
		List<StoreVO>storeList=StoreDAO.getInstance().getAllStore();
		for(int i=0;i<storeList.size();i++) {
			System.out.println(storeList.get(i).getStoreid());
			System.out.println(storeList.get(i).getStorename());
		}
		List<BookStockVO>bookStockList=BookStockDAO.getInstance().getBookStock(isbn);
		BookVO bookVO=BookDAO.getInstance().getBookInfo(isbn);
		request.setAttribute("storeList",storeList );
		request.setAttribute("bookStockList", bookStockList);
		request.setAttribute("bookVO", bookVO);
		return "bookstock/addBookStock";
	}

}
