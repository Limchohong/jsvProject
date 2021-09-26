package com.jsv.mvfinder.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.jsv.mvChart.dto.MvChartDTO;
import com.jsv.mvfinder.dto.Search;

public interface MvfinderMapper {

		//무비파인드 목록 
		public List<MvChartDTO> mvfinderList(Search search) throws Exception;
		
		//총 게시글 개수 확인
		public int getMvCnt(Search search) throws Exception;
}
