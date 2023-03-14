package com.basic.projectbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.basic.projectbook.util.MybatisConfig;
import com.basic.projectbook.vo.MemberVO;

public class MemberDAO {
	private MemberDAO() {}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public List<MemberVO> getAllMember() {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		List<MemberVO> list = session.selectList("mapper.member.getAllMember");
		session.close();
		return list;
	}
	
	public MemberVO getOneMember(String id) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		MemberVO vo = session.selectOne("mapper.member.getOneMember", id);
		return vo;
	}
	
	public int testnum() {
		int x =3 ;
		return x;
	}
	
}
