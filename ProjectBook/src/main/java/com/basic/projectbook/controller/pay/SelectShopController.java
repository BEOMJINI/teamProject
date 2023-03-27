package com.basic.projectbook.controller.pay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.SystemMetaObject;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.dao.BookStockDAO;
import com.basic.projectbook.dao.StoreDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookStockVO;
import com.basic.projectbook.vo.BookVO;
import com.basic.projectbook.vo.OrderBean;
import com.basic.projectbook.vo.StoreVO;

public class SelectShopController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ss = request.getSession();
		String id = (String) ss.getAttribute("id");
		
		if(id == null) {
			return "login.do";
		}
		String discount []= request.getParameterValues("cart_discount");	
		String qty [] = request.getParameterValues("cart_qty");
		String img [] = request.getParameterValues("cart_img");
		String title [] = request.getParameterValues("cart_title");
		String isbn [] = request.getParameterValues("cart_isbn");
		String status [] = request.getParameterValues("status");
					
		request.setAttribute("discount", discount);
		request.setAttribute("qty", qty);
		request.setAttribute("img", img);
		request.setAttribute("title", title);
		request.setAttribute("isbn", isbn);
		request.setAttribute("status", status);
		
		
		
		
		
		
		//
		List<OrderBean> orderbeanlist = new ArrayList<>();
		for(int i=0; i<discount.length; i++) {
			OrderBean orderbean = new OrderBean();
			orderbean.setDiscount(discount[i]);
			orderbean.setQty(qty[i]);
			orderbean.setImg(img[i]);
			orderbean.setTitle(title[i]);
			orderbean.setIsbn(isbn[i]);
			orderbean.setStatus(status[i]);
			orderbeanlist.add(orderbean); 
		}
		System.out.println("R == " + orderbeanlist);
		request.setAttribute("orderbeanlist", orderbeanlist);
		
		
		
		
		// 지점 목록
		List<StoreVO> storeList = StoreDAO.getInstance().getAllStore();
		request.setAttribute("storeList", storeList);
		
		
		// 사려는 책 지점별 재고 표시위한 목록
		List<ArrayList<BookStockVO>> stockList = new ArrayList<>();
		
		for(String i : isbn) {
			List<BookStockVO> bslist = BookStockDAO.getInstance().getBookStock(i);
			stockList.add((ArrayList<BookStockVO>) bslist);
			System.out.println("Bbb=" + bslist );
			
		
		}
	
		
		System.out.println("TTT == " +stockList);
		request.setAttribute("stockList", stockList);
		
		BookStockVO voo = new BookStockVO();
		voo.setIsbn("9791186627228");
		voo.setStoreid(1);
		String sss = BookStockDAO.getInstance().bookStockQtyPrint(voo);
		System.out.println("sss = " + sss);
		
		String ds = "";
		
		List<ArrayList<String>> Tlist = new ArrayList<>(); 
		for (int j = 0; j < isbn.length; j++) {
			List<String> tlist = new ArrayList<>();
			for (int i = 0; i < storeList.size(); i++) {
				voo.setIsbn(isbn[j]);
				voo.setStoreid(i);
				ds = BookStockDAO.getInstance().bookStockQtyPrint(voo);
				if(ds.equals(null)) {
					ds = "0";
				}
				System.out.println("DD = " + ds);
				tlist.add(ds);
			}
			System.out.println("tlsit = " + tlist);
			Tlist.add((ArrayList<String>) tlist);
			
		}
		System.out.println("Tlsit = " + Tlist);
		request.setAttribute("Tlist", Tlist);
		
	
		
		for (int i= 0; i < isbn.length; i++) {
			voo.setIsbn(ds);
		}
		
		
		//
		for(String s : qty) {
			System.out.println(s);
		}
		
		List<String> store0_CheckList = new ArrayList<>();
		List<String> store1_CheckList = new ArrayList<>();
		List<String> store2_CheckList = new ArrayList<>();
		List<String> store3_CheckList = new ArrayList<>();
		for(int i=0; i<status.length; i++) {
			if(status[i].equals("1")) {
				BookStockVO vo = new BookStockVO();
				vo.setStoreid(0);
				vo.setIsbn(isbn[i]);
				vo.setQty(Integer.parseInt(qty[i]));
				
				store0_CheckList = BookStockDAO.getInstance().bookStockQtyCheck(vo);
			}
		}
		System.out.println("000 " + store0_CheckList);
				
		
		String ds2 = "";
		
		List<ArrayList<String>> Tlist2 = new ArrayList<>(); 
		for (int i = 0; i < storeList.size(); i++) {
			List<String> tlist2 = new ArrayList<>();
				for (int j = 0; j < isbn.length; j++) {
				voo.setIsbn(isbn[j]);
				voo.setStoreid(i);
				ds2 = BookStockDAO.getInstance().bookStockQtyPrint(voo);
				if(ds2.equals(null)) {
					ds2 = "0";
				}
			
				System.out.println("DD = " + ds2);
				tlist2.add(ds2);
			}
			System.out.println("tlsit2 = " + tlist2);
			Tlist2.add((ArrayList<String>) tlist2);
			
		}
		System.out.println("Tlsit2 = " + Tlist2);
		request.setAttribute("Tlist2", Tlist2);
		
		//
		int gose = 0;
		List<Integer> goselist = new ArrayList<>();
		for(int i =0; i<storeList.size(); i++) {
			for(int j=0; j<status.length; j++) {
				if(status[j].equals("1")) {
					if(Integer.parseInt( Tlist2.get(i).get(j)) >= Integer.parseInt( qty[j])) {
						gose = 1;
					} else {
						gose = 2;
					}
					goselist.add(gose);
				}
			}
		}
		System.out.println("goselist = " + goselist);
		
		//
		List<String> gulist = new ArrayList<>();

		for (int i = 0; i < isbn.length; i++) {
			if (status[i].equals("1")) {
				BookStockVO gu = new BookStockVO();
				gu.setIsbn(isbn[i]);
				gu.setQty(Integer.parseInt(qty[i]));
				gu.setStoreid(0);
				String se = BookStockDAO.getInstance().validStore(gu);
				gulist.add(se);
			}
		}
		System.out.println("gulist = " + gulist);

		List<String> sto0 = new ArrayList<>();
		for (int i = 0; i < gulist.size(); i++) {
			BookVO vo = new BookVO();
			if (!gulist.get(i).equals("-1")) {
				vo = BookDAO.getInstance().getBookInfo(gulist.get(i));
				sto0.add("O" + vo.getTitle());
			} else {
				vo = BookDAO.getInstance().getBookInfo(isbn[i]);
				sto0.add("X" + vo.getTitle());
			}
		}
		System.out.println("sto0 =" + sto0);

		List<String> gulist1 = new ArrayList<>();

		for (int i = 0; i < isbn.length; i++) {
			if (status[i].equals("1")) {
				BookStockVO gu = new BookStockVO();
				gu.setIsbn(isbn[i]);
				gu.setQty(Integer.parseInt(qty[i]));
				gu.setStoreid(1);
				String se = BookStockDAO.getInstance().validStore(gu);
				gulist1.add(se);
			}
		}
		System.out.println("gulist1 = " + gulist1);

		List<String> sto1 = new ArrayList<>();
		for (int i = 0; i < gulist1.size(); i++) {
			BookVO vo = new BookVO();
			if (!gulist1.get(i).equals("-1")) {
				vo = BookDAO.getInstance().getBookInfo(gulist1.get(i));
				sto1.add("O" + vo.getTitle());
			} else {
				vo = BookDAO.getInstance().getBookInfo(isbn[i]);
				sto1.add("X" + vo.getTitle());
			}
		}
		System.out.println("sto1 =" + sto1);
		
		List<String> gulist2 = new ArrayList<>();

		for (int i = 0; i < isbn.length; i++) {
			if (status[i].equals("1")) {
				BookStockVO gu = new BookStockVO();
				gu.setIsbn(isbn[i]);
				gu.setQty(Integer.parseInt(qty[i]));
				gu.setStoreid(1);
				String se = BookStockDAO.getInstance().validStore(gu);
				gulist2.add(se);
			}
		}
		System.out.println("gulist2 = " + gulist2);

		List<String> sto2 = new ArrayList<>();
		for (int i = 0; i < gulist2.size(); i++) {
			BookVO vo = new BookVO();
			if (!gulist2.get(i).equals("-1")) {
				vo = BookDAO.getInstance().getBookInfo(gulist2.get(i));
				sto2.add("O" + vo.getTitle());
			} else {
				vo = BookDAO.getInstance().getBookInfo(isbn[i]);
				sto2.add("X" + vo.getTitle());
			}
		}
		System.out.println("sto2 =" + sto2);
		
		List<String> gulist3 = new ArrayList<>();

		for (int i = 0; i < isbn.length; i++) {
			if (status[i].equals("1")) {
				BookStockVO gu = new BookStockVO();
				gu.setIsbn(isbn[i]);
				gu.setQty(Integer.parseInt(qty[i]));
				gu.setStoreid(1);
				String se = BookStockDAO.getInstance().validStore(gu);
				gulist3.add(se);
			}
		}
		System.out.println("gulist3 = " + gulist3);

		List<String> sto3 = new ArrayList<>();
		for (int i = 0; i < gulist3.size(); i++) {
			BookVO vo = new BookVO();
			if (!gulist3.get(i).equals("-1")) {
				vo = BookDAO.getInstance().getBookInfo(gulist3.get(i));
				sto3.add("O" + vo.getTitle());
			} else {
				vo = BookDAO.getInstance().getBookInfo(isbn[i]);
				sto3.add("X" + vo.getTitle());
			}
		}
		System.out.println("sto3 =" + sto3);
		
		request.setAttribute("sto0", sto0);
		request.setAttribute("sto1", sto1);
		request.setAttribute("sto2", sto2);
		request.setAttribute("sto3", sto3);
		
		return "pay/selectShop";
	}

}
