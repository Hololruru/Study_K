package com.demoweb.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data // 모든 변수에 대해 getter, setter 자동 생성, 기본 생성자, toString, ....
public class MemberDto {
	
	@NotBlank
	private String memberId;
	@NotBlank
	private String passwd;
	@NotBlank
	private String email;
	
	private String userType;
	private Date regDate;
	private boolean active;
	


}
