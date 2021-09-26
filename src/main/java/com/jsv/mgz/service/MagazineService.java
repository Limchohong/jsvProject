package com.jsv.mgz.service;

import java.util.List;
import java.util.Map;

import com.jsv.mgz.dto.MagazineDTO;

public interface MagazineService {

	//매거진 목록보기
	public List<MagazineDTO> getMList() throws Exception;
	
	//매거진 상세보기-map으로 합쳐놓음
	public Map getMgzDetail(int mno)throws Exception;
}
