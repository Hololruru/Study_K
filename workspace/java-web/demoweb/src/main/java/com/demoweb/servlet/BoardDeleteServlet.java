package com.demoweb.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.dto.BoardDto;
import com.demoweb.dto.MemberDto;
import com.demoweb.service.BoardService;

@WebServlet(urlPatterns = { "/board/delete.action" })
public class BoardDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberDto member = (MemberDto)session.getAttribute("loginuser");
		
		if (member == null) { // 로그인 하지 않은 사용자인 경우
			resp.sendRedirect("/demoweb/account/login.action");
			return;
		}
		
		// 1. 요청 처리
		String sBoardNo = req.getParameter("boardNo");
		int boardNo = Integer.parseInt(sBoardNo);
		BoardService boardService = new BoardService();		
		BoardDto board = boardService.findBoardByBoardNo(boardNo);
		
		if (!board.getWriter().equals(member.getMemberId())) { // 작성자와 로그인한 사용자가 다른 경우
			resp.sendRedirect("list.action");
			return;
		}
		
		boardService.deleteBoard(boardNo); // 삭제 처리 -> BoardService에 요청
		
		// 2. JSP에서 읽을 수 있도록 데이터 전달 ( request 객체에 저장 )
		
		// 3. 응답 컨텐츠 생산 ( JSP로 forward 이동 )		
		resp.sendRedirect("list.action");
	}

}









