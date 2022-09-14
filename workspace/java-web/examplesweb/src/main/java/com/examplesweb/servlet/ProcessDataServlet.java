package com.examplesweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/process-data")
public class ProcessDataServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 데이터 읽기
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println(name + " / " + email);
		
		PrintWriter out = response.getWriter();
		out.println("<h1>" + name + " / " + email + "</h1>");
	}

}
