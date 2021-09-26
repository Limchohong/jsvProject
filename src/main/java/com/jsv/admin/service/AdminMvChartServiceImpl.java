package com.jsv.admin.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.admin.dao.AdminMvChartDAO;
import com.jsv.mvChart.dto.MvChartDTO;

@Service("adminmvcService")
public class AdminMvChartServiceImpl implements AdminMvChartService {

	
	@Autowired
	private AdminMvChartDAO adminmvchartdao;
	
	
	//무비차트 insert
	@Override
	public int newMvChart(Map chartMap) throws Exception {
		int cno =adminmvchartdao.newMvChart(chartMap);
		MvChartDTO mvchartdto = new MvChartDTO();
		mvchartdto.setCno(cno);
		return cno;
	}


	//무비차트 삭제
	@Override
	public void delMyChart(int cno) throws Exception {
		adminmvchartdao.delMyChart(cno);
	}

}
