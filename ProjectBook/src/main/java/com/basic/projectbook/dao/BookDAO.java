package com.basic.projectbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.basic.projectbook.util.MybatisConfig;
import com.basic.projectbook.vo.BookVO;

public class BookDAO {
	private BookDAO() {}
	private static BookDAO instance = new BookDAO();
	public static BookDAO getInstance() {
		return instance;
	}
	
	public List<BookVO> getAllBook(){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookVO> list=session.selectList("mapper.book.getAllBook");
		session.close();
		return list;
	}
	public List<BookVO> getGenreBook(String genre){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookVO> list=session.selectList("mapper.book.getGenreBook",genre);
		return list;
	}
	public List<BookVO> getCountryBook(String country){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookVO> list=session.selectList("mapper.book.getCountryBook",country);
		return list;
	}
	public List<BookVO> getPublisherBook(String publisher){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookVO> list=session.selectList("mapper.book.getPublisherBook",publisher);
		return list;
	}

	public int insertBook(BookVO vo) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int x = session.insert("mapper.book.bookInsert", vo);
		session.close();
		return x;
	}
//	public List<BookVO> getAllBookStock(){
//		SqlSession session = MybatisConfig.getInstance().openSession(true);
//		List<BookVO>
//	}
}
