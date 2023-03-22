package com.basic.projectbook.controller.cart;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.CartDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.CartListViewBean;


public class CartListController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession ss = request.getSession();
		String id = (String) ss.getAttribute("id");
		
		if(id == null) {
			return "login.do";
		}
		
		List<CartListViewBean> list = CartDAO.getInstance().getOneCartList(id);
		request.setAttribute("list", list);
		//System.out.println("list=" + list);
		
		DecimalFormat df = new DecimalFormat("###,###,### 원");
		ArrayList<String> moneyData = new ArrayList<>();
		
		for(CartListViewBean b : list) {
			moneyData.add(df.format(Integer.parseInt(b.getDiscount())));
			
		}
		request.setAttribute("moneyData", moneyData);
		
		return "cart/cartMain";
	}

}
