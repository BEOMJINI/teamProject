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

}
