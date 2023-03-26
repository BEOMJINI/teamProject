package com.basic.projectbook.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.ReviewDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.ReviewVO;

public class WriteReviewProController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String isbn=request.getParameter("isbn");
		String id=(String)session.getAttribute("id");
		String title=request.getParameter("title");
		String comment=request.getParameter("comment");
		int rating=Integer.parseInt(request.getParameter("rating"));
		System.out.println("아이에스비엔:"+isbn);
		ReviewVO vo=new ReviewVO();
		vo.setComment(comment);
		vo.setId(id);
		vo.setTitle(title);
		vo.setIsbn(isbn);
		vo.setrating(rating);
		ReviewDAO.getInstance().insertReview(vo);
		return "main.do";
	}




}
