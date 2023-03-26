package com.basic.projectbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.basic.projectbook.util.MybatisConfig;
import com.basic.projectbook.vo.GetMyReviewBean;
import com.basic.projectbook.vo.ReviewCheckBean;
import com.basic.projectbook.vo.ReviewRatingAvgBean;
import com.basic.projectbook.vo.ReviewVO;
import com.basic.projectbook.vo.StoreVO;
import com.basic.projectbook.vo.UpdateMyReviewBean;


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
	public void insertReview(ReviewVO vo) {
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		session.insert("mapper.review.insertReview",vo);
		session.close();
		return ;
	}
	public ReviewVO getMyReview(GetMyReviewBean bean) {
	SqlSession session=MybatisConfig.getInstance().openSession(true);
	ReviewVO vo=session.selectOne("mapper.review.getMyReview",bean);
	session.close();
	return vo;
	}
	public void updateMyReview(UpdateMyReviewBean bean) {
	SqlSession session=MybatisConfig.getInstance().openSession(true);
	session.update("mapper.review.updateMyReview",bean);
	session.close();
	return ;
	}
	public void deleteMyReview(int no) {
	SqlSession session=MybatisConfig.getInstance().openSession(true);
	session.delete("mapper.review.deleteMyReview",no);
	session.close();
	return;
	}
	public List<ReviewVO> getBookReview(String isbn){
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		List<ReviewVO>list =session.selectList("mapper.review.getBookReview",isbn);
		session.close();
		return list;
	}
	public ReviewVO getOneReview(int no) {
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		ReviewVO vo =session.selectOne("mapper.review.getOneReview",no);
		session.close();
		return vo;
	}
	public List<ReviewRatingAvgBean> getRatingAvg() {
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		List<ReviewRatingAvgBean> list=session.selectList("mapper.review.getRatingAvg");
		session.close();
		return list;
	}
	public int getRating(String isbn) {
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		int no=session.selectOne("mapper.review.getRating",isbn);
		session.close();
		return no;
	}
	
	
			
	
}

