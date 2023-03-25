package com.basic.projectbook.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.MemberDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.MemberVO;

public class JoinController implements Controller {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 회원가입 눌렀을 때
		if (request.getParameter("id") == null) {
			return "member/join";
		}

		// 회원가입 정보 입력 완료
		String id = request.getParameter("id");
		
		int z = MemberDAO.getInstance().validId(id);
		if(z != 0) {
			request.setAttribute("idMsg", "이미 사용중인 아이디 입니다.");
			return "member/join";
		}
		
		
		
		
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		String[] test = request.getParameterValues("interest");

		MemberVO vo = new MemberVO();

		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		vo.setPhone(request.getParameter("phone"));
		vo.setAddress(request.getParameter("address"));
		
		String data = null;
		if (test != null) {
			for (String s : test) {
				data += s + "/";
			}
			System.out.println(data.substring(4));
			vo.setInterest(data.substring(4));
		}
		System.out.println(vo.getInterest());
		
		MemberDAO.getInstance().memberJoin(vo);
				
		return "main";
	}

}
