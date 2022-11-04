package com.springexample.mvc.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class DemoController {
	
	@GetMapping("/summer-note-demo")
	public String showSummerNote() {
		
		return "summer-note";	 // /WEB-INF/view/ + showtime + .jsp
	}
	
	@PostMapping("/summernote-write")
	public String write(String title, String content, Model model) {
		
		System.out.println(title);
		System.out.println(content);
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		
		return "summer-note-result";
	}
	
	@PostMapping("/upload-image-file")
	@ResponseBody // return 값이 jsp 이름이 아니고 응답 데이터. 주로 ajax 응답으로 사용
	// public String uploadImage(MultipartFile file) {
	public String uploadImage(MultipartHttpServletRequest req) {
		
		MultipartFile file = req.getFile("file");		
		String path = 
				req.getServletContext().getRealPath("/resources/image-files/" + file.getOriginalFilename());
		try {
			file.transferTo(new File(path)); // 저장
		} catch (Exception ex) {
			ex.printStackTrace();
		}		 
		
		return "/spring-mvc-1/resources/image-files/" + file.getOriginalFilename(); // 서버에 저장된 파일 경로
	}

}















