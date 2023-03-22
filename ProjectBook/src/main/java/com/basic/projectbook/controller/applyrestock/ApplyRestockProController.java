package com.basic.projectbook.controller.applyrestock;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.ApplyRestockDAO;
import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.dao.BookStockDAO;
import com.basic.projectbook.dao.StoreDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.ApplyRestockVO;
import com.basic.projectbook.vo.BookVO;
import com.basic.projectbook.vo.StoreVO;

public class ApplyRestockProController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn =request.getParameter("isbn");
		int storeid=Integer.parseInt(request.getParameter("storeid"));
		BookVO bvo=BookDAO.getInstance().getBookInfo(isbn);
		StoreVO svo=StoreDAO.getInstance().getStoreInfo(storeid);
		String title=bvo.getTitle();
		String author=bvo.getAuthor();
		String publisher=bvo.getPublisher();
		String storename=svo.getStorename();
		List<ApplyRestockVO>list=ApplyRestockDAO.getInstance().getAllList();
		if(list.size()!=0) {
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getIsbn().equals(isbn)&&list.get(i).getStoreid()==storeid) {
					response.getWriter().print(-1);
					return null;
				}
			}
		}
		ApplyRestockVO vo=new ApplyRestockVO();
		vo.setTitle(title);
		vo.setIsbn(isbn);
		vo.setAuthor(author);
		vo.setPublisher(publisher);
		vo.setStorename(storename);
		vo.setStoreid(storeid);
		ApplyRestockDAO.getInstance().addApplyRestock(vo);
		response.getWriter().print(1);
		
		return null;
	}

}
