package com.basic.projectbook.frontController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.MemberDAO;
import com.basic.projectbook.vo.MemberVO;

public class MainController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MemberVO> list = MemberDAO.getInstance().getAllMember();
		System.out.println(list);
		request.setAttribute("list", list);
		
		MemberVO vo = MemberDAO.getInstance().getOneMember("1");
		request.setAttribute("test", vo);
		
		
		return "main";
		
		
		
	}

}
