package com.jsv.admin.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("adminmvchartdao")
public class AdminMvChartDAOImpl implements AdminMvChartDAO {

	@Autowired
	private SqlSession sqlsession;
	
	//(관리자)무비차트 등록
	@Override
	public int newMvChart(Map chartMap) throws DataAccessException {
		int result = sqlsession.insert("adminMvChart.insertMvChart", chartMap);
		System.out.println("무비차트 등록 실행행수"+result);
		int cno = (Integer)chartMap.get("cno");
		return cno;
	}

	
	//관리자 무비차트 삭제
	@Override
	public void delMyChart(int cno) throws DataAccessException {
		sqlsession.delete("adminMvChart.delMychart", cno);
	}

}
