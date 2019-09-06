package com.sesoc.moneybook.dao;

import java.util.ArrayList;

import com.sesoc.moneybook.vo.MoneybookVO;

public interface MoneybookMapper {
	public int insertMoneybook(MoneybookVO moneybook);
	
	public ArrayList<MoneybookVO> selectAll(MoneybookVO moneybook);
	public ArrayList<MoneybookVO> searchDate(MoneybookVO moneybook);
	
	public  int deleteList(MoneybookVO moneybook);
	
}
