package com.basic.projectbook.controller.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.CartDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.CartVO;

public class CartDeleteController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if(id == null) {
			return "login.do";
		}
		String isbn = request.getParameter("isbn");
		
		CartVO vo = new CartVO();
		vo.setId(id);
		vo.setIsbn(isbn);
				
		int x = CartDAO.getInstance().cartDelete(vo);
		response.getWriter().print(x);
		return null;
	}

}
