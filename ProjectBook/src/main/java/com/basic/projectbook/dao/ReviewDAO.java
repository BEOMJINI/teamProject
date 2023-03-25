package com.basic.projectbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.basic.projectbook.util.MybatisConfig;
import com.basic.projectbook.vo.ReviewCheckBean;
import com.basic.projectbook.vo.ReviewVO;
import com.basic.projectbook.vo.StoreVO;


public class ReviewDAO {
	private ReviewDAO() {}
	private static ReviewDAO instance = new ReviewDAO();
	public static ReviewDAO getInstance() {
		return instance;
	}
	public void addReviewDummy(){
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		session.insert("mapper.review.addReviewDummy");
		session.close();
		return ;
	}
	public int getLastNo() {
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		int no=session.selectOne("mapper.review.getLastNo");
		session.close();
		return no;
	}
	
			
	
}

