package com.jsv.mgz.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.jsv.mgz.dto.MagazineDTO;
import com.jsv.mgz.dto.MfileDTO;

public interface MagazineDAO {


	//매거진 목록조회
	public List<MagazineDTO> getMList()throws DataAccessException;
	
	//매거진 상세조회- 제품정보
	public  MagazineDTO  getMgzDetail(int mno) throws DataAccessException;

	//매거진상세조회 - 제품이미지들정보
	public List<MfileDTO> getMgzDImg(int mno) throws DataAccessException;
}
