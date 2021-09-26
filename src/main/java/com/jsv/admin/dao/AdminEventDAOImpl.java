package com.jsv.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jsv.event.dto.EventDTO;

@Repository("adminEventdao")
public class AdminEventDAOImpl implements AdminEventDAO {

	@Autowired
	private SqlSession sqlsession;
	
	//관리자 이벤트 상품등록
	@Override
	public int newEvent(Map eventMap) throws DataAccessException {		
			 int result=sqlsession.insert("adminEvent.insertEvent",eventMap);
			//여기에서는 최소1개이상~ 최대4개의 이미지가   첨부되므로  
			//1~4가 return되어야 한다
			 System.out.println("상품이미지테이블에  입력된 데이터수(첨부파일수)="+result);
			 int eno = (Integer)eventMap.get("eno");
			 return eno;
		}

	//관리자 이벤트 삭제
	@Override
	public void delEvent(int eno) throws DataAccessException {	
		sqlsession.delete("adminEvent.deleteEvent", eno);
		
	}
	
	//상품조회
	@Override
	public int selInfo(int eno) throws DataAccessException {
		int deno = sqlsession.selectOne("adminEvent.selectInfo", eno);
		return deno;
	}
	
	//관리자 내용수정
	@Override
	public int updateEvent(EventDTO eventdto) throws DataAccessException {
		int result= sqlsession.update("adminEvent.updateContent", eventdto);
		System.out.println("내용수정 성공 행수"+result);
		return result;
	}

	//관리자 이미지 수정
	@Override
	public int updatEimg(EventDTO eventdto) throws DataAccessException {
		int result = sqlsession.update("adminEvent.updatEimg", eventdto);
		System.out.println("이미지 수정 성공행수"+result);
		return result;
	}


	
	
	
	
}