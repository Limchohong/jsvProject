package com.jsv.admin.service;


import java.util.Map;

import com.jsv.event.dto.EventDTO;

public interface AdminEventService {
	//(관리자)이벤트 등록
	public  int newEvent(Map eventMap) throws Exception;

	//관리자 이벤트 내용수정
	public int updateEvent(EventDTO eventdto) throws Exception;
	
	//관리자 이미지 수정
	public int updatEimg(EventDTO evnetdto) throws Exception;
	
	//(관리자)이벤트 삭제
	public void delEvent(int eno) throws Exception;
		
	//관리자 정보조회
	public int selInfo(int eno) throws Exception;
		
}


