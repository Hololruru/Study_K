package com.demoweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demoweb.dto.BoardDto;
import com.demoweb.service.BoardService;
import com.demoweb.service.BoardServiceImpl;
import com.demoweb.ui.ThePager;

@Controller
@RequestMapping(path = { "/board" })
public class BoardController {
	
	private final int PAGE_SIZE = 3; 	// 한 페이지에 표시되는 데이터 개수
	private final int PAGER_SIZE = 3;	// 한 번에 표시할 페이지 번호 개수
	private final String LINK_URL = "list.action"; // 페이지 번호를 클릭했을 때 이동할 페이지 경로

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	@GetMapping(path = { "/list.action" })
	public String showBoardList(@RequestParam(defaultValue = "1") int pageNo, Model model) {
		// 1. 요청 데이터 읽기 ( 전달인자로 대체 )
		// 2. 데이터 처리 ( 데이터 조회 )		
		List<BoardDto> boards = boardService.findBoardByPage(pageNo, PAGE_SIZE);
		int boardCount = boardService.findBoardCount();
		
		ThePager pager = new ThePager(boardCount, pageNo, PAGE_SIZE, PAGER_SIZE, LINK_URL);
		
		// 3. View에서 읽을 수 있도록 데이터 저장
		model.addAttribute("boards", boards);
		model.addAttribute("pager", pager);
		model.addAttribute("pageNo", pageNo);
		
		// 4. View or Controller로 이동
		return "board/list"; 	// /WEB-INF/views/ + board/list + .jsp
	}
	
	@GetMapping(path = { "/detail.action" })
	public String showBoardDetail(@RequestParam(defaultValue = "-1") int boardNo, 
								  @RequestParam(defaultValue = "-1") int pageNo,
								  HttpSession session, 
								  Model model) {		
		// 1. 요청 데이터 읽기 ( 전달인자로 대체 )	
		if (boardNo == -1 || pageNo == -1) { // 요청 데이터가 잘못된 경우
			return "redirect:list.action";
		}
		
		// 2. 데이터 처리
		ArrayList<Integer> readList = (ArrayList<Integer>)session.getAttribute("read-list");
		if (readList == null) { // 세션에 목록이 없으면 
			readList = new ArrayList<>(); // 목록 새로 만들기
			session.setAttribute("read-list", readList); // 세션에 목록 등록
		}
		
		if (!readList.contains(boardNo)) { // 현재 글 번호가 읽은 글 목록에 포함되지 않은 경우
			boardService.increaseBoardReadCount(boardNo); // 글 조회수 증가
			readList.add(boardNo); // 읽은 글 목록에 현개 글 번호 추가			
		}
		
		BoardDto board = boardService.findBoardByBoardNo(boardNo);
		
		if (board == null) { // 조회되지 않은 경우 (글 번호가 잘못되었거나 또는 삭제된 글인 경우)
			return "redirect:list.action";
		}
		
		// 3. View에서 읽을 수 있도록 데이터 전달
		model.addAttribute("board", board);
		model.addAttribute("pageNo", pageNo);		
		
		// 4. View 또는 Controller로 이동
		return "board/detail";
	}
	
	@GetMapping(path = { "/write.action" })
	public String showWriteBoardForm() {
		
		return "board/write";
	}
	
	@PostMapping(path = { "/write.action" })
	public String writeBoard(BoardDto board) {
		// 1. 요청 데이터 읽기 (전달인자로 대체)
		// 2. 데이터 처리
		boardService.writeBoard(board);
		// 3. View에서 읽을 수 있도록 데이터 저장
		// 4. View 또는 Controller로 이동
		return "redirect:list.action";
	}

}















