package com.jsv.admin.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface AdminMvChartDAO {

	

	//(관리자)무비차트 등록
	public int newMvChart(Map chartMap) throws DataAccessException;
	
	//관리자 무비차트 삭제
	public void delMyChart(int cno)  throws  DataAccessException;
	
}
