package com.basic.projectbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.basic.projectbook.util.MybatisConfig;
import com.basic.projectbook.vo.CartListViewBean;
import com.basic.projectbook.vo.CartVO;


public class CartDAO {
	private CartDAO() {}
	private static CartDAO instance = new CartDAO();
	public static CartDAO getInstance() {
		return instance;
	}
			
	public void cartAdd(CartVO vo) {
		SqlSession ss = MybatisConfig.getInstance().openSession(true);
		ss.insert("mapper.cart.cartInsert", vo);
		ss.close();
	}
	
	public int validIsbn(CartVO vo) {
		SqlSession ss = MybatisConfig.getInstance().openSession(true);
		int x = ss.selectOne("mapper.cart.validIsbn", vo);
		ss.close();
		return x;
	}
	
	public List<CartListViewBean> getOneCartList(String id) {
		SqlSession ss = MybatisConfig.getInstance().openSession(true);
		List<CartListViewBean> list = ss.selectList("mapper.cart.getOneCartList", id);
		ss.close();
		return list;
	}
	
	public int cartDelete(CartVO vo) {
		SqlSession ss = MybatisConfig.getInstance().openSession(true);
		int x = ss.delete("mapper.cart.cartDelete", vo);
		ss.close();
		return x;
	}
	
	public int cartUpdate(CartVO vo) {
		SqlSession ss = MybatisConfig.getInstance().openSession(true);
		int x = ss.update("mapper.cart.cartUpdate", vo);
		ss.close();
		return x;
	}
}
