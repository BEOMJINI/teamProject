package com.basic.projectbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.basic.projectbook.util.MybatisConfig;
import com.basic.projectbook.vo.MyOrderViewBean;
import com.basic.projectbook.vo.OrderListVO;
import com.basic.projectbook.vo.ReviewCheckBean;
import com.basic.projectbook.vo.StoreMapVO;


public class OrderListDAO {
	private OrderListDAO() {}
	private static OrderListDAO instance = new OrderListDAO();
	public static OrderListDAO getInstance() {
		return instance;
	}
	public void addOrderDummy(){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		session.insert("mapper.orderlist.addOrderDummy");
		session.close();
		return ;
	}
	public List<MyOrderViewBean> getMyOrder(String id){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<MyOrderViewBean>list=session.selectList("mapper.orderlist.getMyOrder",id);
		session.close();
		return list;
	}
	public List<ReviewCheckBean> getReviewCheck(String id) {
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		List<ReviewCheckBean> list=session.selectList("mapper.orderlist.getReviewCheck",id);
		
		session.close();
		return list;
	}
	
}

