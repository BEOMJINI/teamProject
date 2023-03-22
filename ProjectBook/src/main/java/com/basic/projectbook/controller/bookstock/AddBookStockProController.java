package com.basic.projectbook.controller.bookstock;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.ApplyRestockDAO;
import com.basic.projectbook.dao.BookStockDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookStockVO;

public class AddBookStockProController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int storeid=Integer.parseInt(request.getParameter("storeid"));
		int qty=Integer.parseInt(request.getParameter("qty"));
		String isbn=request.getParameter("isbn");
		if(qty<=0) {
			response.getWriter().println(-1);
			return null;
		}
		BookStockVO vo=new BookStockVO();
		vo.setIsbn(isbn);
		vo.setQty(qty);
		vo.setStoreid(storeid);
		BookStockDAO.getInstance().addBookStock(vo);
		ApplyRestockDAO.getInstance().deleteOneApply(vo);
		return null;
	}

}
