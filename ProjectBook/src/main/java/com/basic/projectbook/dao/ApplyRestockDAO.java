package com.basic.projectbook.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.basic.projectbook.util.MybatisConfig;
import com.basic.projectbook.vo.ApplyRestockVO;
import com.basic.projectbook.vo.BookStockVO;
import com.basic.projectbook.vo.BookVO;

public class ApplyRestockDAO {
	private ApplyRestockDAO() {}
	private static ApplyRestockDAO instance = new ApplyRestockDAO();
	public static ApplyRestockDAO getInstance() {
		return instance;
	}
	public void addApplyRestock(ApplyRestockVO vo) {
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		session.insert("mapper.applyrestock.addApplyRestock",vo);
		session.close();
		return;
	}
	public List<ApplyRestockVO> getAllList(){
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		List<ApplyRestockVO>list=session.selectList("mapper.applyrestock.getAllList");
		return list;
	}
	public void deleteAllApply() {
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		session.delete("mapper.applyrestock.deleteAllApply");
		return ;
	}
	public void deleteOneApply(BookStockVO vo) {
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		session.delete("mapper.applyrestock.deleteOneApply",vo);
		return ;
	}
	
}
