package com.basic.projectbook.dao;

import java.util.List;
import java.util.Map;

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
	public List<BookVO> getAllBookLetter(){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookVO> list=session.selectList("mapper.book.getAllBookLetter");
		session.close();
		return list;
	}
	public List<BookVO> getAllBookLatest(){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookVO> list=session.selectList("mapper.book.getAllBookLatest");
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
	public BookVO getBookInfo(String isbn) {
		System.out.println("isbn:"+isbn);
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		BookVO vo=session.selectOne("mapper.book.getBookInfo",isbn);
		session.close();
		
		return vo ;
	}
	public void deleteBook(String isbn) {
		
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.delete("mapper.book.deleteBook",isbn);
		session.close();
		
		return ;
	}
	public List<Map<String, Object>> selectBookWithStockAndStore() {
	    SqlSession session = MybatisConfig.getInstance().openSession();
	    try {
	        return session.selectList("selectBookWithStockAndStore");
	    } finally {
	        session.close();
	    }
	}
	public List<BookVO>getLatestThreeBook(){
		
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookVO>list=session.selectList("mapper.book.getLatestThreeBook");
		session.close();
		
		return list ;
	}
	public BookVO getOneBookGenre(String genre){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		BookVO vo=session.selectOne("mapper.book.getOneBookGenre",genre);
		session.close();
		
		return vo ;
	}
	public List<BookVO> getBookListGenre (String genre) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookVO> list=session.selectList("mapper.book.getBookListGenre",genre);
		session.close();
		return list;
	}
}
