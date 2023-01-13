package com.springbootexample.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	@GetMapping(path = { "/", "/home" })
	public String home() {
		
		return "demo-home";
	}
	
	@GetMapping(path = { "/get-greetings" })
	@ResponseBody
	public String getGreetings(String name) {
	
		try {
			String path = "http://localhost:5000/get-greetings" + ( name != null ? "?name=" + URLEncoder.encode(name, "utf-8") : "");
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			int respCode = conn.getResponseCode();
			if (respCode == HttpURLConnection.HTTP_OK) {
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String message = "";
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					message += line;
				}
		
				return "MESSAGE FROM FLASK : " + message;
			} else {
				return "fail to receive data 1";
			}
		} catch (Exception ex) {
			return "fail to receive data 2";
		}
		
	}


	@GetMapping(path = { "/get-winning-numbers" })
	@ResponseBody
	public String getWinningNumbers() {
		
		try {
			String path = "http://localhost:5000/get-winning-numbers";
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			int respCode = conn.getResponseCode();
			if (respCode == HttpURLConnection.HTTP_OK) {
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String message = "";
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					message += line;
				}
		
				return message;
			} else {
				return "fail to receive data 1";
			}
		} catch (Exception ex) {
			return "fail to receive data 2";
		}
	}
}













