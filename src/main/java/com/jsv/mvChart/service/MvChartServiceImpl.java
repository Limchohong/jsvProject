package com.jsv.mvChart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.mvChart.dao.MvChartDAO;
import com.jsv.mvChart.dto.MvChartDTO;
@Service("mvchartservice")
public class MvChartServiceImpl implements MvChartService {

	@Autowired
	private MvChartDAO mvchartdao;
	
	//무비차트목록
	@Override
	public List<MvChartDTO> getmvChart() throws Exception {
		List<MvChartDTO> mvlist = mvchartdao.getmvChart();
		return mvlist;
	}
	
	//무비차트 상세조회
	@Override
	public MvChartDTO getmvdetail(int cno) throws Exception {
		return mvchartdao.getmvdetail(cno);
	}
	
	

	
	

}
