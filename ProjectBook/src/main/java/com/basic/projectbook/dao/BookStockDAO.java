package com.basic.projectbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.basic.projectbook.util.MybatisConfig;
import com.basic.projectbook.vo.BookStockVO;
import com.basic.projectbook.vo.BookVO;
import com.basic.projectbook.vo.StoreVO;

public class BookStockDAO {
	private BookStockDAO() {}
	private static BookStockDAO instance =new BookStockDAO();
	public static BookStockDAO getInstance() {
		return instance;
	}
	public void deleteAllBookStock() {
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		session.update("mapper.bookstock.deleteAllBookStock");
		session.close();
		return;
	}
	public void bookStockDummy() {
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		session.insert("mapper.bookstock.bookStockDummy");
		session.close();
		return;
	}
	public List<BookStockVO> getAllBookStock(){
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		List<BookStockVO>list=session.selectList("mapper.bookstock.getAllBookStock");
		session.close();
		return list;
	}
	

}
