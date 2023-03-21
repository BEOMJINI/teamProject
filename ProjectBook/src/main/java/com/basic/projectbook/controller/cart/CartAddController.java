package com.basic.projectbook.controller.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.CartDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.CartVO;

public class CartAddController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession ss = request.getSession();
		String id = (String) ss.getAttribute("id");
		
		if(id == null) {
			return "login.do";
		}
		
		String isbn = request.getParameter("isbn");
		String cqty = request.getParameter("cqty");
		
		System.out.println(id + " " + isbn+ " "+ cqty);
		
		CartVO vo = new CartVO();
		vo.setIsbn(isbn);
		vo.setCqty(Integer.parseInt(cqty));
		vo.setId(id);
				
		
		
		int x = CartDAO.getInstance().validIsbn(vo);
		System.out.println("x ==== "+ x);
		if(x == 0) {
			CartDAO.getInstance().cartAdd(vo);
		} 
		
		response.getWriter().print(x);
		
		
		return null;
	}

}
