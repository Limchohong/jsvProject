package com.jsv.admin.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.jsv.event.dto.EventDTO;

public interface AdminEventDAO {


	//(관리자)이벤트 등록
	public int newEvent(Map eventMap) throws DataAccessException;
	
	//이벤트 내용 수정처리
	public int updateEvent(EventDTO eventdto)throws DataAccessException;
	
	//이벤트 이미지 수정처리
	public int updatEimg(EventDTO eventdto)throws DataAccessException;
	
	//(관리자)이벤트 삭제
	public void delEvent(int eno) throws DataAccessException;
		
	//관리자 정보조회 
	public int selInfo(int eno) throws DataAccessException;
}
