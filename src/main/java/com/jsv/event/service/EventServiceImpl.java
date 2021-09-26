package com.jsv.event.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.event.dao.EventDAO;
import com.jsv.event.dto.EventDTO;
@Service("eventServie")
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDAO eventdao;
	
	//이벤트 목록조회
	@Override
	public List<EventDTO> getElist() throws Exception {
		List<EventDTO> elist= eventdao.getElist();
		return elist;
	}

	//이벤트 상세조회
	@Override
	public EventDTO getEdetail(int eno) throws Exception {
		
		return eventdao.getEdetail(eno);
		
	}

}
