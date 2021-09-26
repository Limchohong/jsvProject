package com.jsv.mvfinder.service;

import java.util.List;

import com.jsv.mvChart.dto.MvChartDTO;
import com.jsv.mvfinder.dto.Search;

public interface MvfinderService {

	//무비차트 전체목록
	public List<MvChartDTO> mvfinderList(Search search) throws Exception;
	
	//게시물 개수 확인
	public int getMvCnt(Search search) throws Exception;
	
}
