package com.springexample.springboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping(path = { "/", "/home" })
	@ResponseBody
	public String home() {
		
		return "home";
	}
	

}
