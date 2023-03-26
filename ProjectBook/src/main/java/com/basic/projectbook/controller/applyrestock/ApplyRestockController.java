package com.basic.projectbook.controller.applyrestock;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.ApplyRestockDAO;
import com.basic.projectbook.dao.BookStockDAO;
import com.basic.projectbook.frontController.Controller;

import com.basic.projectbook.vo.ApplyRestockVO;

public class ApplyRestockController implements Controller {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		if(id == null) {
			return "login.do";
		}
		List<ApplyRestockVO> list = BookStockDAO.getInstance().getAllZeroStock();
		request.setAttribute("list", list);
		
		return "applyrestock/applyRestock";
	}

}
