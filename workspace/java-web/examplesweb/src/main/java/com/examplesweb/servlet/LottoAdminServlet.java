package com.examplesweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lotto-admin" })
public class LottoAdminServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 처리
		// 2. JSP에서 사용하도록 데이터 request에 저장
		// 3. JSP로 이동
		RequestDispatcher rd = req.getRequestDispatcher("lotto-admin.jsp");
		rd.forward(req, resp); // 지정된 경로로 forward 이동
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		for (int i = 1; i < 7; i++) {
			System.out.println(req.getParameter("no" + i));
		}
		
	}

}












