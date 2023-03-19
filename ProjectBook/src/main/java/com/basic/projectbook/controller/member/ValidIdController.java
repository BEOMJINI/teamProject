package com.basic.projectbook.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.MemberDAO;
import com.basic.projectbook.frontController.Controller;

public class ValidIdController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String z = MemberDAO.getInstance().validId(request.getParameter("id"));
		response.getWriter().print(z);
		
		return null;
	}

}
