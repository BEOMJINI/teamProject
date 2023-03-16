package com.basic.projectbook.controller.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookVO;

public class BookListController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// header 에서 베스트셀러 눌렀을 때
		boolean best = Boolean.parseBoolean(request.getParameter("best"));
		List<BookVO>list=BookDAO.getInstance().getAllBook();
		request.setAttribute("list", list);
		
		if(best == true) {
			best = false;
			
			
			return "book/bookListBest";
		}
		
		
		System.out.println("listsize:"+list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getName());
		}
		
		
		
		return "book/bookListAll";
	}

}
