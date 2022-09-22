package com.demoweb.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoweb.dto.BoardDto;
import com.demoweb.service.BoardService;

@WebServlet(urlPatterns = { "/board/list.action" })
public class BoardListServlet extends HttpServlet {
	
	private final int PAGE_SIZE = 3; 	// 한 페이지에 표시되는 데이터 개수
	private final int PAGER_SIZE = 3;	// 한 번에 표시할 페이지 번호 개수
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 처리
		BoardService boardService = new BoardService();
		// List<BoardDto> boards = boardService.findAllBoard(); // 전체 데이터 조회
		
		String sPageNo = req.getParameter("pageNo");
		int pageNo;
		try {
			pageNo = Integer.parseInt(sPageNo);
		} catch(Exception ex) {
			pageNo = 1;
		}		
		List<BoardDto> boards = boardService.findBoardByPage(pageNo, PAGE_SIZE); // 페이지번호, 개수	
		int boardCount = boardService.findBoardCount();
		
		// 2. JSP에서 읽을 수 있도록 데이터 전달 ( request 객체에 저장 )
		req.setAttribute("boards", boards);
		
		// 3. 응답 컨텐츠 생산 ( JSP로 forward 이동 )		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
		rd.forward(req, resp); // 지정된 경로로 forward 이동
	}

}
