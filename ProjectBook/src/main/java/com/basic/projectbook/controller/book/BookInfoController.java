package com.basic.projectbook.controller.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookVO;

public class BookInfoController	implements Controller {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookno=Integer.parseInt(request.getParameter("bookno"));
		List<BookVO>list=BookDAO.getInstance().getAllBook();
		System.out.println("bookno:"+bookno);
		int mileage=0;
		int discPrice=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getNo()==bookno) {
				request.setAttribute("BookVO", list.get(i));
				mileage=list.get(i).getDiscount()/10;
				request.setAttribute("mileage", mileage);
				
				break;
			}
			
		}
		return "book/bookInfo";
		
		
	}

}
