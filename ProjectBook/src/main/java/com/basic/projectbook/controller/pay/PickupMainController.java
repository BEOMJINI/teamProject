package com.basic.projectbook.controller.pay;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.MemberDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.MemberVO;
import com.basic.projectbook.vo.OrderBean;

public class PickupMainController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession ss = request.getSession();
		String id = (String) ss.getAttribute("id");
		
		if(id == null) {
			return "login.do";
		}
		
		MemberVO vo = MemberDAO.getInstance().getOneMember(id);
		request.setAttribute("vo",vo);
		
		String discount []= request.getParameterValues("cart_discount");	
		String qty [] = request.getParameterValues("cart_qty");
		String img [] = request.getParameterValues("cart_img");
		String title [] = request.getParameterValues("cart_title");
		String isbn [] = request.getParameterValues("cart_isbn");
		String status = request.getParameter("status");
		String formlist [] = request.getParameterValues("formlist");
		
		String gettest [] = request.getParameterValues("gettest");
		for(String s : gettest) {
			System.out.println("S = " + s);
		}
		
		
		System.out.println(formlist);
		
		for(int i=0; i<formlist.length; i++) {
			System.out.println(formlist[i]);
			
		}
		
		for(String s : isbn) {
			System.out.println(s);
		}
		for(int i=0; i<qty.length; i++) {
			System.out.println(qty[0]);
			
			System.out.println(discount[0]);
			System.out.println(isbn[1]);
			System.out.println(isbn[1]);
			
		}
		
		
		
		
		
		request.setAttribute("discount", discount);
		request.setAttribute("qty", qty);
		request.setAttribute("img", img);
		request.setAttribute("title", title);
		request.setAttribute("isbn", isbn);
		request.setAttribute("status", status);
		
		return "pay/pickupMain";
	}

}
