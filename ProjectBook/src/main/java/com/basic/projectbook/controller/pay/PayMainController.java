package com.basic.projectbook.controller.pay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.frontController.Controller;

public class PayMainController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String price []= request.getParameterValues("check");	
		String qty [] = request.getParameterValues("cart_qty");
		String ck [] = request.getParameterValues("cart_check");
		String img [] = request.getParameterValues("cart_img");
		String title [] = request.getParameterValues("cart_title");
		String isbn [] = request.getParameterValues("cart_isbn");
		
		if(price == null) {
			return "cartList.do";
		}
		
		request.setAttribute("price", price);
		request.setAttribute("qty", qty);
		request.setAttribute("ck", ck);
		request.setAttribute("img", img);
		request.setAttribute("title", title);
		request.setAttribute("isbn", isbn);
		
		return "pay/payMain";
	}
		
}
