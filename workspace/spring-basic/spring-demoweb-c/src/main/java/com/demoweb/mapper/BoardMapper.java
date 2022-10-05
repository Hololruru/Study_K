package com.demoweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demoweb.dto.BoardAttachDto;
import com.demoweb.dto.BoardDto;

public interface BoardMapper {
	
	void insertBoard(BoardDto board);
	void insertBoard2(BoardDto board);
	List<BoardDto> selectBoardByPage(@Param("from") int from, @Param("count") int count);
	int selectBoardCount();
	BoardDto selectBoardByBoardNo(int boardNo);
	List<BoardAttachDto> selectBoardAttachByBoardNo(int boardNo);
}






