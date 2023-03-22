package com.basic.projectbook.controller.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.CartDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.CartVO;

public class CartUpdateController implements Controller{

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
		String cqty = request.getParameter("cqty");
		
		CartVO vo = new CartVO();
		vo.setId(id);
		vo.setIsbn(isbn);
		vo.setCqty(Integer.parseInt(cqty));
		
		int x = CartDAO.getInstance().cartUpdate(vo);
		response.getWriter().print(x);
		return null;
	}

}
