package com.basic.projectbook.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.basic.projectbook.util.MybatisConfig;
import com.basic.projectbook.vo.BookAndRatingBean;
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
	public List<BookVO> getAllBookTitle(String keyword){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookVO> list=session.selectList("mapper.book.getAllBookTitle",keyword);
		session.close();
		return list;
	}
	public List<BookVO> getAllBookDescription(String keyword){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookVO> list=session.selectList("mapper.book.getAllBookDescription",keyword);
		session.close();
		return list;
	}
	public List<BookVO> getAllBookAuthor(String keyword){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookVO> list=session.selectList("mapper.book.getAllBookAuthor",keyword);
		session.close();
		return list;
	}
	///========================/////////////========================
	public List<BookAndRatingBean> getAllBookAndRating(){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookAndRatingBean> list=session.selectList("mapper.book.getAllBookAndRating");
		session.close();
		return list;
	}
	public List<BookAndRatingBean> getAllBookLetterAndRating(){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookAndRatingBean> list=session.selectList("mapper.book.getAllBookLetterAndRating");
		session.close();
		return list;
	}
	public List<BookAndRatingBean> getAllBookLatestAndRating(){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookAndRatingBean> list=session.selectList("mapper.book.getAllBookLatestAndRating");
		session.close();
		return list;
	}
	public List<BookAndRatingBean> getGenreBookAndRating(String genre){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookAndRatingBean> list=session.selectList("mapper.book.getGenreBookAndRating",genre);
		return list;
	}
	public List<BookAndRatingBean> getCountryBookAndRating(String country){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookAndRatingBean> list=session.selectList("mapper.book.getCountryBookAndRating",country);
		return list;
	}
	public List<BookAndRatingBean> getPublisherBookAndRating(String publisher){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookAndRatingBean> list=session.selectList("mapper.book.getPublisherBookAndRating",publisher);
		return list;
	}
	public List<BookAndRatingBean> getAllBookTitleAndRating(String keyword){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookAndRatingBean> list=session.selectList("mapper.book.getAllBookTitleAndRating",keyword);
		session.close();
		return list;
	}
	public List<BookAndRatingBean> getAllBookDescriptionAndRating(String keyword){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookAndRatingBean> list=session.selectList("mapper.book.getAllBookDescriptionAndRating",keyword);
		session.close();
		return list;
	}
	public List<BookAndRatingBean> getAllBookAuthorAndRating(String keyword){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookAndRatingBean> list=session.selectList("mapper.book.getAllBookAuthorAndRating",keyword);
		session.close();
		return list;
	}
	public List<BookAndRatingBean> getAllBookSaleAndRating(){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookAndRatingBean> list=session.selectList("mapper.book.getAllBookSaleAndRating");
		session.close();
		return list;
	}
	public List<BookAndRatingBean> getAllBookRatingAndRating(){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<BookAndRatingBean> list=session.selectList("mapper.book.getAllBookRatingAndRating");
		session.close();
		return list;
	}
}
