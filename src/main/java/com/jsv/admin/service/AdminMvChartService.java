package com.jsv.admin.service;

import java.util.Map;

public interface AdminMvChartService {

	
	//(관리자)무비차트 등록
	public int newMvChart(Map chartMap) throws Exception;
	
	//무비차트 삭제
	public void delMyChart(int cno)throws Exception;
}
