package com.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.demoweb.dto.MemberDto;
import com.demoweb.service.AccountService;

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
		AccountService accountService = new AccountService();
		accountService.registerMember(member);
		
		// 3. View에서 사용할 수 있도록 데이터 전달
		
		// 4. View 또는 다른 Controller로 이동
		return "redirect:/account/login.action";
	}
	
	@GetMapping(path = { "/login.action" })
	public String showLoginForm() {
		
		return "account/login";		//  /WEB-INF/views/ + account/login + .jsp
	}
	
	@PostMapping(path = { "/login.action" })
	public View login(String memberId, String passwd) {
		// 1. 요청 데이터 읽기 ( 전달인자 사용해서 대체 )
		
		// 2. 요청 처리
		AccountService accountService = new AccountService();
		MemberDto member = accountService.findMemberByIdAndPasswd(memberId, passwd);
		
		// 3. View에서 사용하도록 데이터 전달
		
		// 4. View 또는 다른 Controller로 이동 
		return new RedirectView("/home.action"); // return "redirect:/home.action";
	}

}












