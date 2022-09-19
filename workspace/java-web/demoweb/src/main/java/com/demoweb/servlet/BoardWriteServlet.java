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

import com.demoweb.dto.MemberDto;

@WebServlet(urlPatterns = { "/board/write.action" })
public class BoardWriteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인하지 않은 사용자는 로그인 화면으로 보내기
		HttpSession session = req.getSession();
		MemberDto member = (MemberDto)session.getAttribute("loginuser");
		if (member == null) { // 세션에 로그인 데이터 없음 -> 로그인하지 않은 사용자
			resp.sendRedirect("/demoweb/account/login.action");
			return;
		}
		
		// 1. 요청 처리
		
		
		// 2. JSP에서 읽을 수 있도록 데이터 전달 ( request 객체에 저장 )		
		// 3. 응답 컨텐츠 생산 ( JSP로 forward 이동 )		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/board/write.jsp");
		rd.forward(req, resp); // 지정된 경로로 forward 이동
	}

}
