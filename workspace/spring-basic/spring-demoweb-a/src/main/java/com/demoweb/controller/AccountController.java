package com.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoweb.dto.MemberDto;

@Controller
@RequestMapping(path = { "/account" })
public class AccountController {
	
	@GetMapping(path = { "/register.action" })
	public String showRegisterForm() {
		
		return "account/register";	//	/WEB-INF/views/ + account/register + .jsp
	}
	
	@PostMapping(path = { "/register.action" })
	public String register(MemberDto member) {
		// 1. 요청 데이터 읽기 -> DTO에 저장 : 전달인자 사용으로 대체
		System.out.println(member);
		// 2. 요청 처리
		
		// 3. View 또는 다른 Controller로 이동
		return "redirect:/account/login.action";
	}
	
	@GetMapping(path = { "/login.action" })
	public String showLoginForm() {
		
		return "account/login";		//  /WEB-INF/views/ + account/login + .jsp
	}

}












