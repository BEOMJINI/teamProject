package com.basic.projectbook.controller.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.frontController.Controller;

public class BookListController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// header 에서 베스트셀러 눌렀을 때
		boolean best = Boolean.parseBoolean(request.getParameter("best"));
		if(best == true) {
			best = false;
			
			
			return "book/bookListBest";
		}
		
		
		
		
		
		
		return "book/bookListAll";
	}

}
