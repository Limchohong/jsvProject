package com.jsv.mvfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.mvChart.dto.MvChartDTO;
import com.jsv.mvfinder.dao.MvfinderDAO;
import com.jsv.mvfinder.dto.Search;

@Service("mvfinderservice")
public class MvfinderServiceImpl implements MvfinderService{

	
	@Autowired
	private MvfinderDAO mvfinderdao;

	
	//무비파인더 목록
	@Override
	public List<MvChartDTO> mvfinderList(Search search) throws Exception {
		return mvfinderdao.mvfinderList(search);
	}

	
	//총 게시물 확인하기
	@Override
	public int getMvCnt(Search search) throws Exception {
		return mvfinderdao.getMvCnt(search);
	}


	
}
