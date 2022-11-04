package com.springexample.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@GetMapping("/summer-note-demo")
	public String showSummerNote() {
		
		return "summer-note";	 // /WEB-INF/view/ + showtime + .jsp
	}
	
	@PostMapping("/summernote-write")
	public String write(String title, String content) {
		
		System.out.println(title);
		System.out.println(content);
		
		return "summer-note";
	}

}
