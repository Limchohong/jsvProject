package com.jsv.event.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.jsv.event.dto.EventDTO;

public interface EventDAO {

	//이벤트 목록조회
	public List<EventDTO> getElist() throws DataAccessException;
	
	//이벤트 상세조회
	public EventDTO getEdetail(int eno) throws DataAccessException;
}
