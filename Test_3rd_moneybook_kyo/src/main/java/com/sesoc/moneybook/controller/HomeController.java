package com.sesoc.moneybook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	@RequestMapping(value = "/SignupForm", method = RequestMethod.GET)
	public String SignupForm() {
		
		return "signupForm";
	}
	
	@RequestMapping(value = "/moneybook", method = RequestMethod.GET)
	public String moneybook() {
		
		return "moneybook";
	}
	
	@RequestMapping(value = "/goHome", method = RequestMethod.POST)
	public String goHome() {
		
		return "main";
	}
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		
		return "loginForm";
	}
	
	@RequestMapping(value = "/ListForm", method = RequestMethod.GET)
	public String ListForm(HttpSession session) {
		
		
		return "moneybook";
	}
}
