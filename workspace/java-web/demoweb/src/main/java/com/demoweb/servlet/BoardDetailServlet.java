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

@WebServlet(urlPatterns = { "/board/detail.action" })
public class BoardDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 처리
		String sBoardNo = req.getParameter("boardNo"); // 요청 데이터 읽기 : 사용자가 선택한 글번호 읽기
		int boardNo = Integer.parseInt(sBoardNo);
		
		BoardService boardService = new BoardService();
		BoardDto board = boardService.findBoardByBoardNo(boardNo);
		
		// 2. JSP에서 읽을 수 있도록 데이터 전달 ( request 객체에 저장 )
		req.setAttribute("board", board);
		
		// 3. 응답 컨텐츠 생산 ( JSP로 forward 이동 )		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp");
		rd.forward(req, resp); // 지정된 경로로 forward 이동
	}

}
