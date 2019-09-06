package com.sesoc.moneybook.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.moneybook.vo.MoneybookVO;

@Repository
public class MoneybookDAO {
	@Autowired
	SqlSession session;
	
	public int insertMoneybook(MoneybookVO moneybook) {
		int result = 0;
		
		MoneybookMapper mapper = session.getMapper(MoneybookMapper.class);
		
		try {
			System.out.println(moneybook);
			result = mapper.insertMoneybook(moneybook);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<MoneybookVO> selectAll(MoneybookVO moneybook) {
		ArrayList<MoneybookVO> result = new ArrayList<>();
		
		MoneybookMapper mapper = session.getMapper(MoneybookMapper.class);
		
		try {
			result = mapper.selectAll(moneybook);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<MoneybookVO> searchDate(MoneybookVO moneybook) {
		ArrayList<MoneybookVO> result = new ArrayList<>();
		
		MoneybookMapper mapper = session.getMapper(MoneybookMapper.class);
		
		try {
			result = mapper.searchDate(moneybook);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deleteList(MoneybookVO moneybook) {
		int result = 0;
		
		MoneybookMapper mapper = session.getMapper(MoneybookMapper.class);
		
		try {
			result = mapper.deleteList(moneybook);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
