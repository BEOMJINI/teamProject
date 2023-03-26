package com.basic.projectbook.controller.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.projectbook.dao.BookDAO;
import com.basic.projectbook.dao.ReviewDAO;
import com.basic.projectbook.frontController.Controller;
import com.basic.projectbook.vo.BookAndRatingBean;
import com.basic.projectbook.vo.ReviewRatingAvgBean;

public class BookListController implements Controller {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<BookAndRatingBean> list = BookDAO.getInstance().getAllBookAndRating();
		// 최신순 글자순 선택

		// 옆 카테고리 목록
		List<BookAndRatingBean> genreList = new ArrayList<BookAndRatingBean>();
		for (int i = 0; i < list.size(); i++) {

			if (i == 0) {
				genreList.add(list.get(i));
			}
			boolean check = false;
			for (int j = 0; j < genreList.size(); j++) {
				if (list.get(i).getGenre().equals(genreList.get(j).getGenre())) {

					break;
				}
				if (j == genreList.size() - 1) {

					genreList.add(list.get(i));
				}
			}
		}
		request.setAttribute("genreList", genreList);

		List<BookAndRatingBean> publisherList = new ArrayList<BookAndRatingBean>();
		for (int i = 0; i < list.size(); i++) {

			if (i == 0) {
				publisherList.add(list.get(i));
			}
			boolean check = false;
			for (int j = 0; j < publisherList.size(); j++) {
				if (list.get(i).getPublisher().equals(publisherList.get(j).getPublisher())) {

					break;
				}
				if (j == publisherList.size() - 1) {

					publisherList.add(list.get(i));
				}
			}
		}
		request.setAttribute("publisherList", publisherList);

		List<BookAndRatingBean> countryList = new ArrayList<BookAndRatingBean>();
		for (int i = 0; i < list.size(); i++) {

			if (i == 0) {
				countryList.add(list.get(i));
			}
			boolean check = false;
			for (int j = 0; j < countryList.size(); j++) {
				if (list.get(i).getCountry().equals(countryList.get(j).getCountry())) {

					break;
				}
				if (j == countryList.size() - 1) {

					countryList.add(list.get(i));
				}
			}
		}
		request.setAttribute("countryList", countryList);
		if (request.getParameter("show") != null) {
			if (request.getParameter("show").equals("latest")) {
				list = BookDAO.getInstance().getAllBookLatestAndRating();
			} else if (request.getParameter("show").equals("letter")) {
				list = BookDAO.getInstance().getAllBookLetterAndRating();
			} else if (request.getParameter("show").equals("sale")) {
				list = BookDAO.getInstance().getAllBookSaleAndRating();
			} else if (request.getParameter("show").equals("rating")) {
				list = BookDAO.getInstance().getAllBookRatingAndRating();
			}
		}

		if (request.getParameter("cate") != null && request.getParameter("key") != null) {
			String cate = request.getParameter("cate");
			String key = request.getParameter("key");
			if (cate.equals("genre")) {
				list = BookDAO.getInstance().getGenreBookAndRating(key);
			} else if (cate.equals("country")) {
				list = BookDAO.getInstance().getCountryBookAndRating(key);
			} else {
				list = BookDAO.getInstance().getPublisherBookAndRating(key);
			}

		}
		if (request.getParameter("keyword") != null) {
			if (request.getParameter("search").equals("title")) {

			} else if (request.getParameter("search").equals("author")) {

			} else {

			}

		}
		if (request.getParameter("search") != null) {
			String search = request.getParameter("search");
			String keyword = request.getParameter("keyword");
			if (search.equals("title")) {
				list = BookDAO.getInstance().getAllBookTitleAndRating(keyword);
				System.out.println("타이틀리스트사이즈:" + list.size());
			} else if (search.equals("description")) {
				list = BookDAO.getInstance().getAllBookDescriptionAndRating(keyword);
			} else {
				list = BookDAO.getInstance().getAllBookAuthorAndRating(keyword);
			}
		}

		// 옆 카테고리 눌렀을시 리스트 재설정

		request.setAttribute("list", list);

		return "book/bookListAll";
	}

}
