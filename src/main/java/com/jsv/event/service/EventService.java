package com.jsv.event.service;

import java.util.List;
import java.util.Map;

import com.jsv.event.dto.EventDTO;

public interface EventService {

	//이벤트 목록조회
	public List<EventDTO> getElist() throws Exception;
	
	//이벤트 상세조회
	public EventDTO getEdetail(int eno) throws Exception;

}
