package com.basic.projectbook.controller.pay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.frontController.Controller;

public class SelectShopController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ss = request.getSession();
		String id = (String) ss.getAttribute("id");
		
		if(id == null) {
			return "login.do";
		}
		String discount []= request.getParameterValues("cart_discount");	
		String qty [] = request.getParameterValues("cart_qty");
		String img [] = request.getParameterValues("cart_img");
		String title [] = request.getParameterValues("cart_title");
		String isbn [] = request.getParameterValues("cart_isbn");
		String status [] = request.getParameterValues("status");
					
		request.setAttribute("discount", discount);
		request.setAttribute("qty", qty);
		request.setAttribute("img", img);
		request.setAttribute("title", title);
		request.setAttribute("isbn", isbn);
		request.setAttribute("status", status);
		
		for(String i : isbn) {
			
			
		}
		return "pay/selectShop";
	}

}
