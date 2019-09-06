package com.sesoc.moneybook.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.moneybook.vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int insertMember(MemberVO member) {
		int result = 0;
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			result = mapper.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public MemberVO selectOne(MemberVO member) {
		MemberVO result = null;
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			result = mapper.selectOne(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
