package com.jsv.mvChart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jsv.mvChart.dto.MvChartDTO;

@Repository("mychartdao")
public class MvChartDAOImpl implements MvChartDAO {


	@Autowired
	private SqlSession sqlsession;
	
	//무비차트 목록조회
	@Override
	public List<MvChartDTO> getmvChart() throws DataAccessException {
		List<MvChartDTO> chartlist =sqlsession.selectList("mvChart.getmvChart");
		return chartlist;
	}
	
	//무비차트 상세조회
	@Override
	public MvChartDTO getmvdetail(int cno) throws DataAccessException {
		return sqlsession.selectOne("mvChart.getmvDtail", cno);
	}


	
}
