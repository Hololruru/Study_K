package com.examplesweb.service;

import com.examplesweb.dao.LottoDao;
import com.examplesweb.dto.LottoDto;

public class LottoService {
	
	// 로또 번호를 받아서 필요한 처리를 수행 (Dao에 전달)
	public void registerLotto(LottoDto lottoDto) {
		LottoDao lottoDao = new LottoDao();
		lottoDao.insertLotto(lottoDto);
	}

}
