package com.basic.projectbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.basic.projectbook.util.MybatisConfig;
import com.basic.projectbook.vo.BookVO;
import com.basic.projectbook.vo.StoreMapVO;

public class StoreMapDAO {
	private StoreMapDAO() {}
	private static StoreMapDAO instance = new StoreMapDAO();
	public static StoreMapDAO getInstance() {
		return instance;
	}
	
	public StoreMapVO getStoreMapInfo(int storeid){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		StoreMapVO vo=session.selectOne("mapper.storemap.getStoreMapInfo",storeid);
		session.close();
		return vo;
	}
	public List<StoreMapVO> getAllMap(){
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<StoreMapVO>list=session.selectList("mapper.storemap.getAllMap");
		session.close();
		return list;
	}
}
