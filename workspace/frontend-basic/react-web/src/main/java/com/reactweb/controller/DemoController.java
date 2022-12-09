package com.reactweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = { "/demo" })
public class DemoController {
	
	@GetMapping(path = { "/todo-app" })
	public String showTodoApp() {
		
		return "demo/todo-app";
	}
	
	@PostMapping(path = { "/add-todo" })
	@ResponseBody
	public String addTodo(int id, String title, boolean checkd) {
		
		return "success";
	}
	

}
