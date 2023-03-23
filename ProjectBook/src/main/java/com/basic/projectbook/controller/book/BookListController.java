package com.basic.projectbook.controller.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookVO;

public class BookListController implements Controller{

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// header 에서 베스트셀러 눌렀을 때
		boolean best = Boolean.parseBoolean(request.getParameter("best"));
		List<BookVO> list = new ArrayList<BookVO>();
		if(request.getParameter("show").equals("letter")) {
		list=BookDAO.getInstance().getAllBookLetter();		
		}
		else if(request.getParameter("show").equals("latest")) {
		list=BookDAO.getInstance().getAllBookLatest();	
		}
		else {
		list=BookDAO.getInstance().getAllBook();}
		
		
		
		List<BookVO>genreList=new ArrayList<BookVO>();
		for(int i=0;i<list.size();i++) {
			
			if(i==0) {
				genreList.add(list.get(i));
			}
			boolean check=false;
			for(int j=0;j<genreList.size();j++) {
				if(list.get(i).getGenre().equals(genreList.get(j).getGenre())) {
					
					break;
				}
				if(j==genreList.size()-1) {
					
					genreList.add(list.get(i));
				}
			}
		}
		request.setAttribute("genreList", genreList);
		
		List<BookVO>publisherList=new ArrayList<BookVO>();
for(int i=0;i<list.size();i++) {
			
			if(i==0) {
				publisherList.add(list.get(i));
			}
			boolean check=false;
			for(int j=0;j<publisherList.size();j++) {
				if(list.get(i).getPublisher().equals(publisherList.get(j).getPublisher())) {
					
					break;
				}
				if(j==publisherList.size()-1) {
					
					publisherList.add(list.get(i));
				}
			}
		}
		request.setAttribute("publisherList", publisherList);
		
		List<BookVO>countryList=new ArrayList<BookVO>();
		for(int i=0;i<list.size();i++) {
			
			if(i==0) {
				countryList.add(list.get(i));
			}
			boolean check=false;
			for(int j=0;j<countryList.size();j++) {
				if(list.get(i).getCountry().equals(countryList.get(j).getCountry())) {
					
					break;
				}
				if(j==countryList.size()-1) {
					
					countryList.add(list.get(i));
				}
			}
		}
		request.setAttribute("countryList", countryList);


		
		
		if(best == true) {
			best = false;
			
			
			return "book/bookListBest";
		}
		String cate=null;
		String key=null;
		if(request.getParameter("cate")!=null) {
		 cate=request.getParameter("cate");
		}
		if(request.getParameter("key")!=null) {
			key=request.getParameter("key");
		}
		
		for(int i=0;i<list.size();i++) {
			
		}
		
		if(cate.equals("country")) {
			
			list=BookDAO.getInstance().getCountryBook(key);
			
		}
		else if(cate.equals("publisher")) {
			
			list=BookDAO.getInstance().getPublisherBook(key);
		}
		else if(cate.equals("genre")) {
			
			list=BookDAO.getInstance().getGenreBook(key);
		}
		
		request.setAttribute("list", list);
		
		
		
		
		
		return "book/bookListAll";
	}

}
