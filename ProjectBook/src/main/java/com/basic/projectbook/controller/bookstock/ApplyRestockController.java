package com.basic.projectbook.controller.bookstock;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.BookStockDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookStockVO;
import com.basic.projectbook.vo.BookStockZeroBean;

public class ApplyRestockController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BookStockZeroBean>list=BookStockDAO.getInstance().getAllZeroStock();
		request.setAttribute("list", list);
		
		return "book/applyRestock";
	}

}
