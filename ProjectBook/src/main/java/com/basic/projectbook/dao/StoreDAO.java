package com.basic.projectbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.basic.projectbook.util.MybatisConfig;
import com.basic.projectbook.vo.BookVO;
import com.basic.projectbook.vo.StoreVO;

public class StoreDAO {
	private StoreDAO() {}
	private static StoreDAO instance =new StoreDAO();
	public static StoreDAO getInstance() {
		return instance;
	}
	
	public List<StoreVO> getAllStore(){
		SqlSession session=MybatisConfig.getInstance().openSession(true);
		List<StoreVO> list=session.selectList("mapper.store.getAllStore");
		session.close();
		return list;
	}
	
}
