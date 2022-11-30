package com.webscraping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/openapi")
public class OpenApiController {
	
	@GetMapping(path = { "/covid19" })
	public String showCovid19Form() {
		
		return "openapi/covid19";
	}

}
