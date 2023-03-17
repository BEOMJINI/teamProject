package com.basic.projectbook.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookVO;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class saveAPI implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookJson = request.getParameter("bookJson"); // jsonString 타입
		BookVO vo = new BookVO();
		try {
		JsonParser jp = new JSONParser(); // json 데이터 객체로 해석해주는 클래스 객체 
		JsonObject jb = (JSONObject) jp.parse(bookJson); // // json 객체 타입
		// {id:"test7",passwd:"1234", name:"테스트7", address:"사당", tel:"010-111-1234"};
		
		System.out.println(jb);
		
		/*
		vo.setId((String)jb.get("id"));
		vo.setPasswd((String)jb.get("passwd"));
		vo.setName((String)jb.get("name"));
		vo.setAddress((String)jb.get("address"));
		vo.setTel((String)jb.get("tel"));
		
		int check = MemberDAO.getInstance().insertMember(vo);
		response.getWriter().print(check);
		*/
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
