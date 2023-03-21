package com.basic.projectbook.controller.bookstock;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.BookStockDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookStockVO;

public class ApplyRestockController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BookStockVO>stockZeroList=BookStockDAO.getInstance().getAllZeroStock();
		return "book/applyRestock";
	}

}
