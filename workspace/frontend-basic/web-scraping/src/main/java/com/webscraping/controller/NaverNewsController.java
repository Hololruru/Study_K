package com.webscraping.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = { "/naver" })
public class NaverNewsController {
	
	@GetMapping(path = { "/it-news" })
	public String showItNewsForm() {
		
		int sid1 = 105;
		int sid2 = 230;
		String date = "20221130";
		int page = 1;
		String urlFormat = "https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid1=%d&sid2=%d&date=%s&page=%d";
		
		try {
			String url = String.format(urlFormat, sid1, sid2, date, page);
			Document doc = Jsoup.connect(url).get();
			
			Elements dls = doc.select(".type06_headline li dl");
			
			System.out.println(dls.size());
			
		} catch (Exception ex) {
			
		} finally {
			
		}
		
		return "naver/it-news";
	}
	

}




