package com.basic.projectbook.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.ReviewDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.UpdateMyReviewBean;

public class ShowMyReviewProController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String submit=request.getParameter("submit");
		System.out.println();
		int no=Integer.parseInt(request.getParameter("no"));
		String title=request.getParameter("title");
		String comment=request.getParameter("comment");
		int rating=Integer.parseInt(request.getParameter("rating"));
		if(submit.equals("수정하기")) {
			UpdateMyReviewBean bean=new UpdateMyReviewBean();
			bean.setNo(no);
			bean.setTitle(title);
			bean.setComment(comment);
			bean.setRating(rating);
			ReviewDAO.getInstance().updateMyReview(bean);
		}
		else {
			ReviewDAO.getInstance().deleteMyReview(no);
			
		}
		return "showMyOrder.do";
	}

}
