package com.demoweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.demoweb.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	@Select("SELECT boardno, title, writer, readcount, regdate, deleted " +
			"FROM board " +
			"ORDER BY boardno DESC " +
			"LIMIT #{ from },#{ count }")
	List<BoardDto> selectBoardByPage(@Param("from")int from, @Param("count")int count);

}
