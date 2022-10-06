package com.demoweb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.demoweb.dto.BoardCommentDto;

@Mapper
public interface BoardCommentMapper {
	
	@Insert("INSERT INTO boardcomment (boardno, writer, content, groupno, step, depth) " +
			"VALUES (#{ boardNo }, #{ writer }, #{ content }, -1, 1, 0")
	void insertComment(BoardCommentDto comment);

}
