package com.jsv.mvChart.service;

import java.util.List;

import com.jsv.mvChart.dto.MvChartDTO;

public interface MvChartService {

	//무비차트 목록조회
	public List<MvChartDTO> getmvChart() throws Exception;
	
	//무비차트 상세조회
	public MvChartDTO getmvdetail(int cno)throws Exception;
	
	
}
