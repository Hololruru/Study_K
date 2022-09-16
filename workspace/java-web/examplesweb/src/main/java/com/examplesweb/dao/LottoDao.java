package com.examplesweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.examplesweb.dto.LottoDto;

public class LottoDao {
	
	// 번호 저장 : 사용자가 입력한 번호를 받아서 (전달인자) 데이터베이스에 저장
	public void insertLotto(LottoDto lottoDto) {
		Connection conn = null;			// 연결과 관련된 JDBC 호출 규격 ( 인터페이스 )
		PreparedStatement pstmt = null;	// 명령 실행과 관련된 JDBC 호출 규격 ( 인터페이스 )		
		
		try {
			// 1. Driver 등록
			// DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 연결 및 연결 객체 가져오기
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb", 		// 데이터베이스 연결 정보
					"testuser", "mysql"); 						// 데이터베이스 계정 정보
			
			// 3. SQL 작성 + 명령 객체 가져오기
			String sql = 
					"INSERT INTO lotto " +
					"VALUES (?, ?, ?, ?, ?, ?)"; // ? : 나중에 채워질 영역 표시
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lottoDto.getNo1());	// SQL의 1번째 ?를 대체할 데이터
			pstmt.setInt(2, lottoDto.getNo2());	// SQL의 2번째 ?를 대체할 데이터
			pstmt.setInt(3, lottoDto.getNo3());	// SQL의 3번째 ?를 대체할 데이터
			pstmt.setInt(4, lottoDto.getNo4());	// SQL의 4번째 ?를 대체할 데이터
			pstmt.setInt(5, lottoDto.getNo5());	// SQL의 5번째 ?를 대체할 데이터
			pstmt.setInt(6, lottoDto.getNo6());	// SQL의 6번째 ?를 대체할 데이터
			
			// 4. 명령 실행
			pstmt.executeUpdate(); // executeUpdate : select 이외의 SQL에 사용하는 메서드
			
			// 5. 결과 처리 (결과가 있다면 - SELECT 명령을 실행한 경우)				
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 개발 용도로 사용
		} finally {
			// 6. 연결 닫기			
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
	}

}
