package com.jsv.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.jsv.mgz.dto.MagazineDTO;
import com.jsv.mgz.dto.MfileDTO;

public interface AdminMgzDAO {

	//관리자 매거진 게시물 등록처리(내용)
	public int newMgz(Map newMgzMap)throws DataAccessException;
		
	//관리자 매거진 다중 이미지 등록처리
	public void newMgzImg(List fileList)throws DataAccessException;
	
	//관리자 게시물 삭제
	public void delMgz(int mno)throws DataAccessException;
	
	//매거진 상세조회- 제품정보
	public  MagazineDTO  getMgzDetail(int mno) throws DataAccessException;

	//매거진상세조회 - 제품이미지들정보
	public List<MfileDTO> getMgzDImg(int mno) throws DataAccessException;
	
	//매거진 수정처리 - 정보
	public int updateMinfo(Map mgzMap)throws DataAccessException;
	
	//매거진 수정처리 - 이미지
	public void updateMimg(MfileDTO mfiledto)throws DataAccessException;
}
