package com.basic.projectbook.controller.pay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.OrderBean;

public class StockCheckController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String store = request.getParameter("store");
		
		String discount []= request.getParameterValues("discount");	
		String qty [] = request.getParameterValues("qty");
		String img [] = request.getParameterValues("img");
		String title [] = request.getParameterValues("title");
		String isbn [] = request.getParameterValues("isbn");
		String status [] = request.getParameterValues("status");
		
		System.out.println(discount.length);
		
		List<OrderBean> orderbeanlist = new ArrayList<>();
		OrderBean orderbean = new OrderBean();
		for(int i=0; i<discount.length; i++) {
			orderbean.setDiscount(discount[i]);
			orderbean.setQty(qty[i]);
			orderbean.setImg(img[i]);
			orderbean.setTitle(title[i]);
			orderbean.setIsbn(isbn[i]);
			orderbean.setStatus(status[i]);
			orderbeanlist.add(orderbean);
		}
		System.out.println("dfdfddd= " + orderbeanlist);
		
		response.getWriter().print(store);
		
		return null;
	}

}
