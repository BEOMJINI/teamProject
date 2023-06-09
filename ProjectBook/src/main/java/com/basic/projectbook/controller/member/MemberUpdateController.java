package com.basic.projectbook.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.MemberDAO;
import com.basic.projectbook.dao.OrderlistDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.MemberVO;

public class MemberUpdateController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession ss = request.getSession();
		String mId = (String) ss.getAttribute("id");
		
		MemberVO vo = MemberDAO.getInstance().getOneMember(mId);
		
		request.setAttribute("vo", vo);
		
		if(Boolean.parseBoolean(request.getParameter("update"))) {
			
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
		
			vo.setPw(pw);
			vo.setName(name);
			vo.setEmail(email);
			vo.setPhone(phone);
			vo.setAddress(address);
			
			MemberDAO.getInstance().memberUpdate(vo);
			
			request.setAttribute("updateMsg", "수정이 완료 되었습니다.");
		}
		if(Boolean.parseBoolean(request.getParameter("delete"))) {
			OrderlistDAO.getInstance().memberDelete(mId);
			MemberDAO.getInstance().memberDelete(mId);
			ss.removeAttribute("id");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('회원탈퇴완료'); location.href='main.do';</script>"); 
			writer.close();
		}
		
		
		return "member/update";
	}

}
