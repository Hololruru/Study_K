package com.demoweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.demoweb.dto.BoardAttachDto;
import com.demoweb.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	@Select("SELECT boardno, title, writer, readcount, regdate, deleted " +
			"FROM board " +
			"ORDER BY boardno DESC " +
			"LIMIT #{ from },#{ count }")
	List<BoardDto> selectBoardByPage(@Param("from")int from, @Param("count")int count);
	
	@Select("SELECT boardno, title, writer, content, readcount, regdate " +
			"FROM board " +
			"WHERE boardno = #{ boardNo } AND deleted = FALSE")
	BoardDto selectBoardByBoardNo(int boardNo);
	
	@Select("SELECT attachno, boardno, userfilename, savedfilename, downloadcount " +
			"FROM boardattach " +
			"WHERE boardno = #{ boardNo } ")
	List<BoardAttachDto> selectBoardAttachByBoardNo(int boardNo);

}
