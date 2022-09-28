package com.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // @Component + Web configuration --> IoC 컨테이너에 등록
public class HomeController {
	
	@GetMapping(path = { "/", "/home.action" }) // FrontController에 요청 처리기 등록
	public String home() {
		return "home"; // /WEB-INF/views/ + home + .jsp
	}

}







