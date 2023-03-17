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
		List<BookVO>list=BookDAO.getInstance().getAllBook();
		request.setAttribute("list", list);
		
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
		
		List<BookVO>countryList=new ArrayList<BookVO>();
for(int i=0;i<list.size();i++) {
			
			if(i==0) {
				countryList.add(list.get(i));
			}
			boolean check=false;
			for(int j=0;j<countryList.size();j++) {
				if(list.get(i).getCountry()==(countryList.get(j).getCountry())) {
					
					break;
				}
				if(j==countryList.size()-1) {
					
					countryList.add(list.get(i));
				}
			}
		}
request.setAttribute("countryList", countryList);
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
		
		
		if(best == true) {
			best = false;
			
			
			return "book/bookListBest";
		}
		
		
		System.out.println("listsize:"+list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getTitle());
		}
		
		
		
		return "book/bookListAll";
	}

}
