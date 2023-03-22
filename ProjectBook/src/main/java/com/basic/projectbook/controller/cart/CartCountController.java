package com.basic.projectbook.controller.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.CartDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.CartListViewBean;

public class CartCountController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		List<CartListViewBean> list = CartDAO.getInstance().getOneCartList(request.getParameter("idid"));
		int cartCount = 0;
		for(CartListViewBean b : list) {
			cartCount += b.getCqty();
		}
		response.getWriter().print(cartCount);
		return null;
	}

}
