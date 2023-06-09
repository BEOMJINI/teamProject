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
		session.close();
		return vo;
	}
	
	public String memberLogin(MemberVO vo) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		String x = session.selectOne("mapper.member.memberLogin", vo);
		session.close();
		return x;
	}
	
	
	public int memberJoin(MemberVO vo) {
		SqlSession ss = MybatisConfig.getInstance().openSession(true);
		int y = ss.insert("mapper.member.memberInsert", vo);
		ss.close();
		return y;
	}
	
	public int validId(String id) {
		SqlSession session = MybatisConfig.getInstance().openSession(true);
		int z = session.selectOne("mapper.member.validId", id);
		session.close();
		return z;
		
	}
	
	public void memberDelete(String id) {
		SqlSession ss = MybatisConfig.getInstance().openSession(true);
		ss.delete("mapper.member.memberDelete", id);
		ss.close();
	}
	
	public void memberUpdate(MemberVO vo) {
		SqlSession ss = MybatisConfig.getInstance().openSession(true);
		ss.update("mapper.member.memberUpdate", vo);
		ss.close();
	}
	
	public void memberMileageUpdate(MemberVO vo) {
		SqlSession ss = MybatisConfig.getInstance().openSession(true);
		ss.update("mapper.member.memberMileageUpdate", vo);
		ss.close();
	}
	
}
