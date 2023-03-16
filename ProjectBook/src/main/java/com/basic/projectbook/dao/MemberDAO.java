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
	
	public String memberLogin(MemberVO vo) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		String x = session.selectOne("mapper.member.memberLogin", vo);
		return x;
	}
	
	
	public int memberJoin(MemberVO vo) {
		SqlSession ss = MybatisConfig.getInstance().openSession(true);
		int y = ss.insert("mapper.member.memberInsert", vo);
		ss.close();
		return y;
	}
	
	public int testnum() {
		int x =3 ;
		return x;
	}
	
}
