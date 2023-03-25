package com.basic.projectbook.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.dao.ReviewDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookVO;
import com.basic.projectbook.vo.ReviewVO;
import com.mysql.cj.Session;

public class WriteReviewController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		String isbn=request.getParameter("isbn");
		int no=-1;
		if(ReviewDAO.getInstance().getLastNo()==-1) {
			no=1;
		}
		else {
			no=ReviewDAO.getInstance().getLastNo()+1;
		}
		
		BookVO vo=BookDAO.getInstance().getBookInfo(isbn);
		String title=vo.getTitle();
		request.setAttribute("title", title);
		request.setAttribute("no", no);
		return "review/writeReview";
	}

}
