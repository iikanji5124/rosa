package com.sesoc.moneybook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesoc.moneybook.dao.MemberDAO;
import com.sesoc.moneybook.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping(value = "/singup", method = RequestMethod.POST)
	public String singup(MemberVO member) {
		
		System.out.println(member);
		int result = dao.insertMember(member);
		
		if(result > 0){
			return "loginForm";
		}
		else{
			return "signupForm";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO member, HttpSession session) {
		System.out.println(member);
		
		MemberVO result = dao.selectOne(member);
		
		if(result != null){
			session.setAttribute("loginId", result.getUserid());
		}
		return "main";
	}
	
	@RequestMapping(value = "/logoutForm", method = RequestMethod.GET)
	public String logoutForm(HttpSession session) {
		
		session.removeAttribute("loginId");
		
		return "main";
	}
}
