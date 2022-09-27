package com.springexample.springioc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class MyMessageService implements MessageService {
	
	int data;
	public MyMessageService() {
		data = (int)(Math.random() * 900) + 100;
	}
	
	public String getMessage() {
		return "Hello, Spring IoC Container !!!" + data;
	}
	
	public void init() {
		System.out.println("MyMessageService.init()");
	}
	
	public void destroy() {
		System.out.println("MyMessageServce.destroy()");
	}

}
