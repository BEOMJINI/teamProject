package com.basic.projectbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.basic.projectbook.util.MybatisConfig;
import com.basic.projectbook.vo.OrderlistVO;

public class OrderlistDAO {
	private OrderlistDAO () {}
	private static OrderlistDAO instance = new OrderlistDAO();
	public static OrderlistDAO getInstance() {
		return instance;
	}
	
	public int getMaxNo() {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int x = session.selectOne("mapper.orderlist.getMaxNo");
		session.close();
		return x;
	}
	
	public void orderlistInsert(OrderlistVO vo) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.insert("mapper.orderlist.orderlistInsert", vo);
		session.close();
	}
	
	public List<OrderlistVO> orderlistPrint() {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<OrderlistVO> list = session.selectList("mapper.orderlist.orderlistPrint");
		session.close();
		return list;
	}
	
	public List<OrderlistVO> orderlistMember(String id) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<OrderlistVO> list = session.selectList("mapper.orderlist.orderlistMember", id);
		session.close();
		return list;
		
	}
}
