package com.basic.projectbook.controller.orderlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

<<<<<<< HEAD
//import com.basic.projectbook.dao.OrderListDAO;
import com.basic.projectbook.dao.ReviewDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.MyOrderViewBean;
//import com.basic.projectbook.vo.OrderListVO;
=======

import com.basic.projectbook.dao.OrderlistDAO;
import com.basic.projectbook.dao.ReviewDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.MyOrderViewBean;

>>>>>>> origin/yyjjhh_Dev
import com.basic.projectbook.vo.ReviewCheckBean;


public class ShowMyOrderController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
//		HttpSession session=request.getSession();
//		String id=(String)session.getAttribute("id");
//		List<MyOrderViewBean>list=OrderListDAO.getInstance().getMyOrder(id);
//		List<ReviewCheckBean> list1=OrderListDAO.getInstance().getReviewCheck(id);
//		System.out.println(list.size()+""+list1.size());
//		for(int i=0;i<list.size();i++) {
//			list.get(i).setReviewCheck(list1.get(i).isWritten());
//		}
//		
//		request.setAttribute("list", list);
//	
//		
//		
//		
=======
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		List<MyOrderViewBean>list=OrderlistDAO.getInstance().getMyOrder(id);
		List<ReviewCheckBean> list1=OrderlistDAO.getInstance().getReviewCheck(id);
		System.out.println(list.size()+""+list1.size());
		for(int i=0;i<list.size();i++) {
			list.get(i).setReviewCheck(list1.get(i).isWritten());
		}
		
		request.setAttribute("list", list);
	
		
		
		
>>>>>>> origin/yyjjhh_Dev
		return "orderlist/showMyOrder";
	}

}
