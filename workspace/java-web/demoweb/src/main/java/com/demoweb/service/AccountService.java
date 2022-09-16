package com.demoweb.service;

import com.demoweb.dao.MemberDao;
import com.demoweb.dto.MemberDto;

public class AccountService {
	
	// 1. 회원 가입 : 회원 데이터를 받아서 필요한 처리 ( 데이터베이스 저장은 Dao에 전달 )
	public void registerMember(MemberDto member) {
		
		MemberDao memberDao = new MemberDao();
		memberDao.insertMember(member);
		
	}

}
