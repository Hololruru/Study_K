package com.demoweb.service;

import java.util.List;

import com.demoweb.dao.BoardDao;
import com.demoweb.dto.BoardDto;

public class BoardService {
	
	private BoardDao boardDao = new BoardDao();
	
	// 사용자가 입력한 게시글 데이터를 받아서 글쓰기 처리
	public void writeBoard(BoardDto board) {
		
		// BoardDao boardDao = new BoardDao();
		boardDao.insertBoard(board);
		
	}
	
	// 모든 게시글 조회해서 반환
	public List<BoardDto> findAllBoard() {
		
		// BoardDao boardDao = new BoardDao();
		List<BoardDto> boards = boardDao.selectAllBoard();
		return boards;
		
	}

}
