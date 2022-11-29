package com.webscraping.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = { "/lotto" })
public class LottoController {
	
	@GetMapping(path = { "/winning-numbers-by-round" })
	public String showWinningNumbersForm() {
		
		try {
			Document doc = 
					Jsoup.connect("https://dhlottery.co.kr/gameResult.do?method=byWin").get();
			
			// System.out.println(doc.title());
			Elements spans = doc.select(".num.win p span");
			for (Element span : spans) {
				System.out.println(span.text());
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return "lotto/winning-numbers-by-round";
	}

}




