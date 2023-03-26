package com.basic.projectbook.controller.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.dao.ReviewDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookVO;
import com.basic.projectbook.vo.ReviewVO;

public class ShowReviewController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn=request.getParameter("isbn");
		BookVO vo=BookDAO.getInstance().getBookInfo(isbn);
		String title=vo.getTitle();
		List<ReviewVO>list=ReviewDAO.getInstance().getBookReview(isbn);
		request.setAttribute("list", list);
		request.setAttribute("title", title);
		return "review/showReview";
	}

}
