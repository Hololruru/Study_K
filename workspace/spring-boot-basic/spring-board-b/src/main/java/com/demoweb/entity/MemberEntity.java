package com.demoweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="tbl_member")
public class MemberEntity {

	@Id
	private String memberId;
	@Column
	private String passwd;
	@Column
	private String email;
	
	@Column
	private String userType = "user";
	@Column
	private Date regDate = new Date();
	@Column
	private boolean active = true;
	
}
