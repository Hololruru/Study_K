package com.demoweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class DemoWebListener implements ServletContextListener, HttpSessionListener {
    
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("웹 애플리케이션 시작");
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("세션 시작");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("세션 종료");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("웹 애플리케이션 종료");
    }

    
	
}
