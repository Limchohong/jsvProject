package com.jsv.mvfinder.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jsv.mvChart.dto.MvChartDTO;
import com.jsv.mvfinder.dto.Search;

@Repository("mvfinderdao")
public class MvfinderDAOImpl implements MvfinderDAO {

	@Autowired
	private SqlSession sqlsession;

	
	//목록 다뽑기
	@Override
	public List<MvChartDTO> mvfinderList(Search search) throws Exception {
		MvfinderMapper mapper=sqlsession.getMapper(MvfinderMapper.class);
		return mapper.mvfinderList(search);
	}

	
	//게시물 개수 확인
	@Override
	public int getMvCnt(Search search) throws Exception {
		MvfinderMapper mapper= sqlsession.getMapper(MvfinderMapper.class);
		return mapper.getMvCnt(search);
	}

	

}
