package com.basic.projectbook.dao;

import org.apache.ibatis.session.SqlSession;

import com.basic.projectbook.util.MybatisConfig;
import com.basic.projectbook.vo.SaleVO;

public class SaleDAO {
	private SaleDAO() {}
	private static SaleDAO instance = new SaleDAO();
	public static SaleDAO getInstance() {
		return instance;
	}
	
	public int getMaxNo() {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int x = session.selectOne("mapper.sale.getMaxNo");
		session.close();
		return x;
	}
	
	public void saleInsert(SaleVO vo) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.insert("mapper.sale.saleInsert", vo);
		session.close();
	}
}
