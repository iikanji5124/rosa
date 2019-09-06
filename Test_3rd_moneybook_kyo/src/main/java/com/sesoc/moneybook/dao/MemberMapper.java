package com.sesoc.moneybook.dao;

import com.sesoc.moneybook.vo.MemberVO;

public interface MemberMapper {
	public int insertMember(MemberVO member);
	public MemberVO selectOne(MemberVO member);
}
