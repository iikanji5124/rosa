package com.sesoc.moneybook.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sesoc.moneybook.dao.MoneybookDAO;
import com.sesoc.moneybook.vo.MoneybookVO;

@Controller
public class MoneybookController {
	@Autowired
	MoneybookDAO dao;
	
	@RequestMapping(value = "/insertList", method = RequestMethod.POST)
	@ResponseBody public String insertList(MoneybookVO moneybook, HttpSession session) {
		moneybook.setUserid((String)session.getAttribute("loginId"));
		System.out.println(moneybook);
		int result = dao.insertMoneybook(moneybook);
		
		if(result > 0){
			return "true";
		}
		else{
			return "false";
		}
	}
	
	@RequestMapping(value = "/searchDate", method = RequestMethod.POST)
	@ResponseBody public ArrayList<MoneybookVO> searchDate(MoneybookVO moneybook, HttpSession session) {
		moneybook.setUserid((String)session.getAttribute("loginId"));
		System.out.println(moneybook);
		ArrayList<MoneybookVO> result = dao.searchDate(moneybook);
		
		return result;
	}
	
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	@ResponseBody public ArrayList<MoneybookVO> selectAll(MoneybookVO moneybook, HttpSession session) {
		moneybook.setUserid((String)session.getAttribute("loginId"));
		
		ArrayList<MoneybookVO> result = dao.selectAll(moneybook);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value = "/deleteList", method = RequestMethod.POST)
	@ResponseBody public String deleteList(MoneybookVO moneybook, HttpSession session) {
		moneybook.setUserid((String)session.getAttribute("loginId"));
		
		int result = dao.deleteList(moneybook);
		
		if(result > 0){
			return "true";
		}
		else {
			return "false";
		}
		
	}
	
}
