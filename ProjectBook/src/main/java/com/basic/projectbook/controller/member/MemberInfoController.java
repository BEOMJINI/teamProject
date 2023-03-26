package com.basic.projectbook.controller.member;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.dao.OrderlistDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookVO;
import com.basic.projectbook.vo.OrderlistVO;

public class MemberInfoController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		if(id == null) {
			return "login.do";
		}
		
		// 회원 주문 목록
		List<OrderlistVO> orderlist = OrderlistDAO.getInstance().orderlistMember(id);
		request.setAttribute("orderList", orderlist);
		
		// 일치하는 책 정보
		// 수령 방법 저장
		// 금액 컴마 저장
		List<BookVO> booklist = new ArrayList<>();
		ArrayList<String> receiveNameList = new ArrayList<>();
		ArrayList<String> moneyList = new ArrayList<>();
		
		for(OrderlistVO order : orderlist) {
			BookVO book = new BookVO();
			book = BookDAO.getInstance().getBookInfo(order.getIsbn());
			booklist.add(book);
						
			if(order.getReceive() == -1) {
				receiveNameList.add("배송");
			} else if (order.getReceive() == 0) {
				receiveNameList.add("직접수령 : 강남점(본점)");
			} else if (order.getReceive() == 1) {
				receiveNameList.add("직접수령 : 잠실점");
			} else if (order.getReceive() == 2) {
				receiveNameList.add("직접수령 : 목동점");
			} else if (order.getReceive() == 3) {
				receiveNameList.add("직접수령 : 영등포점");
			}
		}
		DecimalFormat df = new DecimalFormat("###,###,### 원");
		for(int i=0; i<orderlist.size(); i++) {
			int money = (orderlist.get(i).getCqty() * orderlist.get(i).getDiscount());
			moneyList.add(df.format(money));
		}
		request.setAttribute("bookData", booklist);
		request.setAttribute("receiveNameData", receiveNameList);
		request.setAttribute("moneyData", moneyList);
		return "member/myInfo";
	}

}
