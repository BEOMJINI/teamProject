package com.basic.projectbook.controller.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.dao.OrderlistDAO;
import com.basic.projectbook.dao.ReviewDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookVO;
import com.basic.projectbook.vo.GetMyReviewBean;
import com.basic.projectbook.vo.OrderlistVO;
import com.basic.projectbook.vo.ReviewVO;
import com.mysql.cj.Session;

public class ShowMyReviewController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		String isbn=request.getParameter("isbn");
		GetMyReviewBean bean=new GetMyReviewBean();
		bean.setId(id);
		bean.setIsbn(isbn);
		ReviewVO vo=ReviewDAO.getInstance().getMyReview(bean);
		BookVO bvo=BookDAO.getInstance().getBookInfo(isbn);
		String title=bvo.getTitle();
		request.setAttribute("title", title);
		request.setAttribute("vo", vo);
		
		return "review/showMyReview";
	}

}
