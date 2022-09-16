package com.demoweb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/account/login.action" })
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 요청 처리
		//2. JSP가 읽을 수 있도록 request에 데이터 저장
		//3. jsp로 forward 이동
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/account/login.jsp");
		rd.forward(req, resp); // 지정된 경로로 forward 이동
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		
		//1-1. 요청 데이터 읽기
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");

		System.out.printf("[%s][%s]\n", memberId, passwd);
		
		// 데이터베이스에서 데이터 조회
		Connection conn = null;			// 연결과 관련된 JDBC 호출 규격 ( 인터페이스 )
		PreparedStatement pstmt = null;	// 명령 실행과 관련된 JDBC 호출 규격 ( 인터페이스 )
		ResultSet rs = null;			// 결과 처리와 관련된 JDBC 호출 규격 ( 인터페이스 )
		boolean valid = false;
		try {
			// 1. Driver 등록
			// DriverManager.registerDriver(new Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 연결 및 연결 객체 가져오기
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb",	 	// 데이터베이스 연결 정보
					"testuser", "mysql"); 						// 데이터베이스 계정 정보
			
			// 3. SQL 작성 + 명령 객체 가져오기
			String sql = 
					"SELECT memberid, email, usertype, regdate, active " +
					"FROM member " +
					"WHERE memberid = ? " + // ? : 나중에 채워질 영역 표시
					"      AND " + 
					"      passwd = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);	// SQL의 1번째 ?를 대체할 데이터
			pstmt.setString(2, passwd);		// SQL의 2번째 ?를 대체할 데이터
			
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // executeQuery : select 일 때 사용하는 메서드
			
			// 5. 결과 처리 (결과가 있다면 - SELECT 명령을 실행한 경우)
			if (rs.next()) {	// 결과 집합의 다음 행으로 이동
				valid = true;
			}			
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 개발 용도로 사용
		} finally {
			// 6. 연결 닫기
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		if (valid) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
		// 한 작업 사이클이 종료되면 redirect로 이동
		resp.sendRedirect("/demoweb/home.action");
	}

}








