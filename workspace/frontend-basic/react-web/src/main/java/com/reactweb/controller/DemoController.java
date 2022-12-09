package com.reactweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reactweb.dto.Todo;

@Controller
@RequestMapping(path = { "/demo" })
public class DemoController {
	
	@GetMapping(path = { "/todo-app" })
	public String showTodoApp() {
		
		return "demo/todo-app";
	}
	
	@CrossOrigin
	@PostMapping(path = { "/add-todo" })
	@ResponseBody
	public String addTodo(@RequestBody Todo todo) {
		
		System.out.println(todo);
		
		return "success";
	}
	

}
