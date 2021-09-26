package com.jsv.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.admin.dao.AdminEventDAO;
import com.jsv.event.dto.EventDTO;

@Service("adminEventservice")
public class AdminEventServiceImpl implements AdminEventService {

	@Autowired
	private AdminEventDAO admineventdao;
	//관리자 이벤트등록
	@Override
	public  int newEvent(Map eventMap) throws Exception {
		//상품테이블에  insert하는 dao메서드호출
		 int eno= admineventdao.newEvent(eventMap);
		 EventDTO eventdto = new EventDTO ();
		 eventdto.setEno(eno);
			
			return eno;
		 
	}
	
	//관리자 이벤트 삭제
	@Override
	public void delEvent(int eno) throws Exception {
			admineventdao.delEvent(eno);
	}


	//관리자 정보조회
	@Override
	public int selInfo(int eno) throws Exception {
		int deleno =admineventdao.selInfo(eno);
		return deleno;
	}

	//관리자 이벤트 내용 수정
	@Override
	public int updateEvent(EventDTO evnetdto) throws Exception {
		int result = admineventdao.updateEvent(evnetdto);
		return result;
	}

	//관리자 이벤트 이미지 수정
	@Override
	public int updatEimg(EventDTO eventdto) throws Exception {
		int result = admineventdao.updatEimg(eventdto);
		return result;
	}

	
	
	
}
