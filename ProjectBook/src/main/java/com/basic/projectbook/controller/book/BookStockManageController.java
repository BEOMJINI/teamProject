package com.basic.projectbook.controller.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookVO;

public class BookStockManageController	implements Controller {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<BookVO>list=BookDAO.getInstance().getAllBook();
		request.setAttribute("list", list);
		
		return "book/bookStockManage";
	}

}
