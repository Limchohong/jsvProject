package com.jsv.reserve.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts.tiles.taglib.GetAttributeTag;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jsv.reserve.dto.MovieDTO;
import com.jsv.reserve.dto.ReserveDTO;
import com.jsv.reserve.dto.TheaterDTO;

@Repository
public class ReserveDAOImpl implements ReserveDAO {

	@Autowired
	SqlSession session;
	
	@Override
	public boolean Reserve(ReserveDTO dto) {
		int count = session.insert("Reserve", dto);
		
		//count가 0보다 크면 true 아닐 경우 false 리턴
		return count > 0 ? true : false;
	}
	
	@Override
	public List<ReserveDTO> getReserveList(ReserveDTO dto){
		List<ReserveDTO> list = new ArrayList<ReserveDTO>();
		list = session.selectList("getReserveList", dto);
		return list;
	}
	
	@Override
	public List<ReserveDTO> getPayJoinTable(ReserveDTO dto){
		List<ReserveDTO> list = new ArrayList<ReserveDTO>();
		list = session.selectList("selectMapping", dto);
		return list;
	}
	
	@Override
	public List<TheaterDTO> getTheaterList(String str) throws DataAccessException{
		return session.selectList("reserveSpace.selectTheater", str);
	}
	
	@Override
	public List<MovieDTO> getMovieList() throws DataAccessException{
		return session.selectList("reserveSpace.selectMovie");
	}
}
