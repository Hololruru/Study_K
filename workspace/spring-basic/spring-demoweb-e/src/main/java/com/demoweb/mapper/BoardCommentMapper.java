package com.demoweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demoweb.dto.BoardCommentDto;

@Mapper
public interface BoardCommentMapper {
	
	@Insert("INSERT INTO boardcomment (boardno, writer, content, groupno, step, depth) " +
			"VALUES (#{ boardNo }, #{ writer }, #{ content }, -1, 1, 0)")
	@Options(useGeneratedKeys = true, keyColumn = "commentno", keyProperty = "commentNo")
	void insertComment(BoardCommentDto comment);
	
	@Update("UPDATE boardcomment " +
			"SET groupNo = #{ groupNo } " +
			"WHERE commentNo = #{ commentNo }")
	void updateGroupNo(@Param("commentNo")int commentNo, @Param("groupNo")int groupNo);
	
	@Select("SELECT commentno, writer, content, regdate, deleted, groupno, step, depth " +
			"FROM boardcomment " +
			"WHERE boardno = #{ boardNo }")
	List<BoardCommentDto> selectCommentByBoardNo(int boardNo);

}
