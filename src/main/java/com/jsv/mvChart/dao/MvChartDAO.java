package com.jsv.mvChart.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.jsv.mvChart.dto.MvChartDTO;

public interface MvChartDAO {

	//무비차트 목록조회
	public List<MvChartDTO> getmvChart() throws DataAccessException;

	//무비차트 상세조회
	public MvChartDTO getmvdetail(int cno) throws DataAccessException;
	
	
}

