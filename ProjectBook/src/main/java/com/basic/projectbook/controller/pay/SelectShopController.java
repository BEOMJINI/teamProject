package com.basic.projectbook.controller.pay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.projectbook.dao.BookStockDAO;
import com.basic.projectbook.dao.StoreDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookStockVO;
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
		
		// 지점 목록
		List<StoreVO> storeList = StoreDAO.getInstance().getAllStore();
		request.setAttribute("storeList", storeList);
		
		// 재고
		List<ArrayList<BookStockVO>> stockList = new ArrayList<>();
		
		
		
		for(String i : isbn) {
			List<BookStockVO> bslist = BookStockDAO.getInstance().getBookStock(i);
			stockList.add((ArrayList<BookStockVO>) bslist);
			
			
		}
		System.out.println(stockList.get(0).get(0).getIsbn());
		System.out.println(stockList);
		System.out.println(stockList.get(0));
		System.out.println(stockList.get(0).get(0));
		request.setAttribute("stockList", stockList);
		
		//
		for(String s : qty) {
			System.out.println(s);
		}
		ArrayList<String> store0_CheckList = new ArrayList<>();
		BookStockVO vo = new BookStockVO();
		for(int i=0; i<status.length; i++) {
			if(status[i].equals("1")) {
				vo.setStoreid(0);
				vo.setIsbn(isbn[i]);
				vo.setQty(Integer.parseInt(qty[i]));
				
				String x = BookStockDAO.getInstance().bookStockQtyCheck(vo);
				store0_CheckList.add(x);
			}
		}
		System.out.println(store0_CheckList);
		
		vo.setStoreid(0);
		vo.setIsbn("9791138435628");
		vo.setQty(1);
		String y = BookStockDAO.getInstance().bookStockQtyCheck(vo);
		System.out.println("y== " +y);
		
		//
		int compareData = 0;
		ArrayList<ArrayList<Integer>> compareList = new ArrayList<>();
		ArrayList<Integer> data = new ArrayList<>();
		for (int i = 0; i < isbn.length; i++) {

			if (status[i].equals("1")) {

				for (int j = 0; j < stockList.get(i).size(); j++) {
					System.out.print(stockList.get(i).get(j).getStoreid() + " ");
					if (isbn[i].equals(stockList.get(i).get(j).getIsbn())) {

						System.out.println("is === " + isbn[i]);
						if (Integer.parseInt(qty[i]) > stockList.get(i).get(j).getQty()) {
							compareData = -1;
						}
						data.add(compareData);

					} else if (stockList.get(i).get(j).getStoreid() == 1) {

						System.out.println("is === " + isbn[i]);
						if (Integer.parseInt(qty[i]) > stockList.get(i).get(j).getQty()) {
							compareData = -1;
						}
						data.add(compareData);

					} else if (stockList.get(i).get(j).getStoreid() == 2) {

						System.out.println("is === " + isbn[i]);
						if (Integer.parseInt(qty[i]) > stockList.get(i).get(j).getQty()) {
							compareData = -1;
						}
						data.add(compareData);

					} else if (stockList.get(i).get(j).getStoreid() == 3) {

						System.out.println("is === " + isbn[i]);
						if (Integer.parseInt(qty[i]) > stockList.get(i).get(j).getQty()) {
							compareData = -1;
						}

					}
				}
				data.add(compareData);
				compareList.add(data);
			}

		}

		System.out.println("data === " + data);
		System.out.println("compareList === "+ compareList);
		
		return "pay/selectShop";
	}

}
