package com.basic.projectbook.controller.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookVO;

public class BookCategoryController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String keyword=request.getParameter("keyword");
			System.out.println("keyword:"+keyword);
			System.out.println("category:"+request.getParameter("category"));
			List<BookVO>list=new ArrayList<BookVO>();
		if(request.getParameter("category").equals("genre")) {
			list=BookDAO.getInstance().getGenreBook(keyword);
		}
		else if(request.getParameter("category").equals("country")) {
			list=BookDAO.getInstance().getCountryBook(keyword);
		}
		else if(request.getParameter("category").equals("publisher")) {
			list=BookDAO.getInstance().getPublisherBook(keyword);
		}
		for(int i=0;i<list.size();i++) {
			System.out.println("책이름:"+list.get(i).getTitle());
		}
		request.setAttribute("list", list);
		//System.out.println("listsize:"+list.size());
		response.getWriter().print(list.size());
		return null;
	}

}
