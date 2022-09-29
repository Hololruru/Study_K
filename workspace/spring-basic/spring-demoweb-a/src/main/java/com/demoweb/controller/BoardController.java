package com.demoweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoweb.dto.BoardDto;
import com.demoweb.service.BoardService;
import com.demoweb.service.BoardServiceImpl;

@Controller
@RequestMapping(path = { "/board" })
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	@GetMapping(path = { "/list.action" })
	public String showBoardList(Model model) {
		// 1. 요청 데이터 읽기
		// 2. 데이터 처리 ( 데이터 조회 )
		
		List<BoardDto> boards = boardService.findAllBoard();
		
		// 3. View에서 읽을 수 있도록 데이터 저장
		model.addAttribute("boards", boards);
		
		// 4. View or Controller로 이동
		return "board/list"; 	// /WEB-INF/views/ + board/list + .jsp
	}

}
