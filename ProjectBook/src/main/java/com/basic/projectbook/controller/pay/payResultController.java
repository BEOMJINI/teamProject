package com.basic.projectbook.controller.pay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.CartDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.CartVO;

public class payResultController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		String isbn [] = request.getParameterValues("isbn");
				
		for(String s : isbn) {
			CartVO vo = new CartVO();
			vo.setId(id);
			vo.setIsbn(s);
			
			CartDAO.getInstance().cartDelete(vo);
		}
		
		
		return "pay/payResult";
	}

}
