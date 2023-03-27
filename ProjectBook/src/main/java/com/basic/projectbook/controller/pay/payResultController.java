package com.basic.projectbook.controller.pay;

import java.io.IOException;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

<<<<<<< HEAD
import com.basic.projectbook.dao.BookStockDAO;
=======
import com.basic.projectbook.dao.BookDAO;
>>>>>>> origin/yangjjhh_dev
import com.basic.projectbook.dao.CartDAO;
import com.basic.projectbook.dao.MemberDAO;
import com.basic.projectbook.dao.OrderlistDAO;
import com.basic.projectbook.dao.SaleDAO;
import com.basic.projectbook.frontController.Controller;
<<<<<<< HEAD
import com.basic.projectbook.vo.BookStockVO;
=======
import com.basic.projectbook.vo.BookVO;
>>>>>>> origin/yangjjhh_dev
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
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일");
 
        Date now = new Date();
 
        String nowTime1 = sdf1.format(now);
        String nowTime2 = sdf2.format(now);
 
        System.out.println(nowTime1);
        System.out.println(nowTime2);
		
		for(int i =0; i<isbn.length; i++) {
		orderVo.setNo(orderMax);
		orderVo.setReceive(-1); // 배송 -1 
		orderVo.setId(id);
		orderVo.setIsbn(isbn[i]);
		orderVo.setCqty(Integer.parseInt(cqty[i]));
		BookVO bvo=BookDAO.getInstance().getBookInfo(isbn[i]);
		orderVo.setTitle(bvo.getTitle());
		orderVo.setDiscount(Integer.parseInt(bvo.getDiscount())*orderVo.getCqty());
		String image=bvo.getImage();
		orderVo.setImage(image);
		orderVo.setOrderdate(nowTime2);
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
		
		// bookstock 삭제( 직접 수령 시 )
		System.out.println(request.getParameter("storeid"));
		if(request.getParameter("storeid") != null) {
			for(int i=0; i<isbn.length; i++) {
				BookStockVO bookstockvo = new BookStockVO();
				bookstockvo.setIsbn(isbn[i]);
				bookstockvo.setQty(Integer.parseInt(cqty[i]));
				bookstockvo.setStoreid(Integer.parseInt(request.getParameter("storeid")));
				BookStockDAO.getInstance().bookStockChangeStore(bookstockvo);
			}
		}
		
		return "pay/payResult";
	}

}
