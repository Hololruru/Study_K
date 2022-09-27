package com.springexample.springioc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		//1.
		MyServiceConsumer consumer = new MyServiceConsumer();		
		
		ServiceConsumer consumer = 
				container.getBean("serviceConsumer", ServiceConsumer.class);		
		consumer.doSomething();	
		
		ServiceConsumer consumer2 = 
				container.getBean("serviceConsumer", ServiceConsumer.class);		
		consumer2.doSomething();	

	}

}


















