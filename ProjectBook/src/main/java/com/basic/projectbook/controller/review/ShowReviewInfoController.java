package com.basic.projectbook.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.ReviewDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.ReviewVO;

public class ShowReviewInfoController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("no"));
		ReviewVO vo=ReviewDAO.getInstance().getOneReview(no);
		request.setAttribute("vo", vo);
		return "review/showReviewInfo";
	}

}
