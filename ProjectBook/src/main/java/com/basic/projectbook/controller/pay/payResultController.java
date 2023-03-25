package com.basic.projectbook.controller.pay;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.CartDAO;
import com.basic.projectbook.dao.MemberDAO;
import com.basic.projectbook.dao.OrderlistDAO;
import com.basic.projectbook.dao.SaleDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.CartVO;
import com.basic.projectbook.vo.MemberVO;
import com.basic.projectbook.vo.OrderlistVO;
import com.basic.projectbook.vo.SaleVO;

public class payResultController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		String isbn [] = request.getParameterValues("isbn");
		String cqty [] = request.getParameterValues("cqty");
		
		// cart db 삭제
				
		for(String s : isbn) {
			CartVO vo = new CartVO();
			vo.setId(id);
			vo.setIsbn(s);
			
			CartDAO.getInstance().cartDelete(vo);
		}
		
		// member db mileage 적립 및 사용
		MemberVO vo = MemberDAO.getInstance().getOneMember(id);
		int memberMileage = vo.getMileage();
		int saveMileage = Integer.parseInt(request.getParameter("saveMileage"));
		int useMileage = Integer.parseInt(request.getParameter("useMileage"));
		int resultMileage = memberMileage - useMileage + saveMileage;
		vo.setId(id);
		vo.setMileage(resultMileage);
		MemberDAO.getInstance().memberMileageUpdate(vo);
		
		// order db 저장
		OrderlistVO orderVo = new OrderlistVO();
		int orderMax = OrderlistDAO.getInstance().getMaxNo() + 1;
		
		for(int i =0; i<isbn.length; i++) {
		orderVo.setNo(orderMax);
		orderVo.setReceive(-1); // 배송 -1 
		orderVo.setId(id);
		orderVo.setIsbn(isbn[i]);
		orderVo.setCqty(Integer.parseInt(cqty[i]));
		OrderlistDAO.getInstance().orderlistInsert(orderVo);
		}
		
		// sale db 저장
		SaleVO saleVo = new SaleVO();
		int saleMax = SaleDAO.getInstance().getMaxNo() + 1;
		
		for(int i=0; i<isbn.length; i++) {
			saleVo.setNo(saleMax);
			saleVo.setIsbn(isbn[i]);
			saleVo.setQty(Integer.parseInt(cqty[i]));
			SaleDAO.getInstance().saleInsert(saleVo);
		}
		
		// 결제 내역 출력 
		int totalSum = Integer.parseInt(request.getParameter("totalSum"));
		int printDiscount = totalSum - useMileage;
		DecimalFormat df = new DecimalFormat("###,###,### 원");
		String printDiscountData = df.format(printDiscount);
		request.setAttribute("printDiscountData", printDiscountData);
		
		return "pay/payResult";
	}

}
