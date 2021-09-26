package com.jsv.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.jsv.mgz.dto.MfileDTO;

public interface AdminMgzService {

	//관리자 매거진 게시물 등록 = 내용 + 이미지
	public int newMgz(Map newMgzMap) throws Exception;
	
	//관리자 매거진 게시물 삭제
	public void delMgz(int mno)throws Exception;
	
	//매거진 상세보기-map으로 합쳐놓음
	public Map getMgzDetail(int mno)throws Exception;
	
	//매거진 수정처리 -
	public int updateMinfo(Map mgzMap)throws Exception;
	
	//매거진 수정처리 - 이미지
	public void updateMimg(MfileDTO mfiledto)throws Exception;
	
}
