package com.webscraping.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
			
			Elements dls = doc.select(".newsflash_body ul li dl");
			
			// System.out.println(dls.size());
			
			ArrayList<HashMap<String, Object>> newsList = new ArrayList<>();
			for (Element dl : dls) {
				HashMap<String, Object> news = new HashMap<>();
				Elements dts = dl.select("dt");
				if (dts.size() == 1) {					
					news.put("link", dts.get(0).select("a").attr("href"));
					news.put("title", dts.get(0).select("a").text());
				} else {
					news.put("link", dts.get(1).select("a").attr("href"));
					news.put("title", dts.get(1).select("a").text());
					news.put("image", dts.get(0).select("img").attr("src"));
				}
				news.put("desc", dl.select("dd").text());
				
				newsList.add(news);
			}
			
		} catch (Exception ex) {
			
		} finally {
			
		}
		
		return "naver/it-news";
	}
	

}




