package com.demoweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demoweb.dto.BoardDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_board")
public class BoardEntity {
	
	public BoardDto exportBoardDto() {
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNo(boardNo);
		boardDto.setWriter(writer);
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDto.setReadCount(readCount);
		boardDto.setRegDate(regDate);
		boardDto.setDeleted(deleted);
		
		return boardDto;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int boardNo;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String writer;
	
	@Column(length = 1000, nullable = false)
	private String content;
	
	@Builder.Default
	@Column
	private Date regDate = new Date();
	
	@Builder.Default
	@Column
	private int readCount = 0;
	
	@Builder.Default
	@Column
	private boolean deleted = false;
	

}
