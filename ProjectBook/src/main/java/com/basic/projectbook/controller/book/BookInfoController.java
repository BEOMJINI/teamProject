package com.basic.projectbook.controller.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.dao.ReviewDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookVO;

public class BookInfoController	implements Controller {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn=request.getParameter("isbn");
		List<BookVO>list=BookDAO.getInstance().getAllBook();
		
		int mileage=0;
	
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getIsbn().equals(isbn)) {
				request.setAttribute("BookVO", list.get(i));
				mileage=Integer.parseInt(list.get(i).getDiscount())/10;
				request.setAttribute("mileage", mileage);
				
				break;
			}
			
		}
		int rating=ReviewDAO.getInstance().getRating(isbn);
		request.setAttribute("rating", rating);
		return "book/bookInfo";
		
		
	}

}
