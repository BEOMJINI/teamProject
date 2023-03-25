package com.basic.projectbook.controller.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.OrderListDAO;
import com.basic.projectbook.dao.ReviewDAO;
import com.basic.projectbook.frontController.Controller;

public class DummyProController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("dummy").equals("order")) {OrderListDAO.getInstance().addOrderDummy();}
		else {
			ReviewDAO.getInstance().addReviewDummy();
		}
		return "main.do";
	}

}
