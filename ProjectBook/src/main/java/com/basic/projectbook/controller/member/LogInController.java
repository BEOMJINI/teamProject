package com.basic.projectbook.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.MemberDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.MemberVO;

public class LogInController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		
		String id = request.getParameter("id");
		if(id == null) {
			return "member/login";
		}
		String pw = request.getParameter("pw");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		
		String x = MemberDAO.getInstance().memberLogin(vo);
		System.out.println("x = " + x);
		
		HttpSession session = request.getSession();
		if(x != null) {
			session.setAttribute("id", x);
			
			
		}
		response.getWriter().print(x);
		
		return null;
	}

}
