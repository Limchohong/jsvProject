package com.jsv.event.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jsv.event.dto.EventDTO;

@Repository("eventdao")
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SqlSession sqlsession;
	
	//이벤트 목록조회
	@Override
	public List<EventDTO> getElist() throws DataAccessException {
		System.out.println("진입");
		List<EventDTO> Elist = sqlsession.selectList("event.getElist");
		return Elist;
		
	}

	//이벤트 상세조회
	@Override
	public EventDTO getEdetail(int eno) throws DataAccessException {
		return sqlsession.selectOne("event.getEdetail", eno);
	}

	
	
}
